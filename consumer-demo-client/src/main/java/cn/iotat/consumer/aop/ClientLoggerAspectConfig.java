package cn.iotat.consumer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Pang
 * @date 2020/10/22
 */
@Aspect
@Component
public class ClientLoggerAspectConfig extends AbstractAspectConfig {

    static final Logger LOG = LoggerFactory.getLogger(ClientLoggerAspectConfig.class);
    static final Logger LOG_MONITOR = LoggerFactory.getLogger("monitor");

    /**
     * 定义切面
     */
    @Pointcut("execution(* cn.iotat.consumer.client.*Client.*(..))")
    public void servicePoint() {
    }

    @Around("servicePoint()")
    public Object around(ProceedingJoinPoint point) {
        return printLog(LOG, LOG_MONITOR, point);
    }

}
