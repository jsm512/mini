<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>휴가 신청 내역</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 100%;
            max-width: 900px;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn {
            padding: 10px 15px;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>휴가 신청 내역</h1>

    <form action="${pageContext.request.contextPath}/leave_requests" method="get">
        <div class="form-group">
            <label for="empId">사원 번호:</label>
            <input type="text" id="empId" name="empId" required="true" />
        </div>
        <button type="submit" class="btn">조회</button>
    </form>

    <c:if test="${not empty leaveRequests}">
        <h2>사원 : ${empName}의 휴가 신청 내역</h2>
        <table>
            <thead>
            <tr>
                <th>신청 ID</th>
                <th>시작일</th>
                <th>종료일</th>
                <th>상태</th>
                <th>사유</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${leaveRequests}" var="request">
                <tr>
                    <td>${request.requestId}</td>
                    <td>${request.startDate}</td>
                    <td>${request.endDate}</td>
                    <td>${request.requestStatus}</td>
                    <td>${request.content}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <a href="${pageContext.request.contextPath}/leave_requests/form" class="btn">새로운 휴가 신청서 작성</a>
</div>
</body>
</html>