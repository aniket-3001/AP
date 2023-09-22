package com.IIITD_AP_KR3;

//Q4: Currently there is a composition relationship between A4 & B4.
// Mopdify this code in such a way that there is an association relationship between A4 & B4 and the program still prints 5.

public class Main4 {
    public static void main(String[] args) {
        System.out.println((new B4()).a.i);
    }
}

class A4{
    int i=5;
}

class B4{
    A4 a;
    B4(){
        a=new A4();
    }
}