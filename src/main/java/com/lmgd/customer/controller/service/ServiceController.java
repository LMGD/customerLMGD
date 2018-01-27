package com.lmgd.customer.controller.service;

import com.lmgd.customer.biz.ICstServiceBiz;
import com.lmgd.customer.biz.ISysDictBiz;
import com.lmgd.customer.controller.util.HandlePageBean;
import com.lmgd.customer.model.CstService;
import com.lmgd.customer.model.SysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @TODO:toAddServiceJsp： 服务创建人id(客户经理)、名字(svrCreateId、svrCreateBy)--->暂时写死
 * @TODO:doShare分配服务: svr_due_id、svr_due_to--->指派给人ID 、指派给人名字(销售主管)--->暂时写死
 * @TODO:doDealList客户经理id(来自登入的当前用户),每个客户经理只能查到 自己的.--->暂时写死
 */
/**
 *@TODO !!!!! 服务的 分配人id（2：小销）、创建人id（6：邓林妹）、处理人id（5:小小客）,暂时写死
 */

/**
 *  @a. 服务分配 -> 查的是‘新创建的服务’  ---> 因为 ‘新创建的’才有‘分配’功能  --->查的是所有‘客户经理’创建的服务
 *  @b. 服务处理 ----> 查的是‘已分配的服务’--》。。分配的才能处理
 *  @c. 服务反馈  ---> .......'已经处理的服务' ---》。。处理的服务  才可已反馈
 *  @d. 服务归档  ---> 查的是 ‘已经处理’ 而且 满意度 >=3
 */
@Controller
public class ServiceController {

    @Autowired
    private ICstServiceBiz cstServiceBiz;

    //节点表
    @Autowired
    private ISysDictBiz sysDictBiz;//根据dict_name 模糊查询

    //初始化数据
    @ModelAttribute
    public void init(Model model,CstService service){
        //0.服务类型
        SysDict sd1=new SysDict();
        sd1.setDictName("服务类型");
        List<SysDict> serviceTypeList = this.sysDictBiz.list(sd1);
        model.addAttribute("serviceTypeList",serviceTypeList);

        //3.模糊查条件svrType
        model.addAttribute("svrType",service.getSvrType());
    }

    /**
     * add
     */
    @RequestMapping("/doAddService")
    public String doAddService(CstService service,Model model){
        //1. 服务创建人id(客户经理)、名字(svrCreateId、svrCreateBy)
        //1的答案：toAddServiceJsp的时候保存啦
        //2.
        this.cstServiceBiz.add(service);
        return "redirect:toAddServiceJsp";
    }

    @RequestMapping("/toAddServiceJsp")
    public String toAddServiceJsp(Model model,HttpServletRequest request){
        //服务创建人id(客户经理)、名字(svrCreateId、svrCreateBy)
        Long  usrId=(Long) request.getSession().getAttribute("usrId");
        String  usrName=(String) request.getSession().getAttribute("usrName");

        request.getSession().setAttribute("svrCreateId",usrId);
        request.getSession().setAttribute("svrCreateBy",usrName);
        return "addService";//JSP页面
    }

    //A.(服务分配List -> 查的是‘新创建的服务’ ---> 因为 ‘新创建的’才有‘分配’功能-->查的是所有‘客户经理’创建的服务
    @RequestMapping("/doListService")
    public String doListService(CstService service, Model model, HttpServletRequest request){
        //2.'新创建'服务的查全部
        service.setSvrStatus("新创建");
        List<CstService> serviceList = this.cstServiceBiz.list(service, HandlePageBean.initPageBean(request, model));
        model.addAttribute("serviceList",serviceList);

        //3.分页需要跳转的地方
        request.getSession().setAttribute("forward","listService");
        //4.是对‘服务分配List页面’分页
        request.getSession().setAttribute("pageSvrStatus","新创建");
        return "listService";
    }

    /**
     *  分配服务
     */
    //分配：把 svr_deal_id、svr_deal_by、svr_id--->jsp需要传的数据
    //需要传的字段： svr_due_id、svr_due_to、svr_due_date、svr_deal_id、svr_deal_by  where svr_id
    @RequestMapping("/doShare")
    public String doShare(CstService service,HttpServletRequest request){
        //0.权限
        //销售主管(roleId=2),对客户服务进行分配。
        long roleId=(Long) request.getSession().getAttribute("roleId");
        if(roleId==3||roleId==4){//roleId>2的为‘客户经理 ’‘高管’
            request.getSession().setAttribute("message","你没有此权限！！");
            return "redirect:doListService";//跳到'营销机会管理List'
        }
        /**
         * 分配功能
         */
        //1.svr_due_id、svr_due_to--->指派给人ID 、指派给人名字(销售主管)
        //指派人（是登录进来的用户）
        Long  usrId=(Long) request.getSession().getAttribute("usrId");
        String  usrName=(String) request.getSession().getAttribute("usrName");

        service.setSvrDueId(usrId);
        service.setSvrDueTo(usrName);
        service.setSvrDueDate(new java.sql.Timestamp(System.currentTimeMillis()));//指派时间

        //2.分配服务（指定‘处理人Id、处理人’同时svr_status字段---改为--》'已分配'）
        //需要传的字段： svr_due_id、svr_due_to、svr_due_date、svr_deal_id、svr_deal_by  where svr_id
        this.cstServiceBiz.edit_doShare(service);
        return "redirect:doListService";
    }

