package datastructuresandalgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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
			
			System.out.println("1.Insert  2.Preorder  3.Inorder  "
					+ "4.Postorder\n5.Level Order  6.Sum Of Child  7.Distance Between nodes\n"
					+ "8.Search Element(Recursive)  9.size of tree\n"
					+ "10.Maximum Element(Recursive)  11.Maximum(Iterative)\n"
					+ "12.Search Element(Iterative)  13.PreOrder(Iterative)\n"
					+ "14.Sum Of All Node  15.Minimum Depth  16.Deepest Node\n"
					+ "17.Size of BT(Iteratively)  18.Max Depth  19.delete tree\n"
					+ "20.Mirror Tree  21.Exit");
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
			      break;
			case 10:
				int max=b.maxInBTr(root);
				 System.out.println(max);
				 break;
			case 11:
				int max1=b.maxInBTi(root);
				 System.out.println(max1);
				break;
			case 12:
				if(b.searchElement(root,s.nextInt()))
					System.out.println("Element Exits in the tree");
				else
					System.out.println("Element does not Exits in the tree");
				break;
			case 13:
				b.preorderI(root);
				break;
			case 14:
				int sum=b.sumOfNodes(root);
				System.out.println(sum);
				break;
			case 15:
				int minDepth=b.minDepth(root);
				System.out.println(minDepth);
				break;
			case 16:
				BinaryTreeNode node=b.deepestNode(root);
				System.out.println(node.getData());
				break;
			case 17:
				int size=b.sizeOfTreeI(root);
				System.out.println(size);
				break;
			case 18:
				int maxDepth=b.maxDepth(root);
				System.out.println(maxDepth);
				break;
			case 19:
				b.deleteTree(root);
				break;
			case 20:
				BinaryTreeNode mirrorTree=b.mirrorTree(root);
				b.levelOrder(mirrorTree);
				break;
			}
		}while(x!=21);
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
	
	//PreOrder of a BT Recursive
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
	
	//PreOrder of a BT Iterative
	public void preorderI(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> s=new Stack<BinaryTreeNode>();
		s.push(root);
		while(!s.isEmpty())
		{
			BinaryTreeNode temp=s.pop();
			System.out.println(temp.getData());
			if(temp.getRight()!=null)
				s.push(temp.getRight());
			if(temp.getLeft()!=null)
				s.push(temp.getLeft());
		}
	}
	
	//Recursive Inorder
	public void inOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			inOrder(root.getLeft());
			System.out.println(root.getData());
			inOrder(root.getRight());
		}
		
	}
	
	//Recursive PostOrder
	public void postOrder(BinaryTreeNode root)
	{
		if(root!=null)
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());
		}
		
	}
	
	//LevelOrder Traversal
	public void levelOrder(BinaryTreeNode root)
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
	
	//Sum of Children of all root
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
	
	//Distance between the nodes
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
	
	//Finding Element Recursively
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
	
	//Finding Element Iteratively
	public boolean searchElement(BinaryTreeNode root,int ele)
	{
		if(root==null)
			return false;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			if(temp.getData()==ele)
				return true;
			if(temp.getLeft()!=null)
				q.offer(temp.getLeft());
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
		}
		return false;
	}
	
	//Deleting a node from BinaryTree
	public BinaryTreeNode DeleteANode(BinaryTreeNode root,int data)
	{
		if(root==null)
		{
			return null;
		}
		return null;
	}
	
	//Finding the size of a binary tree recursively
	public int sizeOfTree(BinaryTreeNode root)
	{
		int left=root.getLeft()==null?0:sizeOfTree(root.getLeft());
		int right=root.getRight()==null?0:sizeOfTree(root.getRight());
		return 1+left+right;
	}
	
	//Size of Binary Tree Iteratively
	public int sizeOfTreeI(BinaryTreeNode root)
	{
		int size=0;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			if(temp!=null)
				size++;
			if(temp.getLeft()!=null)
			{
				q.offer(temp.getLeft());
			}
			if(temp.getRight()!=null)
			{
				q.offer(temp.getRight());
			}
		}
		return size;
	}
	
	//Maximum Element in a binary tree Recursive
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
	
	//Maximum Element in a binary tree Iterative
	public int maxInBTi(BinaryTreeNode root)
	{
		int max=0;
		if(root==null)
			return max;
		else
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
	
	//Mirror Tree
	public BinaryTreeNode mirrorTree(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll(),temp1=null;
			if(temp!=null)
			{
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
				temp1=temp.getLeft();
				temp.setLeft(temp.getRight());
				temp.setRight(temp1);
			}
		}
		return root;
	}
	
	//sum of all nodes
	public int sumOfNodes(BinaryTreeNode root)
	{
		int sum=0;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			sum=sum+temp.getData();
			if(temp.getLeft()!=null)
				q.offer(temp.getLeft());
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
		}
		return sum;
	}
	
	//Minimum Depth in a Tree
	public int minDepth(BinaryTreeNode root)
	{
		if(root==null)
			return 0;
		int count=1;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			if(temp!=null)
			{
				if(temp.getLeft()==null&&temp.getRight()==null)
				{
					return count;
				}
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
			}
			else
			{
				if(!q.isEmpty())
				{
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}
	
	//Maximum Depth
	public int maxDepth(BinaryTreeNode root)
	{
		if(root==null)
			return 0;
		int count=1;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp=q.poll();
			if(temp!=null)
			{
				if(temp.getLeft()!=null)
					q.offer(temp.getLeft());
				if(temp.getRight()!=null)
					q.offer(temp.getRight());
			}
			else
			{
				if(!q.isEmpty())
				{
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}
	
	//Finding the deepest node in a BinaryTree
	public BinaryTreeNode deepestNode(BinaryTreeNode root)
	{
		if(root==null)
			return root;
		BinaryTreeNode temp=null;
		Queue<BinaryTreeNode> q=new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			temp=q.poll();
			if(temp.getLeft()!=null)
				q.offer(temp.getLeft());
			if(temp.getRight()!=null)
				q.offer(temp.getRight());
		}
		return temp;
	}
	
	//Checking if two trees are similar Iterative(Method Only)
	public boolean checkSimilar(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1==null&&root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		Queue<BinaryTreeNode> q1=new LinkedList<BinaryTreeNode>();
		Queue<BinaryTreeNode> q2=new LinkedList<BinaryTreeNode>();
		q1.offer(root1);
		q2.offer(root2);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			BinaryTreeNode temp1=q1.poll();
			BinaryTreeNode temp2=q1.poll();
			if(temp1.getData()!=temp2.getData())
				return false;
			if(temp1.getLeft()!=null)
				q1.offer(temp1.getLeft());
			if(temp1.getRight()!=null)
				q1.offer(temp1.getRight());
			if(temp2.getLeft()!=null)
				q2.offer(temp1.getLeft());
			if(temp2.getRight()!=null)
				q2.offer(temp1.getRight());
		}
		return true;
	}
	
	//Delete a tree using postorder traversal
	public void deleteTree(BinaryTreeNode root)
	{
		if(root==null)
			return;
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root.setLeft(null);
		root.setRight(null);
		//root.setData(0);
		root=null;
	}
	
}
