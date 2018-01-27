package com.lmgd.customer.controller.menuController;

import com.lmgd.customer.biz.ISysTreeNodeBiz;
import com.lmgd.customer.controller.util.HandlePageBean;
import com.lmgd.customer.model.SysTreeNode;
import com.lmgd.customer.util.JsonUtils;
import com.lmgd.customer.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysTreeNodeController{

    @Autowired
    private ISysTreeNodeBiz sysTreeNodeBiz;

    //防止session会话过期:JSP发送请求给服务器，让服务器保持session处于活动状态
    @RequestMapping("/doFreshJsp")
    public String doFreshJsp(){
        System.out.println("...防止session会话过期的请求方法.----------.doFreshJsp.--------...");
        return null;
    }

    @RequestMapping("/toMain")
    public String toMain(){
        return "redirect:listTreeNode?forward=null";
    }

    //树形菜单
    @RequestMapping("/listTreeNode")
    public String listTreeNode(SysTreeNode treeNode, HttpServletRequest request, Model model, HttpServletResponse response)throws ServletException, IOException {
        // 第二步:把TreeNode里的数据----》easyui-tree支持的json格式[{'id':[{},{}]}]
        // 1.初始化分页参数
        PageBean pageBean = HandlePageBean.initPageBean(request, model);
        pageBean.setRequest(request);
        // 4. 跳转
        String forward = request.getParameter("forward");

        // 2. 树控件只有属性id,so你就用id 但id其实是parent_node_id
        String parentNodeId = request.getParameter("id");
        treeNode.setParentNodeId(parentNodeId);

        // listTreeNode--->json[{},{}],so得转换成easyui-tree需要的JSON格式
        List<SysTreeNode> listTreeNode = sysTreeNodeBiz.list(treeNode,pageBean);

        // 3. listTreeNode---->转换成easyui-tree需要的JSON格式
        List<Map<String, Object>> nodes = new ArrayList<Map<String, Object>>();
        Map<String, Object> node = null;
        Map<String, Object> attributes = null;
        for (SysTreeNode t : listTreeNode) {
            node = new HashMap<String, Object>();
            // tree里面内置节点
            node.put("id", t.getTreeNodeId());
            node.put("text", t.getTreeNodeName());
            node.put("state", t.isLeaf() ? "open" : "closed");

            // 给tree添加自定义url属性（attributes：绑定该节点的自定义属性。)
            attributes = new HashMap<String, Object>();
            attributes.put("url", t.getUrl());
            node.put("attributes", attributes);

            nodes.add(node);
        }
        model.addAttribute("nodes",nodes);

        if ("null".equals(forward)) {// 就不跳 而且不转为 JSON格式
            model.addAttribute("nodes",nodes);
        } else {
            // 表示允许所有来源进行跨域访问(这行代码必须要，不然会报错)
            response.setHeader("Access-Control-Allow-Origin", "*");
            // 设置响应头,数据库 传数据到页面，so 是响应，是下载 就是输出流。
            response.setContentType("text/plain;charset=utf-8");
            ServletOutputStream os = response.getOutputStream();
            JsonUtils.writeValue(nodes, os);
        }
        System.out.println("LMGD---------------LMGD");
        return "index";
   };
}
