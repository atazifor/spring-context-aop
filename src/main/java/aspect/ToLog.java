package aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //let java intercept this annotation. By default annotations are not intercepted
@Target(ElementType.METHOD)
public @interface ToLog {
}
