//package com.dspt.tools;
//
///**
// * 执行登录
// */
//public JSONObject doLogin(String username, String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
//        // 最终返回的对象
//        JSONObject res = new JSONObject();
//        res.put("code", 0);
//        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//        res.put("msg", "请输入手机号或密码");
//        return res;
//        }
//        UserInfo dbUser = dao.getUserInfoByAccount(username);
//        if (null == dbUser) {
//        res.put("msg", "该账号不存在，请检查后重试");
//        return res;
//        }
//        // 验证密码是否正确
//        String newPassword = PasswordUtils.getMd5(password, username, dbUser.getSalt());
//        if (!newPassword.equals(dbUser.getPassword())) {
//        res.put("msg", "手机号或密码错误，请检查后重试");
//        return res;
//        }
//        // 判断账户状态
//        if (1 != dbUser.getStatus()) {
//        res.put("msg", "该账号已被冻结，请联系管理员");
//        return res;
//        }
//        // 将登录用户信息保存到session中
//        session.setAttribute(Const.SYSTEM_USER_SESSION, dbUser);
//        // 保存cookie，实现自动登录
//        Cookie cookie_username = new Cookie("cookie_username", username);
//        // 设置cookie的持久化时间，30天
//        cookie_username.setMaxAge(30 * 24 * 60 * 60);
//        // 设置为当前项目下都携带这个cookie
//        cookie_username.setPath(request.getContextPath());
//        // 向客户端发送cookie
//        response.addCookie(cookie_username);
//        res.put("code", 1);
//        res.put("msg", "登录成功");
//        return res;
//        }
