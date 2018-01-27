package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ISysDictBiz;
import com.lmgd.customer.mapper.SysDictMapper;
import com.lmgd.customer.model.SysDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictBizImpl implements ISysDictBiz {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> list(SysDict sysDict) {
        return this.sysDictMapper.list(sysDict);
    }
}
