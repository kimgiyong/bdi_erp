<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<%
List<Map<String,String>> userList = (List<Map<String,String>>)request.getAttribute("userlist");
%>
<body>
<div class="container">
<div style="margin:10px">
	<form action="<%=rPath%>/user/list">
		번호 : <input type="text" name="uiNum">
		이름 : <input type="text" name="uiName">
		아이디 : <input type="text" name="uiId">
		이메일 : <input type="text" name="uiEmail">
		<button>검색</button>
	</form>
</div>
	<table class="table table-bordered table-hover">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
		</tr>
<%
for(Map<String,String> user:userList){
%>
	<tr>
		<td><%=user.get("uiNum") %></td>
		<td><%=user.get("uiName") %></td>
		<td><%=user.get("uiId") %></td>
		<td><%=user.get("uiEmail") %></td>
	</tr>
<%
}
%>
	</table>
</div>
</body>
</html>