package com.lmgd.customer.controller.chance;

import com.lmgd.customer.biz.ISalPlanBiz;
import com.lmgd.customer.mapper.SalPlanMapper;
import com.lmgd.customer.model.SalPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//营销计划表
@Controller
public class SalPlanController {

    @Autowired
    private ISalPlanBiz salPlanBiz;//营销计划表

    //删除
    @RequestMapping("/delPlan")
    public void delPlan(SalPlan salPlan){
      this.salPlanBiz.del(salPlan.getPlaId());
    }

    /**
     *add
     */
    @RequestMapping("/toAddPlanJsp")
    public String toAddPlanJsp(SalPlan salPlan, HttpSession session){
        session.setAttribute("plaChcId",salPlan.getPlaChcId());
        return "addPlan";
    }

    @RequestMapping("/doAddPlan")
    public String doAddPlan(long plaChcId,String[] plaTodos,String[] plaResults,HttpSession session){
        //plaTodos：计划内容、plaResults:计划执行结果
        List<SalPlan> planList=new ArrayList<SalPlan>();
        SalPlan salPlan=null;
        for(int i=0;i<plaTodos.length;i++){
            salPlan=new SalPlan();
            salPlan.setPlaChcId(plaChcId);
            salPlan.setPlaTodo(plaTodos[i]);
            if(plaResults.length!=0){
                salPlan.setPlaResult(plaResults[i]);
            }
            planList.add(salPlan);
        }
        for(int i=0;i<planList.size();i++){
            this.salPlanBiz.add(planList.get(i));
        }
        return "redirect:listPlan";
//        return "redirect:listPlan?chcStatus=2";//查出所有‘开发中’
    }

    //edit(只能修改结果)
    @RequestMapping("/doEditPlan")
    public String doEditPlan(SalPlan salPlan,Model model,Long chcId){
        this.salPlanBiz.edit(salPlan);
        return "redirect:load/detailChance?chcId="+chcId+"&chcStatus=2";//跳到销售机会的包含有详细页面、和计划的页面。
    }

}
