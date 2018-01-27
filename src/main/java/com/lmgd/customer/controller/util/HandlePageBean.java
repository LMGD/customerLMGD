package com.lmgd.customer.controller.util;

import com.lmgd.customer.biz.ICstServiceBiz;
import com.lmgd.customer.model.CstService;
import com.lmgd.customer.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HandlePageBean {
    @Autowired
    private ICstServiceBiz cstServiceBiz;


    public HandlePageBean() {
    }

    /**
     * 初始化分页参数
     */
    public static PageBean initPageBean(HttpServletRequest request, Model model){
        PageBean pageBean=new PageBean();
        pageBean.setRequest(request);
        model.addAttribute("pageBean",pageBean);
        return pageBean;
    }

    /**
     * @服务模块的分页，‘营销管理’要分页的话，得重新写PageTag、和 请求处理方法doPage
     */
    //分页的控制器
    @RequestMapping("/doPage")
    public String doPage(HttpServletRequest request, Model model,CstService service){
        //1.是对服务的哪个list页面,分页？eg:pageSvrStatus='已分配',那么是对'服务分配List',状态为‘已分配’的分页.
        //其实就模糊查询
        String pageSvrStatus=(String) request.getSession().getAttribute("pageSvrStatus");
        service.setSvrStatus(pageSvrStatus);

        //2.服务处理List,只能查自己的。
       Integer  pageSvrDealId= (Integer)request.getAttribute("pageSvrDealId");
       if(null!=pageSvrDealId){
           service.setSvrDealId(pageSvrDealId+0L);
       }

        List<CstService> serviceList = this.cstServiceBiz.list(service,HandlePageBean.initPageBean(request, model));
        model.addAttribute("serviceList",serviceList);

        //2.要跳转的地址
        String forward= (String) request.getSession().getAttribute("forward");
        System.out.println("要跳转的地址...:"+forward);
        return  forward;
    }

}
