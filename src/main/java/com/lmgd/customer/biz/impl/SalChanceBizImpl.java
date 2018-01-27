package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ISalChanceBiz;
import com.lmgd.customer.mapper.SalChanceMapper;
import com.lmgd.customer.model.SalChance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalChanceBizImpl implements ISalChanceBiz {
    @Autowired
    private SalChanceMapper salChanceMapper;

    @Override
    public void del(Long chcId) {
         this.salChanceMapper.deleteByPrimaryKey(chcId);
    }

    @Override
    public void insert(SalChance record) {
         this.salChanceMapper.insert(record);
    }

    @Override
    public SalChance load(Long chcId) {
        return this.salChanceMapper.selectByPrimaryKey(chcId);
    }

    @Override
    public List<SalChance> list(SalChance salChance) {
        return this.salChanceMapper.list(salChance);
    }

    @Override
    public SalChance loadStatusIsNo1(Long chcId) {
        return this.salChanceMapper.loadStatusIsNo1(chcId);
    }

    @Override
    public void edit(SalChance record) {
        this.salChanceMapper.updateByPrimaryKey(record);
    }

    @Override
    public void editStatus(SalChance salChance) {
        this.salChanceMapper.editStatus(salChance);
    }

    @Override
    public List<SalChance> listIsNo1(SalChance salChance) {
        return this.salChanceMapper.listIsNo1(salChance);
    }

    @Override
    public void doPoint(SalChance salChance) {
        this.salChanceMapper.doPoint(salChance);
    }
}
