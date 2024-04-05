package cha20;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class MyClass {
    public void myMethod() {
        // 메서드 내용
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = MyClass.class;
        // Class<?> 클래스의 인스턴스에 클래스 정보를 저장하고 있다.
        Method method = clazz.getMethod("myMethod");
        // Method 클래스의 인스턴스에 getMethod를 활용해 메소드를 저장하고 잇다 (아규먼트와 문자열이 일치하는 메소드명을 가진 메소드를 저장)
        method.invoke(clazz.newInstance());
    }
}