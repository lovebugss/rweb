package com.itrjp.common.exception;

import com.itrjp.common.constant.CodeMsg;
import com.itrjp.common.entity.Email;
import com.itrjp.common.result.PagedResult;
import com.itrjp.common.result.Result;
import com.itrjp.common.util.EmailUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * 通过aop方式拦截异常
 * Created by ren on 2018/10/18.
 */
@Aspect
@Component
public class AopControllerExceptionHandler {
    //本地异常日志记录对象
    private  static  final Logger logger = (Logger) LoggerFactory.getLogger(AopControllerExceptionHandler.class);
    //Controller层切点
    @Pointcut("execution(public com.itrjp.common.result.Result *(..))")
    public  void controllerAspect() {
    }
    /**
     * 异常通知 用于拦截记录异常日志
     * @param joinPoint
     */
    @Around(value = "controllerAspect()")
    public  Object doAfterThrowing(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result;
        PagedResult<?> pagedResult;

        try {
            result =  joinPoint.proceed();

            // 如果需要打印入参，可以从这里取出打印
             Object[] args = joinPoint.getArgs();

            // 本次操作用时（毫秒）
            long elapsedTime = System.currentTimeMillis() - startTime;
            logger.info("[{}]use time: {}args:{}>>result:{}", joinPoint.getSignature(),args, elapsedTime,result);
        } catch (Throwable e) {
            result = handlerException(joinPoint, e);
        }

        return result;
    }
    private Result<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        Result<?> result = null;

        // 已知异常【注意：已知异常不要打印堆栈，否则会干扰日志】
        // 校验出错，参数非法
        if (e instanceof GlobalException || e instanceof IllegalArgumentException) {
            result = Result.error(CodeMsg.SERVER_ERROR);
        }
        else {
            logger.error(pjp.getSignature() + " error ", e);

            // TODO 未知的异常，应该格外注意，可以发送邮件通知等
            Email email = new Email();
            EmailUtil.sendExceptionInfo(pjp.getSignature()+ "error :"+e);
            result = Result.error(CodeMsg.SERVER_ERROR);
        }

        return result;
    }
}
