package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ICstServiceBiz;
import com.lmgd.customer.mapper.CstServiceMapper;
import com.lmgd.customer.model.CstService;
import com.lmgd.customer.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CstServiceBizImpl implements ICstServiceBiz {

    @Autowired
    private CstServiceMapper cstServiceMapper;

    @Override
    public void add(CstService service) {
       this.cstServiceMapper.insert(service);
    }

    @Override
    public List<CstService> list(CstService service, PageBean pageBean) {
        return this.cstServiceMapper.list(service);
    }

    @Override
    public void edit_doShare(CstService service) {
         this.cstServiceMapper.edit_doShare(service);
    }

    @Override
    public CstService load(Long svrId) {
        return this.cstServiceMapper.selectByPrimaryKey(svrId);
    }

    @Override
    public void doDealService(CstService service) {
        this.cstServiceMapper.doDealService(service);
    }

    @Override
    public void doReturnService(CstService service) {
        this.cstServiceMapper.doReturnService(service);
    }

    @Override
    public void editService_isDeal(CstService service) {
        this.cstServiceMapper.editService_isDeal(service);
    }

    @Override
    public void edit_serviceCome(CstService service) {
        this.cstServiceMapper.edit_serviceCome(service);
    }

    @Override
    public void edit_serviceNewCre(CstService service) {
       this.cstServiceMapper.edit_serviceNewCre(service);
    }


}
