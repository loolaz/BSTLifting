package reverseTree;

import java.util.LinkedList;

public class TreePrinter {
	private int currentDepth, maxDepth;
	public TreePrinter()
	{
		currentDepth = maxDepth = 0;
	}
	private int getMaxDepth(TreeNode node)
	{
		if(node != null)
		{
			currentDepth++;
			if(currentDepth > maxDepth)
			{
				maxDepth = currentDepth;
			}
			getMaxDepth(node.getLeft());
			getMaxDepth(node.getRight());
			
			currentDepth--;
		}
		return maxDepth;
	}
	
	void printTreeByLevelOrder(TreeNode root)
	{
		int depth = getMaxDepth(root);
		LinkedList<TreeNodeWrapper> queue = new LinkedList<TreeNodeWrapper>();
		queue.add(new TreeNodeWrapper(root,depth));
		int previousDepth = depth;
		while(!queue.isEmpty())
		{
			TreeNodeWrapper tempNode = queue.poll();
			int tempDepth = tempNode.level;
			if(tempDepth != previousDepth)
			{
				previousDepth = tempDepth;
				System.out.println("");
			}
			int parentData = -1;
			if(tempNode.node.getParent() != null)
			{
				parentData = tempNode.node.getParent().getData();
			}
			System.out.printf("(%d/ parent : %d)",tempNode.node.getData(), parentData);
			if(tempNode.node.getLeft() != null)
			{
				queue.add(new TreeNodeWrapper(tempNode.node.getLeft(), tempDepth - 1));
			}
			if(tempNode.node.getRight() != null)
			{
				queue.add(new TreeNodeWrapper(tempNode.node.getRight(), tempDepth - 1));
			}
		}
	}
}
