<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--利用meta标签，定时刷新页面，防止会话结束 -->
<%--<meta http-equiv="refresh" content="600"/>--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/comm/head.jsp"%>

<script>
      //获得项目名
       var contextPath="<%=request.getContextPath()%>";
       // alert("contextPath："+contextPath);
    
       //6. 通过一级节点id-->找到他下面的子节点，给空的树ul.easyui-tree一个url、还有tree支持的JSON格式就可以异步加载数据
       $(function(){
           $("ul.easyui-tree").each(function(){
             //7. 取出当前ul.easyui-tree的id
             var id=$(this).attr("id");
             var url="listTreeNode?id="+id; //url
             //8. 异步加载数据
	         $(this).tree({
				url : url,
				onLoadSuccess:function(){//在数据加载成功以后触发
				   //文档加载成功后，恢复原来的url
				   $(this).tree("options").url="listTreeNode";
				},
				//别用getSelected,不对,{}这里面是处理事件
				onSelect:function(node){//onSelect 参数：返回的node 在用户选择节点的时候触发。 
				     var text=node.text;
		             //alert("text:"+text);//eg:用户管理
		            //获得此节点的自定义url属性
		             var src=node.attributes.url;  /*attributes:绑定该节点的自定义属性,我不是在TreeNodeServlet哪里加了自己定义的属性吗。对 */
		             if(!src)return false; 
		             opentab(text, src);
				}
			});
		});
	});
	
	 function opentab(text,src){
     //要这样才可以跳过去，so要拼接项目名  http://localhost:8080/easyui_01/listDict.jsp
         // src=contextPath+"/WEB-INF"+src;
         //src：因为不能直接跳.jsp页面,so 写的是请求处理方法。
         //alert("scr:"+src);
	  if (!$('#Mytabs').tabs('exists', text)) {
	     //content的src会打开一个框架窗口、页面，就是listDict.jsp
          var content='<iframe src="'+src+'" frameBorder="0" border="0" scrolling="no" style="width: 100%; height: 100%;"/>'

              $('#Mytabs').tabs('add', {
				title : text, 
				selected : true,
				closable : true,
				content: content
			});
		 } else {
			$('#Mytabs').tabs('select', text);
		}
	}
</script>
</head>

<body>
  <!-- 1:布局 easyui-layout -->
  <div style="height:20px;padding-left: 800px; ">
        尊敬的：${usrName}用户你好！！
	    &nbsp;<a href="toLoadJsp">登录</a>
  </div>

  <div id="cc" class="easyui-layout" style="width:99%;height:90%;">
    <div data-options="region:'west',split:true,title:'导航菜单', fit:false" style="width:200px;">
        <!-- 2:左边的布局 嵌一个手风琴 easyui-accordion -->
			<div id="aa" class="easyui-accordion"
				style="width:300px;height:50%;">
				<c:forEach items="${nodes}" var="v">
					<!-- 4. 把一级节点的text作为  第一个手风琴的标题-->
					<div title="${v.text}"
						data-options="iconCls:'icon-save',selected:true"
						style="overflow:auto;padding:10px;">
						<!-- 3. 第一个手风琴里面嵌数tree -->
						<!-- 5. 查出一级节点的id -->
						<ul class="easyui-tree" id="${v.id}"></ul>
					</div>
				</c:forEach>
			</div>
	</div>
	<!--B: 中间的布局  里面放了一个easyui-tabs -->	
    <div data-options="region:'center',title:'center title'" style="padding:5px;">
        <div id="Mytabs" class="easyui-tabs" style="height:100%" >
			<div title="Tab1" style="padding:0px;display:none;">tab1</div>
		</div>
    </div>
  </div>

  <!-- 防止session会话过期:使用JavaScript Image对象来实现定时刷新 -->
  <div>
	  <img id="doFreshId" src="doFreshJsp" alt="">
  </div>

<script type="text/javascript">
	$(function(){
        setInterval(doFresh,1500000);//单位毫秒(25分钟就与服务器进行交互,session就不会过期。)
	})

	function doFresh(){
       var doFreshObj= document.getElementById("doFreshId");
        var src=doFreshObj.src;
        //alert("src:"+src);
       //alert("要对src赋值啦:"+src);
        doFreshObj.src="doFreshJsp";
	}
</script>
</body>
</html>
