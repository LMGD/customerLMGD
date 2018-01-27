package com.lmgd.customer.controller.chance;

import com.lmgd.customer.biz.ICstCustomerBiz;
import com.lmgd.customer.biz.ISalChanceBiz;
import com.lmgd.customer.biz.ISalPlanBiz;
import com.lmgd.customer.biz.ISysUserBiz;
import com.lmgd.customer.model.CstCustomer;
import com.lmgd.customer.model.SalChance;
import com.lmgd.customer.model.SalPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ChanceController {

    @Autowired
    private ISalChanceBiz salChanceBiz;

    //系统用户表( 根据 指派给-某人ID---》指派给-某人名字)
    @Autowired
    private ISysUserBiz sysUserBiz;

    @Autowired
    private ISalPlanBiz salPlanBiz;//营销计划表

    @Autowired
    private ICstCustomerBiz cstCustomerBiz;


    //查全部（模糊查询、营销机会管理->查‘ 1 未指派’）
    @RequestMapping("/listChance")
    public String listChance(SalChance salChance, Model model){
        salChance.setChcStatus(1);
        List<SalChance> chanceList = this.salChanceBiz.list(salChance);
        model.addAttribute("chanceList",chanceList);
        return "listChance";
    }

    //'指派功能'(chc_id、chc_due_id、chc_due_to、chc_due_date
    @RequestMapping("/doPoint")
    public String doPoint(SalChance salChance, HttpServletRequest request){
        //销售主管(roleId=2),才有指派功能。
        long roleId=(Long) request.getSession().getAttribute("roleId");
        if(roleId==3||roleId==4){//roleId>2的为‘客户经理 ’‘高管’
            request.getSession().setAttribute("message","你没有此权限！！");
            return "redirect:listChance";//跳到'营销机会管理List'
        }
        salChance.setChcDueDate(new Timestamp(System.currentTimeMillis()));
        this.salChanceBiz.doPoint(salChance);
        return "redirect:listChance";//跳到'营销机会管理List'
    }



    //listPlan--->营销计划表(客户开发计划)--->不不不查‘1 未指派’的
    @RequestMapping("/listPlan")
    public String listPlan(SalChance salChance, Model model){
        List<SalChance> chanceList = this.salChanceBiz.listIsNo1(salChance);
        model.addAttribute("chanceList",chanceList);
        return "listPlan";
    }


    //add
    //chcSource、chcCustName、chcRate、chcTitle、chcLinkman、chcTel、chcDesc、chcCreateId、chcCreateBy
    @RequestMapping("/doAddChance")
    public String doAddChance(SalChance salChance,HttpServletRequest request){
        //chc_create_id创建人ID、chc_create_by创建人名字,系统用户登入进来就取出来。
        Long  usrId=(Long) request.getSession().getAttribute("usrId");
        String  usrName=(String) request.getSession().getAttribute("usrName");
        salChance.setChcCreateId(usrId);
        salChance.setChcCreateBy(usrName);

        this.salChanceBiz.insert(salChance);
        return "redirect:toAddJsp";
    }

    //重定向的add页面
    @RequestMapping("/toAddJsp")
    public String toAddJsp(){
        return "addChance";
    }

    //load
    @RequestMapping("/load/{page}")
    public String loadChance(SalChance salChance,Model model,@PathVariable String page){
        Integer chcStatus = salChance.getChcStatus();
        SalChance chance =null;
        List<SalPlan> planList=new ArrayList<SalPlan>();
        if(chcStatus==1){//‘未指派’状态的查当个
            chance=this.salChanceBiz.load(salChance.getChcId());
        }else{//指派、开发成功 、开发失败
            chance=this.salChanceBiz.loadStatusIsNo1(salChance.getChcId());
            planList = salPlanBiz.list(salChance.getChcId());//营销计划表
        }
        model.addAttribute("ch",chance);
        model.addAttribute("planList",planList);
        return page;
    }

    //edit
    @RequestMapping("/editChance")
    public String editChance(SalChance salChance){
        this.salChanceBiz.edit(salChance);
      return "redirect:listChance";
    }

    /**
     *   //修改 通过营销机会id,修改开发状态。
     *  @“开发成功”:如果开发客户成功，系统自动创建新的客户记录。
     *  @需要的参数：chcdId、chcStatus+'客户名称'
     */
    @RequestMapping("/doEditStatus")
    public String doEditStatus(SalChance salChance){
        //1.修改(通过营销机会id,修改开发状态。)
        this.salChanceBiz.editStatus(salChance);//b.'开发失败'----》结束开发,修改开发状态为4

        //2.通过状态判断跳转的页面
        //a.'开发成功'-->调客户信息表加客户的add（就只加'客户名称' 即可）
        if(salChance.getChcStatus()==3){
             String custName=salChance.getChcCustName();//'客户名称'
             CstCustomer customer=new CstCustomer();
             customer.setCustName(custName);
             customer.setCustNo(new java.sql.Date(System.currentTimeMillis())+"_"+getFileId());//10+1+5
             this.cstCustomerBiz.add(customer);
        }
        return "redirect:listPlan";
//        return "redirect:listPlan?chcStatus=2";//跳到查出‘开发状态的’营销计划
    }


    //del
    @RequestMapping("/delChance")
    public  String delChance(SalChance salChance){
        //(营销计划表的pla_chc_id)
        this.salPlanBiz.del(salChance.getChcId());
        //再删 营销机会表
        this.salChanceBiz.del(salChance.getChcId());
        return "redirect:listChance";
    }

    //uuid
    private String getFileId() {
        // 1 UUID
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        // 2.时间戳
        // String s = System.currentTimeMillis()+"";
        //只要5个字付串
        s=s.substring(0,5);
        return s;
    }
}
