<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Truong
  Date: 8/4/2025
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            font-family: Arial, sans-serif;
        }

        thead {
            background-color: #f2f2f2;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 12px 15px;
            text-align: center;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #e6f7ff;
        }

        th {
            color: #333;
            font-weight: bold;
        }
    </style>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>No.</th>
        <th>ID</th>
        <th>Tên sinh viên</th>
        <th>Email</th>
        <th>Điểm</th>
        <th>Tình trạng</th>
        <th>Hành Động</th>
    </tr>
    </thead>
    <tbody>
    <form action="<%=request.getContextPath()%>/studentController/search" method="get">
        <input type="search" name="keyword">
        <button type="submit">Search</button>
    </form>
    <c:forEach var="student" items="${studentList}" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.email}</td>
            <td>${student.ageMark}</td>
            <td>
                <c:choose>
                    <c:when test="${student.isStudying}">
                        Đang học
                    </c:when>
                    <c:otherwise>
                        Đã nghỉ
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="<%=request.getContextPath()%>/studentController/initUpdate?id=${student.id}" >Update</a>
                <a href="<%=request.getContextPath()%>/studentController/delete?id=${student.id}" >Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/studentController/initCreat">Create new Student</a>
</body>
</html>
