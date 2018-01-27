package com.lmgd.customer.mapper;

import com.lmgd.customer.model.CstActivity;
import org.springframework.stereotype.Repository;

@Repository
public interface CstActivityMapper {
    int deleteByPrimaryKey(Long atvId);

    int insert(CstActivity record);

    int insertSelective(CstActivity record);

    CstActivity selectByPrimaryKey(Long atvId);

    int updateByPrimaryKeySelective(CstActivity record);

    int updateByPrimaryKey(CstActivity record);
}