package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SysRole;
import org.springframework.stereotype.Repository;

@Repository
public interface SysRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}