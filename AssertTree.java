package reverseTree;

import org.junit.Assert;

public class AssertTree extends Assert {
	static private boolean compareTree(TreeNode tree1, TreeNode tree2)
	{
		if(tree1 == null && tree2 == null)
			return true;
		else if((tree1 == null && tree2 != null) || (tree1 != null && tree2 == null))
			return false;
		if(tree1.getData() != tree2.getData())
			return false;
		return compareTree(tree1.getLeft(), tree2.getLeft()) && compareTree(tree1.getRight(), tree2.getRight());
	}
	static public void assertTreeEquals(TreeNode tree1, TreeNode tree2)
	{
		assertTrue(compareTree(tree1,tree2));
	}
}
