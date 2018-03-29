package cn.whs.db.core.mysql.dynamicAop;


import cn.whs.db.core.mysql.DataSourceContextHolder;
import cn.whs.db.core.mysql.DataSourceName;
import cn.whs.db.core.mysql.annotion.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 13:19
 */
@Slf4j
@Aspect
@Component
@ConditionalOnProperty(prefix = "dynamicSwitch", name = "multi-datasource-open", havingValue = "true")
public class MultiDynamicAop implements Ordered {

    @Pointcut(value = "@annotation(cn.whs.db.core.mysql.annotion.DataSource)")
    private void dynamicSwitch() {

    }
    @Around("dynamicSwitch()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Signature signature = point.getSignature();
        MethodSignature methodSignature;
        if (!(signature instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
       methodSignature = (MethodSignature) signature;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());

        DataSource datasource = currentMethod.getAnnotation(DataSource.class);
        if (datasource != null) {
            DataSourceContextHolder.setDataSourceType(datasource.name());
            log.debug("设置数据源为：" + datasource.name());
        } else {
            DataSourceContextHolder.setDataSourceType(DataSourceName.DATA_SOURCE_CORE);
            log.debug("设置数据源为：dataSourceCore");
        }
        try {
            return point.proceed();
        } finally {
            log.debug("清空数据源信息！");
            DataSourceContextHolder.clearDataSourceType();
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
