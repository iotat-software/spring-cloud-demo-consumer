package cn.iotat.consumer.aop;

import cn.iotat.consumer.util.json.JsonUtil;
import cn.iotat.consumer.util.param.ParamUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Pang
 * @date 2020/10/22
 */
@Aspect
@Component
public class ClientLoggerAspectConfig {

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
        long start = System.currentTimeMillis();
        // 类名
        String className = point.getSignature().getDeclaringTypeName();
        // 方法名
        String methodName = point.getSignature().getName();
        // 参数
        Map<String, Object> argsMap = ParamUtil.getArgsMap(point);
        // 结果
        Object result = null;
        try {
            result = point.proceed();
            LOG.info("{}#{},args={},result={}", className, methodName, JsonUtil.map2JsonStr(argsMap), result);
        } catch (Throwable e) {
            LOG.error("{}#{},args={}", className, methodName, JsonUtil.map2JsonStr(argsMap), e);
        } finally {
            long time = System.currentTimeMillis() - start;
            LOG_MONITOR.info("{}#{}|{}", className, methodName, time);
        }
        return result;
    }

}