package cn.lp.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.handler
 * @Author: lp
 * @CreateTime: 2023-02-23  11:06
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {
    //拦截于请求刚进入时，进行判断，需要boolean返回值，如果返回true将继续执行，如果返回false，将不进行执行。一般用于登录校验
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入handler");
        request.setAttribute("startTime", System.currentTimeMillis());
//        response.setContentType("text/html;charset=UTF-8");
//        response.getWriter().write("您还未登录，请先登录！");
        /**
         在实现自定义拦截器时，可以通过调用父类的方法来保留默认的拦截逻辑。
         因此，在当前代码中，调用super.preHandle(request, response, handler)方法是为了保留父类HandlerInterceptorAdapter中默认的拦截逻辑，
         并在此基础上添加自己的拦截逻辑。
         **/
//        return super.preHandle(request, response, handler);
        return true;
    }
    //拦截于方法成功返回后，视图渲染前，可以对modelAndView进行操作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long endTime = System.currentTimeMillis();
        long executeTime = endTime - startTime;
        log.info("executeTime: {}ms", executeTime);

    }

    //拦截于方法成功返回后，视图渲染前，可以进行成功返回的日志记录
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        log.info("哈哈哈");
        super.afterCompletion(request, response, handler, ex);
    }

    //不是HandlerInterceptor的接口实现，是AsyncHandlerInterceptor的，AsyncHandlerInterceptor实现了HandlerInterceptor
    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    }

}

