package com.IIITD_AP_KR3;

//Q7: The current code prints the address of the complex number c.
// Add a function to the complex class to ensure that printing of c results in printing of the actual complex number, i.e. 5.5+7.5i.

public class Main7 {
    public static void main(String[] args) {
        complex c=new complex(5.5,7.5);
        System.out.println(c);
    }
}

class complex{
    double re;
    double im;
    complex(double re, double im){
        this.re=re;
        this.im=im;
    }
}