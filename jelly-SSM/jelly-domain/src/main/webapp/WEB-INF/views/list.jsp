<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 18-11-2
  Time: 下午3:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<c:forEach var="item" items="${users}">
   用户名:${item.userName}
   电 话：${item.userPhone}
</c:forEach>
</body>
</html>
