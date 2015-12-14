package datastructuresandalgorithms;

import java.util.Scanner;

public class DoubleLinkedList
{

	public static void main(String[] args)
	{
		DLL temp=null;
		DLL node=null;
		Double l=new Double();
		Scanner s=new Scanner(System.in);
		int x;
		do
		{
			System.out.println("1.insert at begin\n2.insert at end\n"
					+ "3.delete linked list\n4.display\n5.delete from front\n"
					+ "6.delete from end\n7.Remove duplicate\n8.Nth Ele from End\n"
					+ "9.Rotate\n"
					+ "10.Cyclic or Null\n11.Reverse Pairs\n12.ReverseOrder(rec)\n"
					+ "13.ReverseOrder(Iterative)\n14.Pallindrome\n15.exit");
			x=s.nextInt();
			switch(x)
			{
			case 1:
				if(node==null)
				l.insertatbegin(s.nextInt());
				break;
			case 2:
				l.insertatend(s.nextInt());
				break;
			case 3:
				l.deletelist();
				break;
			case 4:
				l.display();
				break;
		/*	case 5:
				l.removeBegin();
				break;
			case 6:
				l.removeend();
				break;
			case 7:
				l.removeDuplicates();
				break;
			case 8:
				System.out.println("Enter nth place");
				l.nthElementFromEnd(s.nextInt());
				break;
			case 9:
				l.rotateLL(s.nextInt());
				break;
			case 10:
				l.CycOrNull();
				break;
			case 11:
				l.reversePairs();
				break;
			case 12:
				l.reverseOrderR(temp);
				break;
			case 13:
				l.reverseOrderI();
				break;
			case 14:
				l.pallindrome();
				break;*/
			}
			
			
		}while(x!=14);
	}

}
class DLL
{
	int data;
	DLL prev;
	DLL next;
	DLL()
	{
		data=0;
		prev=null;
		next=null;
	}
	DLL(int data,DLL prev,DLL next)
	{
		this.data=data;
		this.prev=prev;
		this.next=next;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public void setPrev(DLL prev)
	{
		this.prev=prev;
	}
	public DLL getPRev()
	{
		return prev;
	}
	public void setNext(DLL next)
	{
		this.next=next;
	}
	public DLL getNext()
	{
		return next;
	}
}
class Double
{
	int length=0;
	DLL head=null;
	public int length()
	{
		return length;
	}
	public void insertatbegin(int data)
	{
		DLL l=new DLL(data,null,null);
		if(head==null)
		{
		   l.setPrev(null);
		   l.setNext(null);
		   l.setData(data);
		   head=l;
		   length++;
		}
		else
		{
			l.setPrev(null);
			l.setNext(head);
			head.setPrev(l);
			head=l;
			length++;
		}
	}
	public void insertatend(int data)
	{
		DLL l=new DLL(data,null,null);
		if(head==null)
		{
		   l.setPrev(null);
		   l.setNext(null);
		   l.setData(data);
		   head=l;
		   length++;
		}
		else
		{
			DLL temp=head;
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			temp.setNext(l);
			l.setPrev(temp);
			l.setNext(null);
			length++;
		}
	}
	public void deletelist()
	{
		head=null;
	}
	public void display()
	{
		DLL temp=head;
		while(temp!=null)
		{
			System.out.println(temp.getData());
			temp=temp.getNext();
		}
	}
}
