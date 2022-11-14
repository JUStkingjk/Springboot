package com.official.project001.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AopLogin {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.official.project001.controller..*.*(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String funcname = signature.getName();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            assert attributes != null;
            HttpServletRequest request = attributes.getRequest();
            String url = request.getRequestURL().toString();
            String ip = request.getRemoteAddr();
            logger.info("\r\n[doBefore]执行方法为: {} \r\n属于包: {}\r\n用户请求的url： {} \r\nip地址： {}\r\n",funcname,declaringTypeName,url,ip);
    }
}
