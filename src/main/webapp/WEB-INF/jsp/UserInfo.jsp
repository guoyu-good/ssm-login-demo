<%@page pageEncoding="utf-8" %>

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
    <h2>有效登录用户信息显示如下：</h2>
    ${sessionScope.validUser.id}&nbsp;&nbsp;
    ${sessionScope.validUser.email}&nbsp;&nbsp;
    ${sessionScope.validUser.nickname}&nbsp;&nbsp;
    ${sessionScope.validUser.password}&nbsp;&nbsp;
    ${sessionScope.validUser.userIntegeral}&nbsp;&nbsp;
    ${sessionScope.validUser.isEmailVerify}&nbsp;&nbsp;
    ${sessionScope.validUser.emailVerifyCode}&nbsp;&nbsp;
    ${sessionScope.validUser.lastLoginTime}&nbsp;&nbsp;
    ${sessionScope.validUser.lastLoginIp}&nbsp;&nbsp;
</body>
</html>