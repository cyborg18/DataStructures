package datastructuresandalgorithms;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStack {

	public static void main(String[] args) 
	{
		int n;
		Stacks st=new Stacks();
		Scanner s=new Scanner(System.in);
		do
		{
			System.out.println("1.enq,2.deq,3.display,4.exit");
			n=s.nextInt();
			switch(n)
			{
			case 1:
				System.out.println("Enter element");
				st.enque(s.nextInt());
				break;
			case 2:
				st.deque();
				break;
			case 3:
				st.display();
				break;
				
			}
		}while(n!=4);
		
	}

}
class Stacks
{
	Stack<Integer> s1=new Stack<Integer>();
	Stack<Integer> s2=new Stack<Integer>();
	void enque(int n)
	{
		s1.push(n);
	}
	void deque()
	{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		s2.pop();
	}
	void display()
	{
		int x;
		while(!s2.isEmpty())
		{
			x=s2.pop();
			System.out.println(x);
		}
		
	}
}