package kr.co.polycube.backendtest.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = {"/users/*"})
@Component
@Slf4j
public class URLCheckingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestURI = ((HttpServletRequest)request).getRequestURI();

        String regex = "[^a-zA-Z0-9가-핳ㄱ-ㅎㅏ-ㅣ?&=:/]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(requestURI);

        if (matcher.find()) {
            log.warn("not appropriate url");
        } else {
            chain.doFilter(request, response);
        }
    }
}