package com.lmgd.customer.controller.util;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 不用做任何初始化操作时候，给来处理公共的跳转.（注：好像只适合转发的跳转)
 */
@Controller
@RequestMapping("/comm")
public class CommForwardController {

    @RequestMapping("/{page}")
    public String doForward(@PathVariable String page,Model model){
        return page;//要跳转的页面 拼接前缀+.jsp
    }
}
