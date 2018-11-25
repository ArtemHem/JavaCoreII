package ru.sidorenko.jc.levelVII;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestClassAnnotation {

    public void start(){
        String nameMethodBefore = "";
        String nameMethodAfter = "";
        String nameMethodTest = "";

        int afterCount = 0;
        int beforeCount = 0;

        final Map<String,Integer> listArray;

        final Class clazz = this.getClass();
        final Method[] methods = clazz.getMethods();
        listArray = new HashMap<>();
        for (final Method m : methods) {
            final Annotation[] annotation = m.getDeclaredAnnotations();
            for (final Annotation a : annotation) {
                final String annTestName = "@ru.sidorenko.jc.levelVII.Test";
                final String annBeforeName = "@ru.sidorenko.jc.levelVII.BeforeSuite()";
                final String annAfterName = "@ru.sidorenko.jc.levelVII.AfterSuite()";

                final int checkText = a.toString().indexOf(annTestName);
                if (checkText != -1){
                    nameMethodTest = m.getName();
                    Test annTest = m.getAnnotation(Test.class);
                    int valueTest = annTest.value();
                    listArray.put(nameMethodTest,valueTest);
                }
                if (a.toString().equalsIgnoreCase(annBeforeName)){
                    beforeCount++;
                    checkLimit(beforeCount);
                    nameMethodBefore = m.getName();
                }
                if (a.toString().equalsIgnoreCase(annAfterName)){
                    afterCount++;
                    checkLimit(afterCount);
                    nameMethodAfter = m.getName();
                }
            }
        }

        invokeMethod(nameMethodBefore);
        invokeSortTest(listArray);
        invokeMethod(nameMethodAfter);
    }

    @Test
    public void testArray(){
        System.out.println("Start method Test - testArray");
    }

    @AfterSuite
    public void testPrint(){
        System.out.println("Start method AfterSuite - testPrint");
    }

    @BeforeSuite
    public void testClassMethod(){
        System.out.println("Start method BeforeSuite - testClassMethod");
    }

    @Test(value = 3)
    public void testArrayNew(){
        System.out.println("Start method Test - testArrayNew");
    }

    private void invokeSortTest(@NotNull Map<String,Integer> array){
        for(int i = 10; i>0; i--){
            for(Map.Entry<String,Integer> o : array.entrySet()){
                int valueMap = o.getValue();
                if(valueMap == i){
                    try {
                        String str = o.getKey();
                        Method mTest = this.getClass().getMethod(str);
                        mTest.invoke(this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void invokeMethod(@NotNull String nameMethod){
        try {
            Method method = this.getClass().getMethod(nameMethod);
            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkLimit(int count){
        if (count > 1){
            throw new RuntimeException();
        }
    }

}
