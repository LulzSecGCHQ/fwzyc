<%--
  Created by IntelliJ IDEA.
  User: user_yu
  Date: 2019/9/12
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ArrayList" %>
<%@ page
        import="com.fwzyc.VO.UserVo,com.fwzyc.DAO.UserDAO"%>
<%@ page import="org.w3c.dom.UserDataHandler" %>
<html>
<head>
    <title>欢迎登录京津冀非物质文化遗址管理系统</title>
</head>
<body>
    <h2 align="center">用户管理首页</h2>
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
            if (userData == null) {
                UserDAO userDAO = new UserDAO();
                userData = (ArrayList<UserVo>) userDAO.get_ListInfo();
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
                <button type="button" class="btn btn-warning btn-xs"
                        onclick="showInfo(<%=bean.getId() %>)">修改</button>
                <button type="button" class="btn btn-danger btn-xs"
                        onclick="deleteUser(<%=bean.getId()%>)">删除</button>
            </td>
        </tbody>
        <%
            }
        %>
    </table>
    <script type="text/javascript">
        //根据用户逐渐id删除用户信息
        function deleteUser(id) {
            con=confirm("是否删除?");
            if(con==true){
                location.href = "/fwzyc_war_exploded/deleteUserServlet?id="+id;
            }
        }
        function showInfo(id) {
            location.href = "/fwzyc_war_exploded/showUserByIdServlet?id="+id;
        }
    </script>
</body>
</html>
