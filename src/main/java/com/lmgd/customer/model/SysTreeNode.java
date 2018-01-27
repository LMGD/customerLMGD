package com.lmgd.customer.model;

import java.io.Serializable;

public class SysTreeNode implements Serializable {
    private Integer treeNodeId;

    private String treeNodeName;

    private Integer treeNodeType;

    private Long position;

    private Integer parentNodeId;

    private String url;

    private static final Integer LEAF_NODE = new Integer(2);// 叶节点是2（不可以像文件夹一样打开的叫叶节点）

    public SysTreeNode(Integer treeNodeId, String treeNodeName, Integer treeNodeType, Long position, Integer parentNodeId, String url) {
        this.treeNodeId = treeNodeId;
        this.treeNodeName = treeNodeName;
        this.treeNodeType = treeNodeType;
        this.position = position;
        this.parentNodeId = parentNodeId;
        this.url = url;
    }

    public SysTreeNode() {
        super();
    }

    public Integer getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Integer treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public String getTreeNodeName() {
        return treeNodeName;
    }

    public void setTreeNodeName(String treeNodeName) {
        this.treeNodeName = treeNodeName;
    }

    public Integer getTreeNodeType() {
        return treeNodeType;
    }

    public void setTreeNodeType(Integer treeNodeType) {
        this.treeNodeType = treeNodeType;
    }

    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }

    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        if (null != parentNodeId && !parentNodeId.trim().equals("")) {
            this.parentNodeId = Integer.parseInt(parentNodeId);
        }
    }
    /**
     * 判断是树节点、还是叶节点（不可以像文件夹一样打开的叫叶节点）,Leaf:叶子
     */
    public boolean isLeaf() {
        return LEAF_NODE.equals(treeNodeType);
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "SysTreeNode{" +
                "treeNodeId=" + treeNodeId +
                ", treeNodeName='" + treeNodeName + '\'' +
                ", treeNodeType=" + treeNodeType +
                ", position=" + position +
                ", parentNodeId=" + parentNodeId +
                ", url='" + url + '\'' +
                '}';
    }
}