package com.lmgd.customer.biz;

import com.lmgd.customer.model.CstService;
import com.lmgd.customer.util.PageBean;

import java.util.List;

public interface ICstServiceBiz {

    //add
    void add(CstService service);

    //list(先不做模糊查询)
    List<CstService> list(CstService service, PageBean pageBean);

    //分配：把 svr_deal_id、svr_deal_by、svr_id
    //需要传的字段： svr_due_id、svr_due_to、svr_due_date、svr_deal_id、svr_deal_by  where svr_id
    void edit_doShare(CstService service);

    //查load
    CstService load(Long svrId);

    //服务处理(svr_deal_date、svr_result、svr_satisfy、主键)
    void doDealService(CstService service);

    //通过id--->修改服务为‘已处理’--》‘已处理’
    void editService_isDeal(CstService service);

    //2.svr_status修改为='已归档'（当满意度 >=3）
    void  edit_serviceCome(CstService service);

    //3.svr_status修改为='新创建',同时‘指派给人ID’字段，包括此字段一下的字段都得 set xxx=null;（当满意度 <3）
    void  edit_serviceNewCre(CstService service);

    //服务反馈
    void doReturnService(CstService service);
}
