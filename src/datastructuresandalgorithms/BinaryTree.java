package datastructuresandalgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree
{

	public static void main(String[] args) 
	{
		Scanner s=new Scanner(System.in);
		BinaryTreeNode root=null;
		BS b=new BS();
		int x;
		do
		{
			
			System.out.println("1.insert  2.preorder  3.inorder  "
					+ "4.postorder\n5.Level Order  6.sum of child  7.Distance Between nodes\n"
					+ "8.Find Element  9.size of tree  10.Maximum Element(Recursive)  11.Maximum(Iterative)\n"
					+ "12.Exit");
			x=s.nextInt();
			switch(x)
			{
			case 1:
				   System.out.println("Enter element");
				   if(root==null)
					   root=b.insert(root,s.nextInt());
				   else
				       b.insert(root, s.nextInt());				   
				   break;
			case 2:
				   b.preOrder(root);
				   break;
			case 3:
				   b.inOrder(root);
				   break;
			case 4:
				   b.postOrder(root);
				   break;
			case 5:
				b.levelOrder(root);
			break;
			case 6:
				   b.sumOfChildren(root);
				   break;
			case 7:
				   b.distanceBetweenNodes(root);
				break;
			case 8:
				   int ele=s.nextInt();
				   if(b.FindElement(root,ele))
				     System.out.println("Element "+ele+" is Found in the Tree");
				   else
					 System.out.println("Element "+ele+" is Not Found in the Tree");
				break;
			case 9:
			      int count=b.sizeOfTree(root);
			      System.out.println(count);
			case 10:
				int max=b.maxInBTr(root);
				 System.out.println(max);
				 break;
			case 11:
				int max1=b.maxInBTi(root);
				 System.out.println(max1);
				break;
			}
		}while(x!=12);
	}

}
class BinaryTreeNode
{
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	public BinaryTreeNode(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
	public void setData(int data)
	{
		this.data=data;
	}
	public int getData()
	{
		return data;
	}
	public void setLeft(BinaryTreeNode left)
	{
		this.left=left;
	}
	public BinaryTreeNode getLeft()
	{
		return left;
	}
	public void setRight(BinaryTreeNode right)
	{
		this.right=right;
	}
	public BinaryTreeNode getRight()
	{
		return right;
	}	
}

class BS
{
	BinaryTreeNode root=null;
	public BinaryTreeNode insert(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			root=new BinaryTreeNode(data);
			return root;
		}
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode tmp=q.poll();
			if(tmp!=null)
			{
				if(tmp.getLeft()!=null)
					q.offer(tmp.getLeft());
				else
				{
					tmp.left=new BinaryTreeNode(data);
					return root;
				}
			    if(tmp.right!=null)
				q.offer(tmp.right);
		        else
			    {
				 tmp.right=new BinaryTreeNode(data);
				 return root;
			    }
		     }
	     }
		return root;
     }
	
	public void preOrder(BinaryTreeNode root)
	{
		if(root==null)
			return;
		else
		{
			System.out.println(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
		
	}
	
	public void inOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			inOrder(root.getLeft());
			System.out.println(root.getData());
			inOrder(root.getRight());
		}
		
	}
	
	public void postOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());
		}
		
	}
	
	public static void levelOrder(BinaryTreeNode root)
	{
		if(root==null)
			System.out.println("No Elements in Tree");
		else
		{
			Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty())
			{
				BinaryTreeNode temp=q.poll();
				System.out.println(temp.getData());
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
			}
		}
	}
	
	public void sumOfChildren(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp1=null,temp2=null;
			BinaryTreeNode temp=q.peek();
			if(temp.getLeft()!=null)
			{
				temp1=temp.getLeft();
				temp.setData(temp1.getData());
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null)
			{
				temp2=temp.getRight();
				temp.setData(temp.getData()+temp2.getData());
				System.out.println(temp.getData());
				q.offer(temp.getRight());
			}
			q.poll();
			
		}
	}
	
	public void distanceBetweenNodes(BinaryTreeNode root)
	{
		int count=0;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			if(temp.getLeft()==null&&temp.getRight()==null)
			{
				count++;
			}
			if(temp.getLeft()!=null)
			{
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null)
			{
				q.offer(temp.getRight());
			}
		}
		System.out.println(count);
	}
	
	public BinaryTreeNode DeepestNode(BinaryTreeNode root)
	{
		BinaryTreeNode temp=null;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			temp=q.poll();
			if(temp.getLeft()!=null)
			{
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null)
			{
				q.offer(temp.getRight());
			}
		}
		return temp;
	}
	
	public boolean FindElement(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			return false;
		}
		if(root.getData()==data)
		{
			return true;
		}
		return FindElement(root.getLeft(),data)||FindElement(root.getRight(),data);
	}
	
	public BinaryTreeNode DeleteANode(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			return null;
		}
		return null;
	}
	public int sizeOfTree(BinaryTreeNode root)
	{
		int left=root.getLeft()==null?0:sizeOfTree(root.getLeft());
		int right=root.getRight()==null?0:sizeOfTree(root.getRight());
		return 1+left+right;
	}
	public int maxInBTr(BinaryTreeNode root)
	{
		int max=0;
		if(root!=null)
		{
			int left=maxInBTr(root.getLeft());
			int right=maxInBTr(root.getRight());
			if(left>right)
				max=left;
			else
				max=right;
			if(root.getData()>max)
				max=root.getData();
        }
		return max;
	}
	public int maxInBTi(BinaryTreeNode root)
	{
		int max=0;
		if(root!=null)
		{
			Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
			q.offer(root);
			while(!q.isEmpty())
			{
				BinaryTreeNode temp=q.poll();
				if(temp.getData()>max)
					max=temp.getData();
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
			}
		}
		
		return max;
	}
}
