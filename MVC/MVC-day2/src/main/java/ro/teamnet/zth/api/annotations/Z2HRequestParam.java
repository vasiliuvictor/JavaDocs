package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;


@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Z2HRequestParam {
    String name();
}
