<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>
    <form:form modelAttribute="user" action="" method="post">
        <div style="color:red;font-size:30px">
            用户名或密码填写错误！
        </div>
        <p>
            <div><form:errors path="email" cssClass="redColor"/> </div>
            用户邮箱：<form:input path="email"/>
        </p>

        <p>
        <div><form:errors path="password" cssClass="redColor"/> </div>
            用户密码：<form:password path="password"/>
        </p>

        <p>
            <input type="reset" value="重置"/>
            <input type="submit" value="登录"/>
        </p>
    </form:form>

</body>
</html>