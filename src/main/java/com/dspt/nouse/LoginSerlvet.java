//package com.dspt.tools;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//public class LoginSerlvet extends HttpServlet {
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        /*
//         * 1. 获取表单数据
//         */
//        // 处理中文问题
//        request.setCharacterEncoding("utf-8");
//        // 获取表单数据
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        /*
//         * 2. 校验用户名和密码是否正确,预设用户名和密码分别为：“root”，“0000”
//         */
//        if ("root".equalsIgnoreCase(username) && "0000".equals(password)) {
//
//            /******* 附加项 - start********************************************************/
//            // 把用户名保存到cookie中，发送给客户端浏览器。
//            // 当再次打开login.jsp时，login.jsp中会读取request中的cookie，把它显示到用户名文本框中
//
//            // 1. 创建cookie
//            Cookie cookie = new Cookie("uname", username);
//            // 2. 设置cookie生命时长为7天。
//            cookie.setMaxAge(60 * 60 * 24 * 7);
//            // 3. 保存cookie
//            response.addCookie(cookie);
//            /******* 附加项 - end *********************************************************/
//
//
//            /*
//             * 3.如果成功 -> 保存用户信息到session中 -> 重定向到succ1.jsp
//             */
//
//            // 获取session
//            HttpSession session = request.getSession();
//            // 向session域中保存用户名
//            session.setAttribute("username", username);
//            // 重定向到succ1.jsp
//            response.sendRedirect("/JavaWebLearning/session2/succ1.jsp");
//        } else {
//            /*
//             * 如果失败 -> 保存错误信息到request域中 -> 转发到login.jsp
//             */
//            // 保存错误信息到request域
//            request.setAttribute("msg", "用户名或密码错误！");
//            // 得到一个转发器
//            RequestDispatcher qr = request.getRequestDispatcher("/session2/login.jsp");
//            // 转发
//            qr.forward(request, response);
//        }
//    }
//
//}
