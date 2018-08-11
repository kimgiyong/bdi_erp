<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
<%
//request.setAttribute("name","김기용");
//Map<String,String> map = new HashMap<String,String>();
//map.put("id","test");
//map.put("age","123");
//response.sendRedirect("/test/move.jsp");

//request.setAttribute("map",map);
//RequestDispatcher rd = request.getRequestDispatcher("/test/move1.jsp");
//rd.forward(request,response);
%>
<button type="button" onclick="move('test1')">test1로이동</button>
<button type="button" onclick="move('test2')">test2로이동</button>
<button type="button" onclick="move('test3')">test3로이동</button>
<button type="button" onclick="move('test4')">test4로이동</button>
<script>
function move(p){
	location.href="/views/test/" + p + "?name=" + p;
}
</script>
</body>
</html>