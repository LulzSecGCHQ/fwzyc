<%--
  Created by IntelliJ IDEA.
  User: user_yu
  Date: 2019/9/12
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ArrayList" %>
<%@ page
        import="com.fwzyc.VO.UserVo,com.fwzyc.DAO.UserDAO"%>
<html>
<head>
    <title>欢迎登录京津冀非物质文化遗址管理系统</title>
</head>
<body>
    <h2 align="center">用户管理首页/修改用户信息</h2>
    <form>
        <table border="1" align="center">
            <thead>
                <td>主键id</td>
                <td>用户名</td>
                <td>密码</td>
                <td>性别</td>
                <td>用户地址</td>
                <td>用户地址代码</td>
                <td>操作</td>
            </thead>
                <%
                ArrayList<UserVo> userData = new ArrayList<UserVo>();
                userData = (ArrayList<UserVo>) request.getAttribute("data");
                String id = (String) request.getAttribute("sign");
                if (userData == null) {
                    UserDAO userDAO = new UserDAO();
                    userData = (ArrayList<UserVo>) userDAO.selectUserById(id);
                }
                for (UserVo bean : userData) {
            %>
            <tbody>
            <td><%=bean.getId() %></td>
            <td><%=bean.getUsername() %></td>
            <td><%=bean.getPassword() %></td>
            <td><%=bean.getSex() %></td>
            <td><%=bean.getAddress() %></td>
            <td><%=bean.getAdddm() %></td>
            <td>
                <input type="submit" value="保存">
            </td>
            </tbody>
                <%
                }
            %>
        </table>
    </form>
</body>
</html>
