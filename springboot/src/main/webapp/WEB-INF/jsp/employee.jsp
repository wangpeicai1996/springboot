<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--引入标签库-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>empno</th>
        <th>ename</th>
        <th>sal</th>
        <th>hiredate</th>
    </tr>
    <c:forEach items="${emps }" var="emp">
        <tr>
            <td>${emp.empno }</td>
            <td>${emp.ename }</td>
            <td>${emp.sal }</td>
            <td>${emp.hiredate }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>