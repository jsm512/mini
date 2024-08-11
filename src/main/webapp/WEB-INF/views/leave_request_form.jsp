<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>휴가 신청서</title>
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
        .form-group input, .form-group select {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
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
    <h1>휴가 신청서 작성</h1>

    <form action="${pageContext.request.contextPath}/leave_requests/form" method="post">
        <div class="form-group">
            <label for="empId">사원 번호:</label>
            <input type="text" id="empId" name="empId" required />
        </div>
        <div class="form-group">
            <label for="startDate">시작일:</label>
            <input type="datetime-local" id="startDate" name="startDate" required />
        </div>
        <div class="form-group">
            <label for="endDate">종료일:</label>
            <input type="datetime-local" id="endDate" name="endDate" required />
        </div>
        <div class="form-group">
            <label for="requestDate">신청일:</label>
            <input type="datetime-local" id="requestDate" name="requestDate" required />
        </div>
        <div class="form-group">
            <label for="vacationType">종류:</label>
            <select id="vacationType" name="vacationType" required>
                <option value="병가">병가</option>
                <option value="여행">여행</option>
                <option value="개인">개인</option>
                <option value="기타">기타</option>
            </select>
        </div>
        <div class="form-group">
            <label for="content">사유:</label>
            <input type="text" id="content" name="content" required />
        </div>

        <button type="submit" class="btn">제출</button>
    </form>

    <a href="${pageContext.request.contextPath}/leave_requests" class="btn">휴가 신청 내역 보기</a>
</div>
</body>
</html>
