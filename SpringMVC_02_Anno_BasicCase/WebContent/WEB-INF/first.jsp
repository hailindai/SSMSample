<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	这是什么，配置的视图 1
	<hr />
	${attr1 }
	<hr />
	<hr />
	applicationScope${applicationScope.attr1 }
	<hr />
	<hr />
	sessionScope${sessionScope.attr1 }
	<hr />
	<hr />
	requestScope${requestScope.attr1 }
	<hr />
	<hr />
	pageScope${pageScope.attr1 }
	<hr />
</body>
</html>