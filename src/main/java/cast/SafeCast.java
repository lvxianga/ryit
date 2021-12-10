package main.java.cast;

import java.util.HashMap;

/**
 * Description
 * 该类用于安全转换HashMap中value的类型，以做到容器中可以存放不同类型的值，方便取用
 * @author BoldPeanuts
 * @date Created on 2021/12/9
 */
public class SafeCast {
    private final HashMap<Class<?>,Object> hm = new HashMap();

    /**
     * 声明类型变量T，用key来装value的类型
     * @param key Class对象
     * @param value Object对象
     * @param <T> 类型对象，泛型方便装不同类型
     */
    public <T> void put(Class<T> key,Object value){
        hm.put(key,value);
    }

    /**
     * 泛型，有class文件非法装的危险，之后改
     * 在这里来转类型
     * @param key 类型
     * @param <T> 类型变量
     * @return
     */
    public <T> T get(Class<T> key){
        return key.cast(hm.get(key));
    }
}
