package cn.whs.jwt.core.config.mutidatasource.annotion;

import java.lang.annotation.*;

/**
 * @author 武海升
 * @version 2.0
 * @description 多数据源标识
 * @date 2018-03-22 16:26
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface DataSource {
    String name() default "";
}
