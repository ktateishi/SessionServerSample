package com.ktateishi.session_server_sample.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@Component
public class SampleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        // セッションがなければログインしていないとみなしログイン画面へ遷移
        if (!"/login".equals(((HttpServletRequest) servletRequest).getServletPath())
                && ((HttpServletRequest) servletRequest).getSession().isNew()) {
            log.info("未ログインのため、ログイン画面へ遷移");
            RequestDispatcher rd = servletRequest.getRequestDispatcher("/");
            rd.forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
