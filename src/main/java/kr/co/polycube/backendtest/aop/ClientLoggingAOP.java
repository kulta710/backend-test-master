package kr.co.polycube.backendtest.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ClientLoggingAOP {

    @Autowired
    private HttpServletRequest request;

    @Before("execution(* kr.co.polycube.backendtest.controller.UserController.*(..))")
    public void execute() throws Throwable {

        log.info(request.getHeader("User-Agent"));
    }
}