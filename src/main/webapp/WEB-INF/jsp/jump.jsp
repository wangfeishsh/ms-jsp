<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>跳转中</title>
</head>
<body>
<div style="text-align:center">正在提交订单...</div>

<form name="form" method="post" action="${model.payUrl}">
    <c:forEach items="${model}" var="m">
        <input type="hidden" name="${m.key}" value="${m.value}"/>
    </c:forEach>
</form>
</body>
<script>
    document.form.submit();
</script>
</html>
