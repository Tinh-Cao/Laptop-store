<%-- 
    Document   : top1
    Created on : Jul 17, 2023, 10:32:08 AM
    Author     : TInh
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
<c:if test="${requestScope.listAccount != null}">
            UserID: ${requestScope.listAccount.getUsername()}<br>
            FullName: ${requestScope.listAccount.getFullname()}
        </c:if>
        </div>
    </body>
</html>
