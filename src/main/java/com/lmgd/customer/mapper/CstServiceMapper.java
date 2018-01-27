package com.lmgd.customer.mapper;

import com.lmgd.customer.model.CstService;
import com.lmgd.customer.util.PageBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CstServiceMapper {
    int deleteByPrimaryKey(Long svrId);

    //add
    int insert(CstService record);

    int insertSelective(CstService record);

    //查load
    CstService selectByPrimaryKey(Long svrId);

    int updateByPrimaryKeySelective(CstService record);

    int updateByPrimaryKey(CstService record);

    //list
    List<CstService> list(CstService service);

    //分配：把 svr_deal_id、svr_deal_by、svr_id
    //需要传的字段： svr_due_id、svr_due_to、svr_due_date、svr_deal_id、svr_deal_by  where svr_id
    void edit_doShare(CstService service);

    //服务处理(svr_deal_date、svr_result、svr_satisfy、主键)
    void doDealService(CstService service);

    //通过id--->修改服务为‘已处理’--》‘已处理’
    void editService_isDeal(CstService service);

    /**
     * 服务反馈
     */

    //服务反馈功能
    void doReturnService(CstService service);

    //2.svr_status修改为='已归档'（当满意度 >=3）
    void  edit_serviceCome(CstService service);

    //3.svr_status修改为='新创建',同时‘指派给人ID’字段，包括此字段一下的字段都得 set xxx=null;（当满意度 <3）
    void  edit_serviceNewCre(CstService service);
}