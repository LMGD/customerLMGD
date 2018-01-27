package com.lmgd.customer.biz;

import com.lmgd.customer.model.SysTreeNode;
import com.lmgd.customer.util.PageBean;

import java.util.List;

public interface ISysTreeNodeBiz {

    List<SysTreeNode> list(SysTreeNode sysTreeNode,PageBean pageBean);
}
