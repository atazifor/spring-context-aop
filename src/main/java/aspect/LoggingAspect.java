package aspect;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Order(2)
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logging Aspect: Calling Intercepted Method");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Logging Aspect:  Method has been executed and returned " + returnedByMethod);
        return returnedByMethod;
    }
}
