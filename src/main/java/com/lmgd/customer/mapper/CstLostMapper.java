package com.lmgd.customer.mapper;

import com.lmgd.customer.model.CstLost;
import org.springframework.stereotype.Repository;

@Repository
public interface CstLostMapper {
    int deleteByPrimaryKey(Long lstId);

    int insert(CstLost record);

    int insertSelective(CstLost record);

    CstLost selectByPrimaryKey(Long lstId);

    int updateByPrimaryKeySelective(CstLost record);

    int updateByPrimaryKey(CstLost record);
}