package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(Long usrId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    //登录(通过用户名)
    SysUser selectByPrimaryKey(String usrName);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    //1.根据 指派给-某人ID---》指派给-某人名字
    String loadChcDueTo(Long chcDueId);
}