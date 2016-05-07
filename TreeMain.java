package reverseTree;

public class TreeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		TreeBuilder treeBuilder = new TreeBuilder();
		TreePrinter treePrinter = new TreePrinter();
		TreeNode root = treeBuilder.buildTree(data, 0, data.length - 1, null);
		treePrinter.printTreeByLevelOrder(root);
		
		System.out.println("");
		System.out.println("===========================");
		System.out.println("");
		
		TreeManipulator treeManipulator = new TreeManipulator();
		root = treeManipulator.liftTreeByNode(root, 1);
		if(root != null)
		{
			treePrinter.printTreeByLevelOrder(root);
		}
		else
		{
			System.out.println("error");
		}
	}

}
