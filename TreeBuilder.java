package reverseTree;

public class TreeBuilder {
	TreeNode buildTree(int [] data, int start, int end, TreeNode parent)
	{
		if(start > end)
		{
			return null;
		}
		int mid = (start + end) / 2;
		
		TreeNode root = new TreeNode(data[mid]);
		root.setParent(parent);
		
		root.setLeft(buildTree(data,start,mid-1,root));
		root.setRight(buildTree(data,mid+1,end,root));
		return root;
	}
}
