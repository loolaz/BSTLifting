package reverseTree;
/**
*
* 
* 
* Test 1 : small tree
* 						    2 
* 						  /   \
* 					     1	   3
* 
* Test 2 : small tree
* 						    4 
* 						/       \
* 					   2	      6
* 					/    \      /    \
* 				   1	 3	   5	 7
* 
* 
* Test 3 : big tree
* 						    8 
* 						/       \
* 					   4	      12
* 					/    \      /    \
* 				   2	 6	   10	 14
* 				 /  \   /  \  /  \  /  \
* 				1   3  5   7  9  11 13 15
*
* <pre>
* <b>History:</b>
* </pre>
*
* @author Wooseok Choi
* @version 1.0
* @see    None
*/


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTreeManipulator {
	private TreeNode node1, node2, node3, node4, node5, node6, node7, node8, 
	node9, node10, node11, node12, node13, node14, node15;

	private TreeBuilder treeBuilder = new TreeBuilder();
	private TreeManipulator treeManipulator = new TreeManipulator();
	
	@Before
	public void setUp() throws Exception {
		node1 = new TreeNode(1);
		node2 = new TreeNode(2);
		node3 = new TreeNode(3);
		node4 = new TreeNode(4);
		node5 = new TreeNode(5);
		node6 = new TreeNode(6);
		node7 = new TreeNode(7);
		node8 = new TreeNode(8);
		node9 = new TreeNode(9);
		node10 = new TreeNode(10);
		node11 = new TreeNode(11);
		node12 = new TreeNode(12);
		node13 = new TreeNode(13);
		node14 = new TreeNode(14);
		node15 = new TreeNode(15);
	}
	
	/**
	 * Expected output
	 * 						1   
	 * 						 \   
	 * 						  2	   
	 * 					       \  
	 * 					        3 
	 */
	@Test
	public void testCaseVerySmallTreeByNode1()
	{
		int [] data = {1,2,3};
		node1.setRight(node2);	
		node2.setRight(node3);	
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);	
		root = treeManipulator.liftTreeByNode(root, 1);
		AssertTree.assertTreeEquals(root,node1);
	}
	
	/**
	 * Expected output
	 * 						   3
	 * 						  /   
	 * 						 2	   
	 * 					    /  
	 * 					   1    
	 */
	@Test
	public void testCaseVerySmallTreeByNode3()
	{
		int [] data = {1,2,3};
		node3.setLeft(node2);	
		node2.setLeft(node1);	
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);	
		root = treeManipulator.liftTreeByNode(root, 3);
		AssertTree.assertTreeEquals(root,node3);
	}
	
	/**
	 * Expected output
	 * 						 1
	 * 						   \
	 * 							2
	 * 						  /   \
	 * 						 4	   3
	 * 					      \
	 * 					  	   6
	 * 					      /  \
	 * 					     5    7
	 */
	@Test
	public void testCaseSmallTreeByNode1()
	{
		int [] data = {1,2,3,4,5,6,7};
		node1.setRight(node2);	
		node2.setLeft(node4);	
		node2.setRight(node3);
		node4.setRight(node6);	
		node6.setLeft(node5);
		node6.setRight(node7);	
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);	
		root = treeManipulator.liftTreeByNode(root, 1);
		AssertTree.assertTreeEquals(root,node1);
	}
	
	/**
	 * Expected output
	 * 						  3
	 * 						   \
	 * 							2
	 * 						  /   \
	 * 						 1	   4
	 * 					            \
	 * 					  	         6
	 * 					            /  \
	 * 					           5    7
	 */
	@Test
	public void testCaseSmallTreeByNode3()
	{
		int [] data = {1,2,3,4,5,6,7};
		node3.setRight(node2);	
		node2.setLeft(node1);	
		node2.setRight(node4);
		node4.setRight(node6);	
		node6.setLeft(node5);
		node6.setRight(node7);
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 3);
		AssertTree.assertTreeEquals(root,node3);
	}

	/**
	 * Expected output
	 * 						      5
	 * 						     /
	 * 							6
	 * 						  /   \
	 * 						 4	   7
	 * 					    /
	 * 					   2         
	 * 					  /  \
	 * 					 1    3
	 */
	@Test
	public void testCaseSmallTreeByNode5()
	{
		int [] data = {1,2,3,4,5,6,7};
		node5.setLeft(node6);	
		node6.setLeft(node4);	
		node6.setRight(node7);
		node4.setLeft(node2);	
		node2.setLeft(node1);
		node2.setRight(node3);
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 5);
		AssertTree.assertTreeEquals(root,node5);
	}
	
	/**
	 * Expected output
	 * 						      7
	 * 						     /
	 * 							6
	 * 						  /   \
	 * 						 5	   4
	 * 					          /
	 * 					         2         
	 * 					       /  \
	 * 					      1    3
	 */
	@Test
	public void testCaseSmallTreeByNode7()
	{
		int [] data = {1,2,3,4,5,6,7};
		node7.setLeft(node6);	
		node6.setLeft(node5);	
		node6.setRight(node4);
		node4.setLeft(node2);	
		node2.setLeft(node1);
		node2.setRight(node3);
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 7);
		AssertTree.assertTreeEquals(root,node7);
	}
	
	/**
	 * Expected output
	 * 						  1
	 * 						   \
	 * 							2
	 * 						  /   \
	 * 						 4		3
	 * 					   /   \
	 * 					  8	    6
	 * 					  \    /  \
	 * 					  12  5    7
	 * 					 /  \
	 * 				   10    14
	 * 				  /  \   /  \
	 * 				 9   11 13  15
	 */
	@Test
	public void testCaseBiggerTreeByNode1() {
		int [] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		node1.setRight(node2);	
		node2.setLeft(node4);	
		node2.setRight(node3);
		node4.setLeft(node8);	
		node4.setRight(node6);
		node6.setLeft(node5);	
		node6.setRight(node7);
		node8.setRight(node12);	
		node12.setLeft(node10);	
		node12.setRight(node14);	
		node10.setLeft(node9);	
		node10.setRight(node11);
		node14.setLeft(node13);	
		node14.setRight(node15);
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 1);

		AssertTree.assertTreeEquals(root,node1);
	}
	
	/**
	 * Expected output
	 * 						   7
	 * 					      /
	 * 					     6
	 * 	  				   /   \
	 * 					  5     4
	 * 					      /  \
	 * 					     2	  8
	 * 					    / \    \
	 * 					   1   3   12
	 * 					          /   \
	 * 				            10     14
	 * 				           /  \   /  \
	 * 				          9   11 13  15
	 */
	@Test
	public void testCaseBiggerTreeByNode7() {
		int [] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		node7.setLeft(node6);	
		node6.setLeft(node5);
		node6.setRight(node4);
		node4.setLeft(node2);	
		node4.setRight(node8);
		node2.setLeft(node1);	
		node2.setRight(node3);
		node8.setRight(node12);	
		node12.setLeft(node10);	
		node12.setRight(node14);	
		node10.setLeft(node9);	
		node10.setRight(node11);
		node14.setLeft(node13);	
		node14.setRight(node15);
		
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 7);

		AssertTree.assertTreeEquals(root,node7);
	}
	
	@Test
	public void testCaseInvalidInput() {
		int [] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 71);

		assertNull(root);
	}
	
	@Test
	public void testCaseNotTerminal() {
		int [] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		root = treeManipulator.liftTreeByNode(root, 6);

		assertNull(root);
	}
}
