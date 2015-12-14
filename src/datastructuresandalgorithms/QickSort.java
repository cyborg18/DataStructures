package datastructuresandalgorithms;

import java.util.Scanner;

public class QickSort
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
	    int[] A=new int[n];
	    for(int i=0;i<n;i++)
	    {
	    	A[i]=s.nextInt();
	    }
	    int low=0,high=n-1;
		quickSort(A,low,high);
		for(int i=0;i<n;i++)
		{
			System.out.println(A[i]);
		}
	}
	public static void quickSort(int[] A,int start,int end)
	{
		if(start<end)
		{
			int pi=partition(A,start,end);
			quickSort(A,start,pi-1);
			quickSort(A,pi+1,end);
		}
	}
	public static int partition(int[] A,int start,int end)
	{
		int pi=start;
		int p=A[end];
		for(int i=start;i<end;i++)
		{
			if(A[i]<=p)
			{
				swap(A,i,pi);
				pi++;
			}
		}
		swap(A,pi,end);
		return pi;
	}
	public static void swap(int[] A,int l,int h)
	{
		int temp;
		temp=A[l];
		A[l]=A[h];
		A[h]=temp;
	}
}
