package com.lmgd.customer.biz;

import com.lmgd.customer.model.SysDict;

import java.util.List;

public interface ISysDictBiz {

    //根据dict_name 模糊查询
    List<SysDict> list(SysDict sysDict);
}
