package com.lmgd.customer.mapper;

import com.lmgd.customer.model.SysTreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 树形菜单
 */
@Repository
public interface SysTreeNodeMapper {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(SysTreeNode record);

    int insertSelective(SysTreeNode record);

    SysTreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(SysTreeNode record);

    int updateByPrimaryKey(SysTreeNode record);

    //树形菜单
    List<SysTreeNode> list(SysTreeNode sysTreeNode);
}