<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/4/2025
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
<form:form modelAttribute="studentDTO" action="/studentController/create" method="post">
    <lable>Name</lable>
    <form:input path="studentName"/>
    <br>
    <form:errors path="studentName" cssStyle="color: red;"/>
    <br>
    <lable>Email</lable>
    <form:input path="email"/>
    <br>
    <form:errors path="email" cssStyle="color: red;"/>
    <br>
    <lable>ageMark</lable>
    <form:input path="ageMark"/>
    <br>
    <form:errors path="ageMark" cssStyle="color: red;"/>
    <br>

    <input type="hidden" name="isStudying" value="true"/>

    <button type="submit">Create</button>
</form:form>
</body>
</html>
