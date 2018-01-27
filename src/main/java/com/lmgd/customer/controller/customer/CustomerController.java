package com.lmgd.customer.controller.customer;

import com.lmgd.customer.biz.ICstCustomerBiz;
import com.lmgd.customer.model.CstCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICstCustomerBiz cstCustomerBiz;

    //list
    @RequestMapping("/doListCustomer")
    public String doListCustomer(CstCustomer customer, Model model){
        List<CstCustomer> customerList = this.cstCustomerBiz.list(customer);
        model.addAttribute("customerList",customerList);
        return "listCustomer";
    }
}
