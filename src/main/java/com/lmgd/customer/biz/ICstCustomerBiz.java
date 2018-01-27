package com.lmgd.customer.biz;

import com.lmgd.customer.model.CstCustomer;

import java.util.List;

public interface ICstCustomerBiz {

    //add
    void add(CstCustomer record);

    //list
    List<CstCustomer> list(CstCustomer customer);
}
