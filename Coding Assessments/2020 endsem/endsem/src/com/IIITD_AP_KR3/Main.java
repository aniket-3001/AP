package com.IIITD_AP_KR3;

//Q1: Convert this code such that it does the same job but by implementing the Runnable interface

public class Main {
    public static void main(String[] args) {
	      th t1=new th(1);
          th t2=new th(2);
        t1.start();
          t2.start();
    }
}

class th extends Thread{
    int i;
    th(int i){
        this.i=i;
    }
    @Override
    public void run(){
        int j=0;
        for (j=1;j<1000;j++){
            System.out.println(i);
        }
    }
}