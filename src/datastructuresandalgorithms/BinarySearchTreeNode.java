package datastructuresandalgorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinarySearchTreeNode
{

	public static void main(String[] args)
	{
		BinarySearchTree root=null,min,max,ele;
	//	BinarySearchTree b2=new BinarySearchTree();
		BST b1=new BST();
		Scanner s=new Scanner(System.in);
        int x;
        do
        {
        	System.out.println("1.Insert,2.FindMinimum,3.FindMaximum,4.Preorder,"
        			+ "5.inorder,6.postorder,7.check BST,8.LCA,9.Levelorder,"
        			+ "\n10.Find,11.kth small,12.Make root as sum of its children,"
        			+ "13.distance,14.Mirror,15.Number Of Nodes,15.Exit");
        	x=s.nextInt();
        	
        	switch(x)
            {
            case 1:
            	System.out.println("Enter elements");
            	if(root==null)
        		{
        			root=b1.insert(root, s.nextInt());
        		}
        		else
        	     b1.insert(root,s.nextInt());
            	break;
            	
            case 2:
            	min=b1.FindMin(root);
            	System.out.println(min.getData());
            	break;
            	
            case 3:
            	max=b1.FindMax(root);
            	System.out.println(max.getData());
            	break;
            	
            case 4:
            	b1.preorder(root);
            	break;
            	
            case 5:
            	b1.inorder(root);
            	break;
            	
            case 6:
            	b1.postorder(root);
            	break;
            	
            case 7:
            	if(b1.Bst(root))
            	{
            		System.out.println("Given BT is BST");
            	}
            	else
            	{
            		System.out.println("Given BT is not BST");
            	}
            	break;
            case 8:
            	int a=s.nextInt();
            	int b=s.nextInt();
            	BinarySearchTree ans=b1.lca(root, a, b);
            	System.out.println(ans.getData());
            	break;
            case 9:
            	b1.levelOrderTraversal(root);
            	break;
            case 10:
            	ele=b1.Find(root,s.nextInt());
            	if(ele!=null)
            		System.out.println("Found");
            	else
            		System.out.println("Not Found");
            	break;
            case 11:
            	int count=0;
            	b1.kSmall(root,s.nextInt(),count);
           // 	System.out.println(kth.getData());
            	break;
            case 12:
            	b1.sumOfChildren(root);
            	break;
            case 13:
            	b1.distanceBetweenNodes(root);
            	break;
            case 14:
            	b1.mirrorImage(root);
            	break;
            case 15:
            	int n=b1.numberOfNodes(root);
            	System.out.println(n);
            	break;
         }
        	
        }while(x!=16);	
	s.close();
	}
}

class BinarySearchTree 
{
	
	private int data;
	private BinarySearchTree left;
	private BinarySearchTree right;
	
	public int getData()
	{
		return data; 
	}
	
	public void setData(int data)
	{
		this.data=data;
	}
	
	public BinarySearchTree getLeft()
	{
		return this.left;
	}
	
	public void setLeft(BinarySearchTree left)
	{
		this.left=left;
	}
	
	public BinarySearchTree getRight()
	{
		return this.right;
	}
	
	public void setRight(BinarySearchTree right)
	{
		this.right=right;
	}
	
}
class BST
{
	
	public BinarySearchTree insert(BinarySearchTree root,int data)
	{
		if(root==null)
		{
			root=new BinarySearchTree();
			root.setData(data);
		    root.setLeft(null);
		    root.setRight(null);
		}
		else
		{
			if(data<root.getData())
			{
				root.setLeft(insert(root.getLeft(),data));
			}
			if(data>root.getData())
			{
				root.setRight(insert(root.getRight(),data));
			}
		}
		return root;
	}
	
