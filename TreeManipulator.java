package reverseTree;
/**
 * Lifting up terminal node and drop down the whole tree 
 * assumption 1 : Tree is Balanced Binary Search Tree
 * assumption 2 : Each node knows its parent
 * assumption 3 : Each node has only positive integer value
 * 
 * When lifting up terminal node, if the depth of a terminal node is less than rest of them, we define as the tree has been dropped down
 * 
 * <pre>
 * <b>History:</b>
 * </pre>
 *
 * @author Wooseok Choi
 * @version 1.0
 * @see    None
 */


public class TreeManipulator {
	
	/**
	 * Finding node with key
	 *
	 * @param root - TreeNode 의 root
	 * @param key  
	 * @return node containing key
	 */
	private TreeNode findNode(TreeNode root, int key)
	{
		while(root != null)
		{
			if(root.getData() == key)
			{
				return root;
			}
			else if(root.getData() > key)
			{
				root = root.getLeft();
			}
			else
			{
				root = root.getRight();
			}
		}
		return null;
	}
	
	/**
	 * Check if node is left child of its parent
	 *
	 * @param node - node to be checked  
	 * @return if it is, true
	 */
	private boolean isLeftChild(TreeNode node)
	{
		if(node.getParent().getLeft() == node)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Check if node is terminal node
	 *
	 * @param node - node to be checked   
	 * @return if it is, true
	 */
	private boolean isValidTerminalNode(TreeNode node)
	{
		if(node == null)
		{
			return false;
		}
		else if(node.getLeft() != null || node.getRight() != null)
		{
			return false;
		}
		return true;
	}
	
	/**
	 * move node to the nearest grand child
	 *
	 * @param leftChild - boolean if current node is left child of its parent
	 * @param current - current node
	 * @param newChildNode - node to be a child of current node
	 */
	private void moveNodeToClosestPosition(boolean leftChild, TreeNode current, TreeNode newChildNode)
	{
		if(leftChild)
		{
			if(current.getRight() == null)
			{
				current.setRight(newChildNode);
			}
			else
			{
				current.setLeft(newChildNode);
			}
			newChildNode.setLeft(null);
		}
		else
		{
			if(current.getLeft() == null)
			{
				current.setLeft(newChildNode);
			}
			else
			{
				current.setRight(newChildNode);
			}
			newChildNode.setRight(null);
		}
	}
	
	/**
	 * move every node whose depth is equal or smaller than the lifted node's depth to appropriate position
	 * 
	 * @param node - node to be started moving
	 */
	private void makeChildRecursive(TreeNode node)
	{
		if(node.getParent() == null)
		{
			return;
		}	
		boolean leftChild = isLeftChild(node);
		TreeNode newChildNode = node.getParent();
		TreeNode current = node;
		moveNodeToClosestPosition(leftChild, current, newChildNode);
		makeChildRecursive(node.getParent());
		newChildNode.setParent(current);
	}
	
	/**
	 * lifting up tree with key 
	 *
	 * @param root - root node to be lifted
	 * @param key - 
	 * @return root node which is transformed
	 */
	public TreeNode liftTreeByNode(TreeNode root, int key)
	{
		TreeNode terminalNode = findNode(root, key);
		if(!isValidTerminalNode(terminalNode))
		{
			return null;
		}
		TreeNode newChildNode = terminalNode.getParent();
		
		boolean isTerminalNodeLeft = isLeftChild(terminalNode);
		boolean isNewChildNodeLeft = isTerminalNodeLeft;
		if(newChildNode.getParent() != null)
			isNewChildNodeLeft = isLeftChild(newChildNode);
		
		if(isNewChildNodeLeft)
		{
			terminalNode.setRight(newChildNode);
		}
		else
		{
			terminalNode.setLeft(newChildNode);
		}
		
		if(isTerminalNodeLeft)
		{
			newChildNode.setLeft(null);
		}
		else
		{
			newChildNode.setRight(null);
		}
		
		makeChildRecursive(newChildNode);
		
		if(isNewChildNodeLeft)
		{
			terminalNode.getRight().setParent(terminalNode);
		}
		else
		{
			terminalNode.getLeft().setParent(terminalNode);
		}
		terminalNode.setParent(null);
		return terminalNode;
		
	}
}
