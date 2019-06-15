package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static String method1() {
        method2();
        String methodName = "";
        int i = 0;
        for (StackTraceElement line: Thread.currentThread().getStackTrace()){
            if(i == 2){
                methodName = line.getMethodName();
            }
            i++;
        }

        return methodName;
    }

    public static String method2() {
        method3();
        String methodName = "";
        int i = 0;
        for (StackTraceElement line: Thread.currentThread().getStackTrace()){
            if(i == 2){
                methodName = line.getMethodName();
            }
            i++;
        }

        return methodName;
    }

    public static String method3() {
        method4();
        String methodName = "";
        int i = 0;
        for (StackTraceElement line: Thread.currentThread().getStackTrace()){
            if(i == 2){
                methodName = line.getMethodName();
            }
            i++;
        }

        return methodName;
    }

    public static String method4() {
        method5();
        String methodName = "";
        int i = 0;
        for (StackTraceElement line: Thread.currentThread().getStackTrace()){
            if(i == 2){
                methodName = line.getMethodName();
            }
            i++;
        }

        return methodName;
    }

    public static String method5() {
        String methodName = "";
        int i = 0;
        for (StackTraceElement line: Thread.currentThread().getStackTrace()){
            if(i == 2){
                methodName = line.getMethodName();
            }
            i++;
        }

        return methodName;
    }
}
