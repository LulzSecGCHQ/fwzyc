<%--
  Created by IntelliJ IDEA.
  User: user_yu
  Date: 2019/9/11
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登录京津冀非物质文化遗址管理系统</title>
</head>
<body>
<h2 align="center">欢迎登录京津冀非物质文化遗址管理系统</h2>
    <form action="/fwzyc_war_exploded/LoginServlet" method="post">
        <table align="center" border="1">
            <tr>
                <td>用户名</td>
                <td>
                    <input type="text" id="username" name="username">
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input type="text" id="password" name="password">
                </td>
            </tr>
            <tr>
                <td align="center" colspan="2">
                    <input type="submit" value="登录">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
