package codealpha.controller;
import java.io.*;
import java.util.Scanner;
class add{
	void show (int x,int y){
	System.out.println(x+y);
}}
class sub{
	void show(int a,int b) {
		System.out.println(a-b);
	}
}
public class studentGrade {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,opt;
		System.out.println("Enter value for a: ");
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		System.out.println("Enter value for b: ");
		b=sc.nextInt();
		System.out.println("Enter 1 for addition and enter 2 for sub ");
		opt=sc.nextInt();
		if(opt==1) {
		add ad=new add();
		ad.show(a,b);}
		else if(opt==2) {
			sub su=new sub();
			su.show(a,b);
		}
		else {
			System.out.println("invalid");
		}
		

	}

}
