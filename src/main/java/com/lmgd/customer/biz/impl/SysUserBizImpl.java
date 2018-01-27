package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ISysUserBiz;
import com.lmgd.customer.mapper.SysUserMapper;
import com.lmgd.customer.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserBizImpl implements ISysUserBiz {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String loadChcDueTo(Long chcDueId) {
        return this.sysUserMapper.loadChcDueTo(chcDueId);
    }

    @Override
    public SysUser load(String usrName) {
        return this.sysUserMapper.selectByPrimaryKey(usrName);
    }
}
