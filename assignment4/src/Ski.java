/**
 * This class simulates a skier navigating the mountains defined by a linked tree
 * @author ihwang9 | 251217976
 */

public class Ski {
	
	/**
	 * Reference to the root of the linked tree describing the mountain
	 */
	private BinaryTreeNode<SkiSegment> root;
	
	/**
	 * Constructor used the TreeBuilder class to create a linked tree "mountain" and input the data from a String array
	 * @param data String array containing data to be inputted as data items for each linked tree node
	 */
	public Ski(String[] data) {
		// Creates an array of ski segments based on the received String data array
		SkiSegment[] segments = new SkiSegment[data.length];
		for (int i = 0; i < data.length ; i++) {
			if (data[i] == null) {
				segments[i] = null;
			} else if (data[i].contains("jump")) {
				segments[i] = new JumpSegment(String.valueOf(i),data[i]);
			} else if (data[i].contains("slalom")) {
				segments[i] = new SlalomSegment(String.valueOf(i),data[i]);
			} else {
				segments[i] = new SkiSegment(String.valueOf(i),data[i]);
			}			
		}
		
		// Creates a TreeBuilder object and builds a linked tree
		TreeBuilder<SkiSegment> mountain = new TreeBuilder<SkiSegment>();
		LinkedBinaryTree<SkiSegment> linkedTree = mountain.buildTree(segments);
				
		root = linkedTree.getRoot();
	}
	
	/**
	 * Accessor method to get the root of the linked tree "mountain"
	 * @return root of linked tree
	 */
	public BinaryTreeNode<SkiSegment> getRoot(){
		return root;
	}
	
	/**
	 * Determines the next best path the skier should take based on a set of criteria
	 * @param node root node of the linked tree describing the mountain (ie. starting point for the skier)
	 * @param sequence An unordered list which keeps track of the path that the skier takes
	 */
	public void skiNextSegment(BinaryTreeNode<SkiSegment> node, ArrayUnorderedList<SkiSegment> sequence) {
		sequence.addToRear(node.getData());
		
		// Recursion base case
		if (node.getLeft() == null && node.getRight() == null) {
			return;
		}
		
		BinaryTreeNode<SkiSegment> nextNode;
		
		// Determine the next segment based on the criteria
		if (node.getLeft() == null || node.getRight() == null) {
			if (node.getLeft() == null) {
				nextNode = node.getRight();
			} else {
				nextNode = node.getLeft();
			}
		} else if (node.getLeft().getData() instanceof JumpSegment || node.getRight().getData() instanceof JumpSegment) {
			nextNode = checkJump(node);
		} else if (node.getLeft().getData() instanceof SlalomSegment || node.getRight().getData() instanceof SlalomSegment) {
			nextNode = checkSlalom(node);
		} else {
			nextNode = node.getRight();
		}
		
		// Recursive call to find the next best path
		skiNextSegment(nextNode, sequence);
	}
	
	/**
	 * Helper method to check what the next best path should be if one or more of the child paths are of the class JumpSegment
	 * @param node Current node of the skier
	 * @return returns the next best node to go to
	 */
	private BinaryTreeNode<SkiSegment> checkJump(BinaryTreeNode<SkiSegment> node){
		BinaryTreeNode<SkiSegment> leftNode = node.getLeft();
		BinaryTreeNode<SkiSegment> rightNode = node.getRight();
		
		if (leftNode.getData() instanceof JumpSegment && rightNode.getData() instanceof JumpSegment) {
			if (((JumpSegment) leftNode.getData()).getHeight() == ((JumpSegment) rightNode.getData()).getHeight()) {
				return rightNode;
			} else if (((JumpSegment) leftNode.getData()).getHeight() < ((JumpSegment) rightNode.getData()).getHeight()) {
				return rightNode;
			} else {
				return leftNode;
			}
		} else if (leftNode.getData() instanceof JumpSegment) {
			return leftNode;
		} else {
			return rightNode;
		}	
	}
	
	/**
	 * Helper method to check what the next best path should be if one or more of the child paths are of the class SlalomSegment 
	 * @param node Current node of the skier
	 * @return returns the next best node to go to
	 */
	private BinaryTreeNode<SkiSegment> checkSlalom(BinaryTreeNode<SkiSegment> node){
		BinaryTreeNode<SkiSegment> leftNode = node.getLeft();
		BinaryTreeNode<SkiSegment> rightNode = node.getRight();
		
		if (leftNode.getData() instanceof SlalomSegment && rightNode.getData() instanceof SlalomSegment) {
			if (((SlalomSegment) leftNode.getData()).getDirection().equals("L")) {
				return leftNode;
			} else {
				return rightNode;
			}
		} else if (leftNode.getData() instanceof SlalomSegment) {
			if (((SlalomSegment) leftNode.getData()).getDirection().equals("L")) {
				return leftNode;
			} else {
				return rightNode;
			}
		} else if (rightNode.getData() instanceof SlalomSegment) {
			if (((SlalomSegment) rightNode.getData()).getDirection().equals("L")) {
				return rightNode;
			} else {
				return leftNode;
			}
		} else {
			return leftNode;
		}
	}

}
