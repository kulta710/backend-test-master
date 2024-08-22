package kr.co.polycube.backendtest.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(urlPatterns = {"/users/*"})
@Component
@Slf4j
public class URLCheckingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String requestURI = req.getRequestURI();
        Enumeration<String> parameterNames = req.getParameterNames();

        String regex = "[^a-zA-Z0-9가-핳ㄱ-ㅎㅏ-ㅣ?&=:/]";
        Pattern pattern = Pattern.compile(regex);

        boolean flag = false;

        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();

            if (pattern.matcher(parameterName).find()) {
                flag = true; break;
            }
            if (pattern.matcher(req.getParameter(parameterName)).find()) {
                flag = true; break;
            }
        }

        if (pattern.matcher(requestURI).find()) flag = true;

        if (flag) {
            res.sendError(400, "the url contains characters not allowed.");

            log.warn("not appropriate url");

            return;
        }

        chain.doFilter(request, response);
    }
}