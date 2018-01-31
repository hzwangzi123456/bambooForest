package com.common.system;

import com.alibaba.druid.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器,未登录则跳转到登录页面
 *
 * @author wangzi
 * @date 18/1/26 上午2:22.
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 进入handler前的拦截器
     *
     * @param request
     * @param response
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
//        // 从request中获取session
//        HttpSession session = httpServletRequest.getSession();
//        // 从session中获取username
//        Object username = session.getAttribute("username");
//        // 如果是登录直接放行
//        if ("/UserController/login.do".equals(httpServletRequest.getServletPath())) {
//            return true;
//        }
//        // 判断username是否为null
//        if (username != null) {
//            // 如果不为空则放行
//            return true;
//        } else {
//            // 如果为空则跳转到登录页面
//            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/html/index/index.html");
//            return false;
//        }
        // 如果是登录直接放行
        if ("/UserController/login.do".equals(request.getServletPath())) {
            return true;
        }
        Object username = request.getSession().getAttribute("user");
        String type = request.getHeader("X-Requested-With");// XMLHttpRequest
        if (username == null) {
            // 重定向
            String contextPath = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
            //response.sendRedirect(contextPath+"/index.jsp");
            // System.err.println("sendRedirect");
            // 转发
            if (StringUtils.equals("XMLHttpRequest", type)) {
                // ajax请求
                response.setHeader("SESSIONSTATUS", "TIMEOUT");
                response.setHeader("CONTEXTPATH", contextPath + "/html/index/index.html");
                //设置403状态码
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;

            } else {
                response.sendRedirect(basePath + "/html/index/index.html");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
