package datastructuresandalgorithms;

import java.util.HashSet;
import java.util.Scanner;

public class SingleLinkedList
{

	public static void main(String[] args) 
	{
		LL temp=null;
		LinkedList l=new LinkedList();
		Scanner s=new Scanner(System.in);
		int x;
		do
		{
			System.out.println("1.insert at begin  2.insert at end  "
			+ "3.delete linked list  4.display  5.delete from front\n"
			+ "6.delete from end  7.Remove duplicate  8.Nth Ele from End  "
			+ "9.Rotate to right by k places  10.Cyclic or Null\n11.Reverse Pairs  12.Reverse print(rec)  "
			+ "13.Reverse LinkedList(Iterative)  14.Reverse LinkedList(Recursive)\n"
			+ "15.Pallindrome  16.reverse k elements of LL  17.Remove Duplicates(No Extra Space) "
			+ "18.exit");
			x=s.nextInt();
			switch(x)
			{
			case 1:
				temp=l.insertBegin(s.nextInt());
				break;
			case 2:
				l.insertEnd(s.nextInt());
				break;
			case 3:
				l.deleteList();
				break;
			case 4:
				l.display();
				break;
			case 5:
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
				l.reversePrint(temp);
				break;
			case 13:
				l.reverseLLI();
				break;
			case 14:
				l.reverseLLR(temp);
			    break;
			case 15:
				l.pallindrome();
				break;
			case 16:
				l.reversekElementsOfLL(s.nextInt());
				break;
			case 17:
				l.removeDuplicates1();
				break;
			}
		}while(x!=18);
		s.close();
	}

}
class LL
{
	int data;
	LL next;
	LL()
	{
		data=0;
		next=null;
	}
	LL(int data,LL next)
	{
		this.data=data;
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
	public void setNext(LL next)
	{
		this.next=next;
	}
	public LL getNext()
	{
		return this.next;
	}
}
class LinkedList
{
	int length=0;
	LL head=null;
	public LL getHead()
	{
		return head;
	}
	
	public void deleteList()
	{
		head=null;
	}
	
	public LL insertBegin(int input)
	{
		LL node=new LL(input,null);
		if(head==null)
		{
			head=node;
			node.setNext(null);
		}
		else
		{
			node.setNext(head);
			head=node;
		}
		length++;
		return head;
	}
	
	public void insertEnd(int input)
	{
		LL node=new LL(input,null);
		if(head==null)
		{	
			head=node;
			node.setNext(null);
		}
		else
		{
			LL temp=head;
			while(temp.getNext()!=null)
			{
				temp=temp.getNext();
			}
			temp.setNext(node);
			node.setNext(null);
		}
		length++;
	}
	
	public void removeBegin()
	{
		if(head==null)
		{
			System.out.println("No Elements");
		}
		else
		{
			LL temp=head;
			head=head.getNext();
			temp.setNext(null);
			temp=null;
		}
	}
	
	public void removeend()
	{
		LL temp=head;
		LL temp1=temp;
		while(temp.getNext()!=null)
		{
			temp1=temp;
			temp=temp.getNext();
		}
		temp1.setNext(null);
		temp=null;
	}
	
	public void insert(int data,int pos)
	{
		
	}
	
	public void display()
	{
		LL temp=head;
		while(temp!=null)
		{
			System.out.print(temp.getData()+"->");
			temp=temp.getNext();
		}
		System.out.println("null "+"\nlength of List"+" : "+length);
	}
	
	//Removing Duplicates With Extra Space
    public void removeDuplicates()
    {
    	HashSet<Integer> h=new HashSet<Integer>();
    	LL temp=head,temp1=head;
    	while(temp!=null)
    	{
    		
    		if(!h.contains(temp.getData()))
    		{
    			h.add(temp.getData());          
    		}                                
    		else
    		{
    			temp1.setNext(temp.getNext());
    			temp.setNext(null);
    			temp=temp1;
    		}
    		temp1=temp;
    		temp=temp.getNext();
    	}
    	display();
    }
    
    //Remove Duplicates Without Extra Space
    public void removeDuplicates1()
    {
    	if(head==null) return;
    	LL temp1=head,temp2,temp3=null;
    	while(temp1.getNext()!=null)
    	{
    		temp2=temp1.getNext();
    		while(temp2!=null)
    		{
    			if(temp1.getData()==temp2.getData())
    			{
    				temp3.setNext(temp2.getNext());
    				temp2.setNext(null);
    				temp2=temp3;
    			}
    			else
    			{
    				temp3=temp2;
    				temp2=temp2.getNext();
    			}
    		}
    		temp1=temp1.getNext();
    	}
    	display();
    }
    
    //Nth Element From End
    public void nthElementFromEnd(int k)
    {
    	LL temp=head;
    	for(int i=1;i<k;i++)
		{
			temp=temp.getNext();
		}
    	LL temp1=head;
    	while(temp.getNext()!=null)
    	{
    		temp1=temp1.getNext();
    		temp=temp.getNext();	
    	}
    	System.out.println(temp1.getData());
    }
    
    //Reverse Linked List By K Places.if list is 1 2 3 4 5 6 and k=3 then 3 2 1 4 5 6 
    public void reversekElementsOfLL(int k)
    {
    	LL temp=null,curr=head,prev=null,next=null;
    	while(curr!=null&&k>0)
    	{
    		next=curr.getNext();
    		curr.setNext(prev);
    		prev=curr;
    		if(prev==head)
    			temp=prev;
    		curr=next;
    		k--;
    	}
    	temp.setNext(next);
    	head=prev;
    	display();
    }
    
