<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/4/2025
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="studentDTO" action="/studentController/update" method="post">
    <form:hidden path="id"/>

    <lable>Name</lable>
    <form:input path="studentName" value="${studentDTO.studentName}"/>
    <br>
    <form:errors path="studentName" cssStyle="color: red;"/>
    <br>

    <lable>Email</lable>
    <form:input path="email" value="${studentDTO.email}"/>
    <br>
    <form:errors path="email" cssStyle="color: red;"/>
    <br>

    <lable>ageMark</lable>
    <form:input path="ageMark" value="${studentDTO.ageMark}"/>
    <br>
    <form:errors path="ageMark" cssStyle="color: red;"/>
    <br>

    <form:radiobutton path="isStudying" value="true"/> Đang học
    <form:radiobutton path="isStudying" value="false"/> Đã nghi
    <button type="submit">Update</button>
</form:form>
</body>
</html>
