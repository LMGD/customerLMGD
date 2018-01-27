package com.lmgd.customer.tag.ui;


import com.lmgd.customer.util.PageBean;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;


/**
 * 分页标签
 * 
 * @author Administrator
 * 
 */
public class PageTag extends BodyTagSupport {
	private PageBean pageBean;

	public PageTag() {
		super();
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			if (null != pageBean) {
				System.out.println("分页呀。。。。");
				out.write(this.getHTML());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return SKIP_BODY;
	}

	/**
	 * 用于分页的HTML
	 */
	/**
	 * @param :拼一个能改变页码，可以实现模糊查询的<form>
	 * @param :拼按钮
	 * @param :拼接js
	 * @return
	 */

	//因为直接index.jsp是跳不过去的，so 1:拼一个能改变页码的<form> 的代码已经没有用啦！!!!！
	public String getHTML() {
		StringBuffer sb = new StringBuffer();
		/**
		 * 1:拼一个能跳页码的,拼接到这里没用，分页标签没放到<script></script>里面，对吧，so 把代码弄到<script></>里面
		 */
//		sb.append("<script> ");
//		sb.append(" function skipPage(){ ");
//		sb.append(" var curPage= document.getElementById('skipPage').value; ");
//		sb.append(" alert('sbsbsbscurPage:'+curPage);  location.href='doPage?curPage='+curPage ");
//		sb.append(" }");
//		sb.append("</script> ");

		/**
		 * 2:拼按钮
		 */
		sb.append("共" + pageBean.getTotalRecord() + "条记录,页大小"
				+ pageBean.getPageRecord() + ",当前" + pageBean.getCurPage()
				+ "页");
		sb.append("&nbsp;&nbsp;" + pageBean.getCurPage() + "/"
				+ pageBean.getMaxPageNumber() + "&nbsp;");
		sb.append("<a href='doPage?curPage=1'>首页</a>&nbsp;");
		sb.append("<a href='doPage?curPage=" + pageBean.getPreviousPageNumber()
				+ "'>上一页</a>&nbsp;");
		sb.append("<a href='doPage?curPage=" + pageBean.getNextPageNumber()
				+ "'>下一页</a>&nbsp;");
		sb.append("<a href='doPage?curPage=" + pageBean.getMaxPageNumber()
				+ "'>尾页</a>");

		// 生成跳页功能
		sb.append("<input type='text' id='skipPage' style='width:30px;' name='skipPage' value=''><a onclick='skipPage()'>GO</a>");
		return sb.toString();
	}

}
