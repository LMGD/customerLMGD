package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ISalPlanBiz;
import com.lmgd.customer.mapper.SalPlanMapper;
import com.lmgd.customer.model.SalPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalPlanBizImpl implements ISalPlanBiz {
    @Autowired
    private SalPlanMapper salPlanMapper;

    @Override
    public void del(Long plaId) {
        this.salPlanMapper.deleteByPrimaryKey(plaId);
    }

    @Override
    public void add(SalPlan salPlan) {
        this.salPlanMapper.insert(salPlan);
    }

    @Override
    public void edit(SalPlan salPlan) {
        this.salPlanMapper.updateByPrimaryKey(salPlan);
    }

    @Override
    public List<SalPlan> list(Long plaChcId) {
        return this.salPlanMapper.list(plaChcId);
    }
}
