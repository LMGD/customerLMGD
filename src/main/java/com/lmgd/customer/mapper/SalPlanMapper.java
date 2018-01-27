package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SalPlan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalPlanMapper {
    //删除(营销计划表)
    int deleteByPrimaryKey(Long plaId);

    //add
    int insert(SalPlan record);

    int insertSelective(SalPlan record);

    SalPlan selectByPrimaryKey(Long plaId);

    int updateByPrimaryKeySelective(SalPlan record);

    //修改(只能修改结果)
    int updateByPrimaryKey(SalPlan record);

    //根据pla_chc_id---》查全部
    List<SalPlan> list(Long plaChcId);
}