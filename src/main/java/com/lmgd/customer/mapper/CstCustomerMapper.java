package com.lmgd.customer.mapper;

import com.lmgd.customer.model.CstCustomer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CstCustomerMapper {
    int deleteByPrimaryKey(String custNo);

    //add
    int insert(CstCustomer record);

    int insertSelective(CstCustomer record);

    CstCustomer selectByPrimaryKey(String custNo);

    int updateByPrimaryKeySelective(CstCustomer record);

    int updateByPrimaryKey(CstCustomer record);

    //list
    List<CstCustomer> list(CstCustomer customer);
}