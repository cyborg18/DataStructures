package datastructuresandalgorithms;

import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args)
	{
		int key=0,hole=0;
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		for(int i=1;i<n;i++)
		{
			key=a[i];
			hole=i;
			while(hole>0&&a[hole-1]>key)
			{
				a[hole]=a[hole-1];
				hole--;
			}
			a[hole]=key;
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		s.close();
	}

}
