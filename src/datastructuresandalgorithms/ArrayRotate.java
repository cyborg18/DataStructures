package datastructuresandalgorithms;


import java.util.Scanner;

public class ArrayRotate 
{

	public static void main(String[] args)
	{
		Rotate r=new Rotate();
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		int k=s.nextInt();
		r.rotate(a,k);
		
	}

}
class Rotate
{
	public static void rotate(int[] arr, int order)
	{
		order = order % arr.length;
		if (arr == null || order < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
	 
		//length of first part
		int a = arr.length - order; 
	 
		reverse(arr, 0, a-1);
		reverse(arr, a, arr.length-1);
		reverse(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
	 
	}
	 
	public static void reverse(int[] arr, int left, int right){
		if(arr == null || arr.length == 1) 
			return;
	 
		while(left < right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}	
	}
}

