package reverseTree;

public class TreeNode {
	private int data;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	
	public TreeNode()
	{
		this.left = this.right = null;
	}
	
	public TreeNode(int data)
	{
		this.left = this.right = null;
		this.data = data;
	}
	
	public void setParent(TreeNode parent)
	{
		this.parent = parent;
	}
	
	public TreeNode getParent()
	{
		return parent;
	}
	
	public void setLeft(TreeNode left)
	{
		this.left = left;
		
	}
	
	public void setRight(TreeNode right)
	{
		this.right = right;
	}
	
	public TreeNode getLeft()
	{
		return left;
		
	}
	public TreeNode getRight()
	{
		return right;
	}
	
	public int getData()
	{
		return data;
	}
	
	public void setData(int data)
	{
		this.data= data;
	}

}
