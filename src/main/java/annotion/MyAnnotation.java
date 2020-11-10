package annotion;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author guoxi_789@126.com
 * @date 2020/11/11
 */
@Target(ElementType.TYPE)//注解类型
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Documented//说明该注解包含在Javadoc中
@Inherited //说明子类可以继承该注解
public @interface MyAnnotation {
}

