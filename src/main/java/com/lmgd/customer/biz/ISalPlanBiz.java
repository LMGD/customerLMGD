package com.lmgd.customer.biz;

import com.lmgd.customer.model.SalPlan;

import java.util.List;

//营销计划表
public interface ISalPlanBiz {
    //删除(营销计划表)
    void del(Long plaId);

    //add
    void add(SalPlan salPlan);

    //修改
    void edit(SalPlan salPlan);

    //根据pla_chc_id---》查全部
    List<SalPlan> list(Long plaChcId);
}
