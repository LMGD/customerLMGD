package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ICstCustomerBiz;
import com.lmgd.customer.mapper.CstCustomerMapper;
import com.lmgd.customer.model.CstCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CstCustomerBizImpl implements ICstCustomerBiz {
    @Autowired
    private CstCustomerMapper cstCustomerMapper;

    @Override
    public void add(CstCustomer record) {
       this.cstCustomerMapper.insert(record);
    }

    @Override
    public List<CstCustomer> list(CstCustomer customer) {
        return this.cstCustomerMapper.list(customer);
    }
}
