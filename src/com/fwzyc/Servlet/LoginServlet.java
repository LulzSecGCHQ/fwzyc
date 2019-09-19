package com.fwzyc.Servlet;

import com.fwzyc.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//		doGet(request, response);
        //登录的判断
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //对账号和密码进行判断
        UserDAO userDAO = new UserDAO();
        boolean result = userDAO.Login_verify(username, password);
        HttpSession session = request.getSession();
        //判断输入正确
        if(result){
            String adddm = userDAO.getAdddm(username,password);
            if("0".equals(adddm)){
                System.out.println("管理员登录成功"+adddm);
                response.sendRedirect("/fwzyc_war_exploded/index.jsp");
            }else if("1".equals(adddm)){
                System.out.println("北京用户登录成功"+adddm);
                response.sendRedirect("/fwzyc_war_exploded/indexBJ.jsp");
            }else if("2".equals(adddm)){
                System.out.println("天津用户登录成功"+adddm);
                response.sendRedirect("/fwzyc_war_exploded/indexTJ.jsp");
            }else if("3".equals(adddm)){
                System.out.println("湖北用户给登录成功"+adddm);
                response.sendRedirect("/fwzyc_war_exploded/indexHB.jsp");
            }else{
                System.out.println("其他地区用户登录成功"+adddm);
                response.sendRedirect("/fwzyc_war_exploded/indexQT.jsp");
            }
        }else{
            //没有找到对应的账号和密码，返回重新登录
            session.setAttribute("state", "密码错误");
            response.sendRedirect("/fwzyc_war_exploded/login.jsp");
        }
    }
}
