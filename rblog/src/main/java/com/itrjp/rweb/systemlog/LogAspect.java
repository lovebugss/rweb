package com.itrjp.rweb.systemlog;

import com.alibaba.fastjson.JSONObject;
import com.itrjp.common.util.HelpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author renjp
 *         Created by ren on 2018/10/18.
 */
@Aspect
@Component
public class LogAspect {

    //本地异常日志记录对象
    private static final Logger logger = (Logger) LoggerFactory.getLogger(LogAspect.class);

    //Service层切点
    @Pointcut("@annotation(com.itrjp.rweb.systemlog.SystemLog)")
    public void serviceAspect() {
    }

    //Controller层切点
    @Pointcut("@annotation(com.itrjp.rweb.systemlog.SystemLog)")
    public void controllerAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作*
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {

    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
        HttpServletRequest request = HelpUtils.getRequest();
        //请求的IP
        String ip = request.getHeader("X-Real-IP");
        String params = JSONObject.toJSONString(joinPoint.getArgs());
        try {
            String description = getServiceMethodDescription(joinPoint).get("description").toString();

            // 记录下请求内容
            logger.info("URL : " + request.getRequestURL().toString());
            logger.info("HTTP_METHOD : " + request.getMethod());
            logger.info("description : " + description);
            logger.info("IP : " + ip);
            logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            logger.info("ARGS : " + params);
        } catch (Exception e) {

            logger.error("==前置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning(returning = "ret", pointcut ="controllerAspect()")
    public void afterReturn(Object ret) {
        try {
            logger.info("response:"+ret);
        } catch (Exception e) {
            logger.error("==后置通知异常==");
            logger.error("异常信息:{}", e.getMessage());
        }
    }

    /**
     * 异常通知 用于拦截记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //请求的IP
        String ip = request.getRemoteAddr();
        String params = JSONObject.toJSONString(joinPoint.getArgs()[0]);
        try {
            String description = getServiceMethodDescription(joinPoint).get("description").toString();
            logger.info("");
        } catch (Exception ex) {
            logger.error("==异常通知异常==");
            logger.error("异常信息:{}", ex.getMessage());
        }

    }

    /*
    * 获取注解中的参数信息
    * */
    public static JSONObject getServiceMethodDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        SystemLog.OperateType type = null;
        String modular = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemLog.class).description();
                    type = method.getAnnotation(SystemLog.class).type();
                    modular = method.getAnnotation(SystemLog.class).modular();
                    break;
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("description", description);
        jsonObject.put("type", type);
        jsonObject.put("modular", modular);
        return jsonObject;
    }

}
