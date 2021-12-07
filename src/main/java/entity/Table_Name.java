package student.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description
 * 该注释用于表示表名，只在类上方生效
 * @author BoldPeanuts
 * @date Created on 2021/12/7
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Table_Name {
    public String name();
}
