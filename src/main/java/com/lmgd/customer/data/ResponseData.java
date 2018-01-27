package com.lmgd.customer.data;

import java.io.Serializable;

/**
 * 生成easyui控件DataGrid所需要的格式
 * 
 * @author Administrator
 * 
 */
public class ResponseData implements Serializable {
	/**
	 * 要的格式： {total:10,rows:[{},{},{}]}
	 */
	private Integer total;
	private Object rows;// [{},{},{}]列表模式 or 混合模式：数据、List、set

	public ResponseData() {
		super();
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

}
