package com.lmgd.customer.biz.impl;

import com.lmgd.customer.biz.ISysTreeNodeBiz;
import com.lmgd.customer.mapper.SysTreeNodeMapper;
import com.lmgd.customer.model.SysTreeNode;
import com.lmgd.customer.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysTreeNodeBizImpl implements ISysTreeNodeBiz {
    @Autowired
    private SysTreeNodeMapper sysTreeNodeMapper;

    @Override
    public List<SysTreeNode> list(SysTreeNode sysTreeNode,PageBean pageBean) {
        return this.sysTreeNodeMapper.list(sysTreeNode);
    }
}
