package com.intouch.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.intouch.util.PropertiesUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ClassName ServiceTrace
 * @Description TODO
 * @Author szhend
 * @Date 2020/11/5 15:42
 * @Version 1.0
 */

@Component
@Lazy
@Aspect
public class ServiceTrace {

    private final DateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss SSS");

    @Pointcut("within(com.intouch.service.*)")
    private void serviceTrace() {
    }

    @Around("serviceTrace()")
    public Object traceLog(ProceedingJoinPoint pjoint) throws Throwable {

        String methodInfo = getMethodInfo(pjoint);

        long start = System.currentTimeMillis();

        System.out.println("AOP环绕通知:" + dateFormat.format(new Date(start))
                + " " + methodInfo + "开始执行...");

        Object obj = pjoint.proceed();

        long end = System.currentTimeMillis();

        System.out.println("AOP环绕通知:" + dateFormat.format(new Date(start))
                + " " + methodInfo + "已经执行完毕;耗时：" + (end - start) + "毫秒!");

        return obj;

    }

    private String getMethodInfo(ProceedingJoinPoint pjoint) {
        String className = pjoint.getTarget().getClass().getName();
        String methodName = pjoint.getSignature().getName();
        String key = className + "." + methodName;
        String value = PropertiesUtil.getValue(key);
        return value;

    }
}
