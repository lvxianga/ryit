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

    public <T> void put(Class<T> key,Object value){
        hm.put(key,value);
    }

    public <T> T get(Class<T> key){
        return key.cast(hm.get(key));
    }
}
