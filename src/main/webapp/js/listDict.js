$(function() {
	$('#dg').datagrid({
		url : 'dictServlet.action',
		columns : [ [ {
			field : 'dictId',
			title : 'ID',
			width : '25%'
		}, {
			field : 'dictName',
			title : '字典名字',
			width : '25%'
		}, {
			field : 'text',
			title : '字典文本',
			width : '25%'
		}, {
			field : 'value',
			title : '字典值',
			width : '25%'
		}, {
			field : 'position',
			title : '下标',
			width : '25%'
		}, {
			field : 'remark',
			title : '备注',
			width : '25%'
		} ] ]
	});
});