    //Finding If LL Is Null Terminated Or Cyclic
    public void CycOrNull()
    {
    	int flag=0;
    	LL sp=head,fp=head;
    	while(fp!=null&&fp.getNext()!=null)
    	{
    		fp=fp.getNext();
    		fp=	fp.getNext();
    		sp=sp.getNext();
    		if(sp==fp)
    		{
    			flag=1;
    			System.out.println("Cyclic");
    			break;
    		}
    	}
    	if(flag==0)
    	{
    		System.out.println("Null Terminated");
    	}
    }
    
    //Reverse Pairs In The Given LL
    public void reversePairs()
    {
    	LL temp=head,temp1=head;
    	while(temp!=null)
    	{
    		if(temp==head)
    		{
    			temp1=temp;
    			temp=temp.getNext();
    			temp1.setNext(temp.getNext());
    			temp.setNext(temp1);
    			head=temp;
    		}
    		else
    		{
    			temp1=temp1.getNext();
    			temp=temp.getNext();
    			temp=temp.getNext();
    			temp1.setNext(temp.getNext());
    			temp.setNext(temp1);
    		}
    	}
    	temp=head;
    	while(temp.getNext()!=null)
    	{
    		System.out.println(temp.getData());
    		temp=temp.getNext();
    	}
    }
    
    //Print Elements In Reverse Order
    public void reversePrint(LL head)
    {
    	if(head==null)
    	{
    		return;                              //RECURSIVE Reverse Print
    	}
    	else
    	{
    		reversePrint(head.getNext());
        	System.out.println(head.getData());
    	}
    }
    
    //Reverse a LinkedList Iterative
    public void reverseLLI()
    {
    	LL current=head;
    	LL prev=null;
    	while(current!=null)
    	{
    		LL next=current.getNext();           //ITERATIVE
    		current.setNext(prev);
    		prev=current;
    		current=next;
    	}
    	//display();
    	while(prev!=null)
    	{
    		System.out.println(prev.getData());
    		prev=prev.getNext();
    	}
    }
    
    //Reverse a LinkedList Recursively
    public void reverseLLR(LL curr)
    {
    	if(curr==null)
    		return;
    	if(curr.getNext()==null)
    	{
    		this.head=curr;
    		return;
    	}
    	reverseLLR(curr.getNext());
    	curr.getNext().setNext(curr);
    	curr.setNext(null);
    	//display();
    }
    
    //Check For Pallindrome
    public void pallindrome()
    {
    	int mid=length/2,flag=0;
    	LL temp=null,curr=head,prev=null,next=null;
    	while(curr!=null&&mid>0)
    	{
    		next=curr.getNext();
    		curr.setNext(prev);
    		prev=curr;
    		if(prev==head)
    			temp=prev;
    		curr=next;
    		mid--;
    	}
    	while(prev!=null&&next!=null)
    	{
    		if(prev.getData()!=next.getData())
    		{
    			flag=1;
    			break;
    		}
    		prev=prev.getNext();
    		next=next.getNext();
    		
    	}
    	if(flag==0)
    	{
    		System.out.println("Pallindrome");
    	}
    	else
    		System.out.println("Not a Pallindrome");
    }
    
    
    public void sub()
    {
    	int mid=length/2;
    	LL temp=head,temp1=head;
    	while(temp.getNext()!=null&&temp!=null)
    	{
    		temp=temp.getNext();
    	}
    	for(int i=0;i<mid;i++)
    	{
    		temp1.setData(temp1.getData()-temp.getData());
    		temp1=temp1.getNext();
    	}
    }
    
    //Merging Two Sorted LinkedLists
    public LL mergeTwoLL(LL head1,LL head2)
    {
    	LL temp1=head1,temp2=head2,prev=null,curr=null,head=null;
    	if(temp1==null&&temp2==null)
    		return null;
    	if(temp1==null&&temp2!=null)
    		return temp2;
    	if(temp1!=null&&temp2==null)
    		return temp1;
    	if(temp1.getData()<=temp2.getData())
    		head=temp1;
    	else
    		head=temp2;
    	while(temp1!=null&&temp2!=null)
    	{
    		while(temp1.getData()<=temp2.getData())
    		{
    			prev=temp1;
    			temp1=temp1.getNext();
    		}
    		prev.setNext(temp2);
    		curr=temp2.getNext();
    		temp2.setNext(temp1);
    		temp2=curr;
    	}
    	return head;
    	
    }
    //Merge Point Of Two LinkedLists
    public LL mergePoint(LL head1,LL head2)
    {
    	LL temp1=head1,temp2=head2;
    	HashSet<LL> h=new HashSet<LL>();
    	while(temp1!=null)
    	{
    		h.add(temp1);
    		temp1=temp1.getNext();
    	}
    	while(temp2!=null)
    	{
    		if(h.contains(temp2))
    		{
    			return temp2;
    		}
    		temp2=temp2.getNext();
    	}
    	return null;
    }
    public void rotateLL(int k)
    {
    	LL st=head,en=head,temp=null;
    	while(k-->0)
    	{
    		en=en.getNext();
    		if(en==null)
    			en=head;
    	}
    	while(en.getNext()!=null)
    	{
    		st=st.getNext();
    		en=en.getNext();
    	}
    	temp=st.getNext();
    	en.setNext(head);
    	st.setNext(null);
    	head=temp;
    	display();
    }
    public void addTwoLL(LL head1,LL head2)
    {
    	int carry=0,sum=0,temp=0;
    	while(head1!=null&&head2!=null)
    	{
    		temp=head1.getData()+head2.getData();
    		sum=carry+temp%10;
    		carry=temp/10;
    		head1=head1.getNext();
    		head2=head2.getNext();
    		if(head.getNext()!=null&&head2.getNext()!=null)
    		 System.out.println(sum+" "+"->"+" ");
    		else
    			System.out.println(sum);
    	}
    }
}
