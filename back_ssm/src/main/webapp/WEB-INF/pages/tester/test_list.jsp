<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>出版社信息</title>
</head>
<body>
    <table width="400" border="1" cellspacing="0" cellpadding="0" style="border-collapse:collapse">
        <tbody>
            <tr>
                <td>编号</td>
            </tr>
            <c:forEach var="tester" items="${testers}">
                <tr>
                    <td>12</td>
                    <td>${tester.testId}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>