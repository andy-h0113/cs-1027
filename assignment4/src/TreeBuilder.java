/**
 * This class creates a linked binary tree
 * @author ihwang9 | 251217976
 */

public class TreeBuilder<T> {
	
	/**
	 * Creates a tree based on an array of data using a level order approach
	 * @param data array with data to be inserted into the tree
	 * @return returns the final linked binary tree
	 */
	public LinkedBinaryTree<T> buildTree(T[] data){
		
		// Creates two queues, one to hold data and one to add nodes of the tree to
		LinkedQueue<T> dataQueue = new LinkedQueue<T>();
		LinkedQueue<BinaryTreeNode<T>> parentQueue = new LinkedQueue<BinaryTreeNode<T>>();
		
		// Adds data from parameter to dataQueue
		for (int i = 0; i < data.length; i++) {
			dataQueue.enqueue(data[i]);
		}
		
		// Initialize root of the treee and the tree
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(dataQueue.dequeue());
		LinkedBinaryTree<T> tree = new LinkedBinaryTree<T>(root);
		parentQueue.enqueue(root);
		
		// Adds data into binary tree nodes and creates the tree
		while(!dataQueue.isEmpty()) {
			BinaryTreeNode<T> a = new BinaryTreeNode<T>(dataQueue.dequeue());
			BinaryTreeNode<T> b = new BinaryTreeNode<T>(dataQueue.dequeue());
			BinaryTreeNode<T> parent = parentQueue.dequeue();
			if (a.getData() != null) {
				parent.setLeft(a);
				parentQueue.enqueue(a);
			}
			if (b.getData() != null) {
				parent.setRight(b);
				parentQueue.enqueue(b);
			}
		}
		return tree;

	}
}
