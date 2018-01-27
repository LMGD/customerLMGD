package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SalChance;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalChanceMapper {
    //删(注意：先删 营销计划表，再删 营销机会表)
    int deleteByPrimaryKey(Long chcId);

    //增
    int insert(SalChance record);

    int insertSelective(SalChance record);

    //查单个("未指派状态的")
    SalChance selectByPrimaryKey(Long chcId);

    //查单个("除了未指派状态的")
    SalChance loadStatusIsNo1(Long chcId);

    int updateByPrimaryKeySelective(SalChance record);

    //修改
    int updateByPrimaryKey(SalChance record);

    //修改 通过营销机会id,修改开发状态。
    void editStatus(SalChance salChance);

    //查全部（模糊查询、营销机会管理->查‘ 1 未指派’）
    List<SalChance> list(SalChance salChance);

    //查全部（模糊查询、(客户开发计划)--->不不不查‘1 未指派’的）
    List<SalChance> listIsNo1(SalChance salChance);

    //指派(chc_id、chc_due_id、chc_due_to、chc_due_date、chc_status='已指派'
    void doPoint(SalChance salChance);
}