    /**
     *  处理服务页面 和 处理服务
     *  @1:每个客户经理只能查到 自己的
     *  @2：一点‘处理服务’页面---》a.先查单个，b.再edit服务
     */
    //处理服务页面的list(查的是自己的、‘已分配’的)
    //B. 服务处理 ----> 查的是‘已分配的服务’--》已分配的才能处理
    @RequestMapping("/doDealList")
    public String doDealList(CstService service,Model model, HttpServletRequest request){
        //1.客户经理id(来自登入的当前用户)
        Long  usrId=(Long) request.getSession().getAttribute("usrId");
        service.setSvrDealId(usrId);
        service.setSvrStatus("已分配");

        //2.查出该客户经理应该处理的服务
        List<CstService> serviceList = this.cstServiceBiz.list(service,HandlePageBean.initPageBean(request, model));
        model.addAttribute("serviceList",serviceList);

        //3.分页需要跳转的地方
        request.getSession().setAttribute("forward","listService");
        //4.是对‘服务分配List页面’分页,而且只能查自己的。
        //这个存session里面、request里面都可以。每次请求不同，key=pageSvrStatus相同，值不同。
        request.getSession().setAttribute("pageSvrStatus","已分配");
        request.setAttribute("pageSvrDealId",5);  //不存session里面，每次请求不同。
        return "listDoDeal";
    }

    //处理服务页面
    @RequestMapping("/toDealServiceJsp")
    public  String toDealServiceJsp(CstService service,Model model){
        //1.服务的查单个
        CstService s = this.cstServiceBiz.load(service.getSvrId());
        model.addAttribute("s",s);
        return "doDealService";
    }

    //处理服务（svr_deal_date、svr_deal）
    @RequestMapping("/doDealService")
    public  String doDealService(CstService service,Model model){
        //1.服务处理时间
        service.setSvrDealDate(new java.sql.Timestamp(System.currentTimeMillis()));
        //2.处理服务
        this.cstServiceBiz.doDealService(service);
        //3.通过服务id---->修改服务为‘已处理’--》‘已处理’的会在‘反馈i服务的list’
        this.cstServiceBiz.editService_isDeal(service);
        return "redirect:doDealList";//处理服务list
    }

    /**
     * C. 服务反馈  ---> 查的是'已经处理的服务' ---》。。处理的服务  才有‘反馈’功能
     */
    @RequestMapping("/doReturnList")
    public String doReturnList(CstService service,Model model, HttpServletRequest request){
        //1.客户经理id(来自登入的当前用户)
        Long  usrId=(Long) request.getSession().getAttribute("usrId");
        service.setSvrDealId(usrId);
        service.setSvrStatus("已处理");

        //2.查出该客户经理应该处理的服务
        List<CstService> serviceList = this.cstServiceBiz.list(service,HandlePageBean.initPageBean(request, model));
        model.addAttribute("serviceList",serviceList);

        //3.分页需要跳转的地方
        request.getSession().setAttribute("forward","listDoReturn");
        //4.是对‘服务分配List页面’分页,而且只能查自己的。
        request.getSession().setAttribute("pageSvrStatus","已处理");
        request.setAttribute("pageSvrDealId",5);  //不存session里面，每次请求不同。
        return "listDoReturn";
    }

    //反馈服务Jsp
    @RequestMapping("/toReturnSerJsp")
    public String toReturnSerJsp(CstService service,Model model){
        //1.服务的查单个
        CstService s = this.cstServiceBiz.load(service.getSvrId());
        model.addAttribute("s",s);

        //2.客户满意度
        SysDict sd1=new SysDict();
        sd1.setDictName("满意度");
        List<SysDict>  satisfyList  = this.sysDictBiz.list(sd1);
        model.addAttribute("satisfyList",satisfyList);
        return "doReturnService";//反馈服务的jsp页面，不是方法！！！！，怕你搞错。
    }

    //反馈服务(svr_result、svr_satisfy、主键)
    @RequestMapping("/doReturnService")
    public String doReturnService(CstService service){
        //1.反馈服务
        this.cstServiceBiz.doReturnService(service);

        //2.满意度 >=3--->svr_status修改为='已归档'
        //3.满意度 <3--->svr_status修改为='新创建',同时‘指派给人ID’字段，包括此字段一下的字段都得 set xxx=null;
       //通过参数值param-->satisfyValue(满意值)
        Integer satisfyValue=service.getSatisfyValue();
        if(satisfyValue!=null){
            if(satisfyValue>=3){
                 //其实还可以在jsp页面判断
                 if(satisfyValue==3){
                    service.setSvrSatisfy("满意");
                 }
                 if (satisfyValue==4){
                    service.setSvrSatisfy("非常满意");
                }
                this.cstServiceBiz.edit_serviceCome(service);
            }else{
                //svr_status修改为='新创建',同时‘指派给人ID’字段，包括此字段一下的字段都得 set xxx=null;（当满意度 <3）
                this.cstServiceBiz.edit_serviceNewCre(service);
            }
        }
        return "redirect:doReturnList";
    }

    /**
     * 所有服务归档[ 查的是'已归档'， (满意度 >=3)]
     */
    @RequestMapping("/doComeServieList")
    public String doComeServieList(CstService service,Model model,HttpServletRequest request){
        service.setSvrStatus("已归档");
        List<CstService> serviceList = this.cstServiceBiz.list(service,HandlePageBean.initPageBean(request, model));
        model.addAttribute("serviceList",serviceList);

        //3.分页需要跳转的地方
        request.getSession().setAttribute("forward","listComeServie");
        //4.是对‘服务分配List页面’分页
        request.getSession().setAttribute("pageSvrStatus","已归档");
        return "listComeServie";
    }

}
