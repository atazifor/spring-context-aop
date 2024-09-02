package aspect;

import model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        logger.info("Method name: " + methodName +
                " with Parameters " + Arrays.asList(methodArgs) + " will execute");
        Object returnedByMethod = joinPoint.proceed();
        logger.info("Method has been executed and returned " + returnedByMethod);
        return "OTHER_RETURN";
    }
}
