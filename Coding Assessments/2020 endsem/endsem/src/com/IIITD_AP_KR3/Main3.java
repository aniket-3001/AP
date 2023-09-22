package com.IIITD_AP_KR3;

//Q3: This code has throws a null pointer exception.
// The classes A,B & C cannot be changed.
// Please handle this exception using try-catch in the main function itself such that there is no null pointer exception and the program outputs the desired result, i.e. 5.



public class Main3 {

    public static void main(String[] args) {
        (new C()).display();
    }
}

class A{
    int i=5;
}

class B{
    A a;
}

class C extends B{
    void display(){
        System.out.println(a.i);
    }
}