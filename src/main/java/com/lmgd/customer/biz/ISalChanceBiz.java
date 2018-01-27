package com.lmgd.customer.biz;

import com.lmgd.customer.model.SalChance;

import java.util.List;

public interface ISalChanceBiz {
    //删(注意：先删 营销计划表，再删 营销机会表)
    void del(Long chcId);
    //增
    void insert(SalChance record);

    //查单个
    SalChance load(Long chcId);

    //查单个("除了未指派状态的")
    SalChance loadStatusIsNo1(Long chcId);

    //修改
    void edit(SalChance record);

    //修改客户开发状态
    void editStatus(SalChance salChance);

    //查全部
    List<SalChance> list(SalChance salChance);

    //查全部（模糊查询、(客户开发计划)--->不不不查‘1 未指派’的）
    List<SalChance> listIsNo1(SalChance salChance);

    //指派(chc_id、chc_due_id、chc_due_to、chc_due_date、chc_status='已指派'
    void doPoint(SalChance salChance);
}
