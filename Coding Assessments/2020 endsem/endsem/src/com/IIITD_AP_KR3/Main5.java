package com.IIITD_AP_KR3;

//Q5: There is a null pointer error exception in this code.
// By adding appropriate initialization blocks, ensure that the null pointer exception is removed.

public class Main5 {
    static B5 b;
    int i=5;
    public static void main(String[] args) {
        System.out.println(b.a.m.i);
    }
}

class A5{
    Main5 m;
}

class B5 {
    A5 a;
}

