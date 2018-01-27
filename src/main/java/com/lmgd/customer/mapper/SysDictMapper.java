package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SysDict;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysDictMapper {
    int deleteByPrimaryKey(Long dictId);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long dictId);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    //根据dict_name 模糊查询
    List<SysDict> list(SysDict sysDict);
}