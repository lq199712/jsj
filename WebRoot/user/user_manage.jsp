<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

	</head>

	<body>
		<!--  内容列表   -->
		<form name="form2" action="user/list.do" method="post">

			<table width="60%" border="0" cellpadding="2" cellspacing="1"
				bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" align="center">
						&nbsp;
						<b>首页类别管理</b>&nbsp;
					</td>
				</tr>
				<tr bgcolor="#E7E7E7">
					<td height="33" colspan="6" bgcolor="#FFFFE5">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td width="15%" align="right" style="padding-right: 50px;">
								</td>
								<td width="25%">
								</td>
								<td width="5%">
									<input type="submit" class="coolbg np" onClick="" value='查 询' />

								</td>
								<td width="5%">
									<input type="reset" class="coolbg np" onClick="" value='重 置' />
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%" align="center">
						序号
					</td>
					<td width="35%" align="center">
						用户名
					</td>
					<td width="35%" align="center">
						密码
					</td>
					<td width="5%" align="center">
						修改
					</td>
					<td width="5%" align="center">
						删除
					</td>
				</tr>
				
				<c:forEach items="${users}" var="user">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td>
						${user.id}
					</td>
					<td>
						${user.username}
					</td>
					<td>
						${user.password}
					</td>
					<td>
						<a href="user/load/${user.id}.do">修改</a>
					</td>
					<td>
						<a href="user/delete/${user.id}.do">删除</a>
					</td>
				</tr>
				</c:forEach>

				<tr align="right" bgcolor="#EEF4EA">

					<td height="34" colspan="6" align="center">
						记录数： &nbsp;&nbsp;&nbsp;
						<a href="javascript:jumpPublicPage('bigtypeAction!list',1,,,,);"
							target="main">首页</a>&nbsp;&nbsp;
						<a href="javascript:jumpPublicPage('bigtypeAction!list',,,'',,);"
							target="main">上一页</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:jumpPublicPage('bigtypeAction!list',,,,,);"
							target="main">下一页</a>&nbsp;&nbsp;&nbsp;
						<a href="javascript:jumpPublicPage('bigtypeAction!list',,,,,);"
							target="main">尾页</a>&nbsp;&nbsp;&nbsp;
						<input type='button' class="coolbg np"
							onClick="javascript:jumpPublicPage('bigtypeAction!list',document.getElementById('page').value);"
							value='转到' />
						&nbsp; 当前页：
						<input onpaste="return false" onKeyPress="checkPage();" id="page"
							type="text" name="page" value="" size="2"
							style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
						/共 页
					</td>

				</tr>
			</table>

		</form>


	</body>
</html>
