package com.lmgd.customer.biz;

import com.lmgd.customer.model.SysUser;

public interface ISysUserBiz {

    //1.根据 指派给-某人ID---》指派给-某人名字
    String loadChcDueTo(Long chcDueId);

    //登录(通过用户名)
    SysUser load(String usrName);

}
