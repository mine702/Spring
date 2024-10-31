package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0() {
        Hello target = new Hello();

        log.info("start");
        String result1 = target.callA();
        log.info("result = {}", result1);

        log.info("start");
        String result2 = target.callB();
        log.info("result = {}", result2);
    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello hello = new Hello();
        Method callA = classHello.getMethod("callA");
        Object result1 = callA.invoke(hello);
        log.info("result1 = {}", result1);

        Method callB = classHello.getMethod("callB");
        Object result2 = callB.invoke(hello);
        log.info("result2 = {}", result2);
    }

    @Test
    void reflection2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> classHello = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello hello = new Hello();

        Method callA = classHello.getMethod("callA");
        dynamicCall(callA, hello);

        Method callB = classHello.getMethod("callB");
        dynamicCall(callB, hello);
    }

    private void dynamicCall(Method method, Object object) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        Object result = method.invoke(object);
        log.info("result = {}", result);
    }

    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }
}