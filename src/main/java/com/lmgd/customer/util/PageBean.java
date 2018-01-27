package com.lmgd.customer.util;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Map;

public class PageBean implements Serializable {

	private static final long serialVersionUID = -7544706514503688395L;

	private int curPage = 1;// 当前页
	private int pageRecord =3;// 页大小
	private int totalRecord;// 总记录数

	private boolean paginate = true;/* 是否分页，默认分页 */

	private String url;
	private Map<String, String[]> parameterMap;

	public PageBean() {
		super();
	}

	/**
	 * 初始化分页数据
	 * 
	 * @param request
	 */
	public void setRequest(HttpServletRequest request) {
		this.setCurPage(request.getParameter("curPage"));
		this.setPageRecord(request.getParameter("pageRecord"));
		this.setPaginate(request.getParameter("paginate"));
		this.url = request.getContextPath() + request.getServletPath();
		this.parameterMap = request.getParameterMap();

		// 兼容easyui的页码page、页大小rows
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		if (null != rows && null != page) {
			this.setCurPage(request.getParameter("page"));
			this.setPageRecord(request.getParameter("rows"));
		}
	}

	public boolean isPaginate() {
		return paginate;
	}

	public void setPaginate(boolean paginate) {
		this.paginate = paginate;
	}

	public void setPaginate(String paginate) {
		paginate = null == paginate ? "" : paginate.trim();
		if ("false".equalsIgnoreCase(paginate)) {
			this.paginate = false;
		} else {
			this.paginate = true;
		}
	}

	private void setPageRecord(String pageRecord) {
		if (null != pageRecord && !"".equals(pageRecord.trim())) {
			this.pageRecord = Integer.parseInt(pageRecord);
		}
	}

	private void setCurPage(String curPage) {
		if (null != curPage && !"".equals(curPage.trim())) {
			this.curPage = Integer.parseInt(curPage);
		}
	}

	public String getUrl() {
		return url;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		this.totalRecord = Integer.valueOf(totalRecord);
	}

	public int getCurPage() {
		return curPage;
	}

	public int getPageRecord() {
		return pageRecord;
	}

	public int getMaxPageNumber() {
		int maxPageNumber = this.totalRecord / this.pageRecord;
		maxPageNumber = totalRecord % pageRecord == 0 ? maxPageNumber : maxPageNumber + 1;
		return maxPageNumber;
	}

	public int getNextPageNumber() {
		int nextPageNumber = this.curPage + 1;
		nextPageNumber = nextPageNumber > this.getMaxPageNumber() ? this.getMaxPageNumber() : nextPageNumber;
		return nextPageNumber;
	}

	public int getPreviousPageNumber() {
		int previousPageNumber = this.curPage - 1;
		previousPageNumber = previousPageNumber < 1 ? 1 : previousPageNumber;
		return previousPageNumber;
	}

	public int getStartIndex() {
		return (this.curPage - 1) * this.pageRecord;
	}

	public int getEndIndex() {
		return this.curPage * this.pageRecord - 1;
	}

	@Override
	public String toString() {
		return "PageBean [curPage=" + curPage + ", pageRecord=" + pageRecord + ", totalRecord=" + totalRecord + "]";
	}

}
