package jp.co.ncsx.example.training;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sasakurahideyuki on 2017/06/08.
 */

public class ReflectionTest {

    public class CalledClass {

        public void exec() {

        }

        private String privateMethod(List<String> a) {
            System.out.println("called....");
            return "";
        }
    }

    @Test
    public void testReflectionCall() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CalledClass obj = new CalledClass();
        CalledClass.class.getDeclaredMethods();
//        Method target = null;
        for (Method method : CalledClass.class.getDeclaredMethods()) {
            if (method.getName().equals("privateMethod")) {
                method.setAccessible(true);
                method.invoke(obj, new ArrayList<String>());
//                target = method;
            }
        }
//        Method method = CalledClass.class.getDeclaredMethod("privateMethod", target.getParameterTypes()[0]);
//        method.setAccessible(true);
//        method.invoke(obj, new ArrayList<String>());
    }
}
