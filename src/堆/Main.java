package ¶Ñ;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Scanner;


class Bubble{
	public static void sort(Comparable []a) {
		for(int i=a.length-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(compareTo(a[j],a[j+1])>0) {
		exit(a,j,j+1);
				}
			}
		}
	}
	
	public static void exit(Comparable[] a,int i,int j) {
		Comparable num=a[i];
	a[i]=a[j];
		a[j]=num;
	}
	public static int compareTo(Comparable a,Comparable b) {
		return a.compareTo(b);
	}
	
}
class Main{
	public static void main(String []args) {
		Integer[]a= {1,4,3,5,8,6,5};
		Bubble.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
}