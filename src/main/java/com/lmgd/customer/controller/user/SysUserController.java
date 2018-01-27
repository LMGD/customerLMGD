package com.lmgd.customer.controller.user;

import com.lmgd.customer.mapper.SysUserMapper;
import com.lmgd.customer.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SysUserController {

    @Autowired
    private SysUserMapper sysUserMapper;

    //登录JSP
    @RequestMapping("/toLoadJsp")
    public String toLoadJsp(){
        return "load";
    }

    //登录(通过用户名)
    @RequestMapping("/load")
    public String load(SysUser user, HttpSession session){
        String usrName=user.getUsrName();
        SysUser sysUser = this.sysUserMapper.selectByPrimaryKey(usrName);
        System.out.println("jsp-user-sbsbs:"+sysUser);

        //usr_id、usr_name、
        if(null!=sysUser&&sysUser.getUsrPassword().trim().equals(user.getUsrPassword())){//登录成功
             Long usrId=sysUser.getUsrId();
             Long roleId=sysUser.getUsrRoleId();
            session.setAttribute("usrId",sysUser.getUsrId());
            session.setAttribute("usrName",usrName);
            session.setAttribute("roleId",roleId);
            System.out.println("forward-user-sbsbs:"+sysUser);
            return "redirect:toMain";//登录成功--》跳到主页面
           // return "redirect:listChance?roleId="+roleId+"&usrId="+usrId+"&usrName="+usrName;
        }
        return "redirect:toLoadJsp";//登录失败---》继续登录
    };


}