	public void preorder(BinarySearchTree root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			System.out.println(root.getData());
			preorder(root.getLeft());
			preorder(root.getRight());
		}
	}
	public void inorder(BinarySearchTree root)
	{
		
		if(root==null)
			return;
		else
		{
			inorder(root.getLeft());
			System.out.println(root.getData());
			inorder(root.getRight());
		}
	}
	public void postorder(BinarySearchTree root)
	{
		if(root==null)
			return;
		else
		{
			postorder(root.getLeft());
			postorder(root.getRight());
			System.out.println(root.getData());
		}
	}
	
	public BinarySearchTree Find(BinarySearchTree root,int data)
	{
		if(root==null)
			return root;
		if(data<root.getData())
		{
			return Find(root.getLeft(),data);
		}
		if(data>root.getData())
		{
			return Find(root.getRight(),data);
		}
		
		return root;
	}
	
	public BinarySearchTree FindMin(BinarySearchTree root)
	{
		if(root==null)
			return root;
		if(root.getLeft()==null)
			return root;
		else
			return FindMin(root.getLeft());

	}
	
	public BinarySearchTree FindMax(BinarySearchTree root)
	{
		if(root==null)
			return null;
		if(root.getRight()==null)
			return root;
		else
			return FindMax(root.getRight());
	}
	public boolean isBst(BinarySearchTree root)
	{
		if(root==null)
		{
			return true;
		}
		if(root.getLeft()!=null && root.getLeft().getData() > root.getData())
		{
			return false;
		}
		if(root.getLeft()!=null && root.getRight().getData() < root.getData())
		{
			return false;
		}
		return true;  
	}
	public BinarySearchTree lca(BinarySearchTree root,int a,int b)
	{
		if(root==null)
			return null;
		if(root.getData()>a&&root.getData()>b)
			return lca(root.getLeft(),a,b);
		if(root.getData()<a&&root.getData()<b)
			return lca(root.getRight(),a,b);
		return root;
		
	}
	
	
	public void levelOrderTraversal(BinarySearchTree root)
	{
		Queue<BinarySearchTree> q=new LinkedList<BinarySearchTree>();
		if(root==null)
		{
			return;
		}
		q.offer(root);
		while(!q.isEmpty())
		{
			BinarySearchTree curr=q.poll();
			System.out.println(curr.getData());
			if(curr.getLeft()!=null) q.offer(curr.getLeft());
			if(curr.getRight()!=null) q.offer(curr.getRight());
		}
	}
	public boolean Bst(BinarySearchTree root)
	{
		if(root==null)
		  return true;
		BinarySearchTree a=FindMax(root.getLeft());
		if(root.getLeft()!=null&&a.getData()>root.getData())
			return false;
		BinarySearchTree b=FindMin(root.getRight());
		if(root.getRight()!=null&&b.getData()<root.getData())
			return false;
		return true;
	}
	public void kSmall(BinarySearchTree root,int k,int count)
	{
		if(root==null)
			return;
		kSmall(root.getLeft(),k,count);
		count++;
		if(count==k)
		{
			System.out.println("Kth smallest element is: "+root.getData());
	        return;
		}
		kSmall(root.getRight(),k,count);
	}
	void kSmallest(BinarySearchTree root, int n, int K)
	{
	    if(root==null) return;
	    kSmallest(root.getLeft(), n, K);
	    n++;
	    if(K==n)
	    {
	        System.out.println("smallest element is: "+root.getData());
	        return;
	    }
	    kSmallest(root.getRight(), n, K);
	}
	public void sumOfChildren(BinarySearchTree root)
	{
		int sum=0;
		Queue<BinarySearchTree> q=new LinkedList<BinarySearchTree>();
		q.offer(root);
		while(!q.isEmpty())
		{
			sum=0;
			BinarySearchTree temp1=null,temp2=null;
			BinarySearchTree temp=q.peek();
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
	public void distanceBetweenNodes(BinarySearchTree root)
	{
		int count=0;
		Queue<BinarySearchTree> q=new LinkedList<BinarySearchTree>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinarySearchTree temp=q.poll();
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
	public void mirrorImage(BinarySearchTree root)
	{
		levelOrderTraversal(root);
		Queue<BinarySearchTree> q=new LinkedList<BinarySearchTree>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinarySearchTree temp=q.poll();
			BinarySearchTree temp1,temp2,temp3;
			temp1=temp.getLeft();
			temp2=temp.getRight();
			if(temp.getLeft()!=null)
			{
				q.offer(temp.getLeft());
				temp.setLeft(temp2);
				temp.setRight(temp1);
			}
			if(temp.getRight()!=null)
			{
				q.offer(temp.getRight());
				temp.setLeft(temp2);
				temp.setRight(temp1);
			}
		}
		System.out.println("Mirror");
		levelOrderTraversal(root);
	}
	public int numberOfNodes(BinarySearchTree root)
	{
		if(root==null)
		{
			return 0;
		}
		int left=numberOfNodes(root.getLeft());
		int right=numberOfNodes(root.getRight());
		return 1+left+right;
	}
}