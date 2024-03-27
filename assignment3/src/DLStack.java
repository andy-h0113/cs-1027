/**
 * Class implements the DLStackADT a doubly linked list implementation of the StackADT
 * @author 251217976 | ihwang9
 * @param <T> generic data type
 */
public class DLStack<T> implements DLStackADT<T>{
	
	/**
	 * Reference to top of the stack
	 */
	private DoubleLinkedNode<T> top;
	
	/**
	 * Counter for the number of items in the stack
	 */
	private int numItems;
	
	/**
	 * Constructor that initializes the top and numItems variables
	 */
	public DLStack() {
		top = null;
		numItems = 0;
	}
	
	/**
	 * Method adds a data item to the stack
	 */
	public void push(T dataItem) {
		DoubleLinkedNode<T> newNode = new DoubleLinkedNode<T>(dataItem);
		if (top != null) {
			newNode.setPrevious(top);
			top.setNext(newNode);
		}
		top = newNode;
		numItems++;
	}
	
	/**
	 * Method removes the data item at the top of the stack
	 * @return data item at the top of the stack
	 */
	public T pop() throws EmptyStackException{
		if(numItems == 0) {
			throw new EmptyStackException("");
		}
		T result = top.getElement();
		if (numItems > 1) {
			top = top.getPrevious();
		}
		top.setNext(null);
		numItems--;
		return result;
	}
	
	/**
	 * Method removes the data item at the given position in the stack
	 * @return data item that was removed
	 */
	public T pop(int k) throws InvalidItemException{
		if (k > numItems || k <= 0) {
			throw new InvalidItemException("Invalid Item Number");
		}
		
		int count = 1;
		DoubleLinkedNode<T> current = top;
		
		while(count != k) {
			current = current.getPrevious();
			count++;
		}
		
		T result = current.getElement();
		if (current.getPrevious() != null) {
			current.getPrevious().setNext(current.getNext());
		}
		if (current.getNext() != null) {	
			current.getNext().setPrevious(current.getPrevious());
		}
		if (current.getNext() == null) {
			top = current.getPrevious();
		}
		numItems--;
		return result;
	}
	
	/**
	 * Method shows what the element being stored at the top of the stack
	 * @return element contained in the node at the top of the stack
	 */
	public T peek() throws EmptyStackException{
		if (numItems == 0) {
			throw new EmptyStackException("Empty Stack");
		}
		T result = top.getElement();
		return result;
	}
	
	/**
	 * Method checks if the stack is empty
	 * @return true if the stack is empty and false if the stack is not empty
	 */
	public boolean isEmpty() {
		return (numItems == 0);
	}
	
	/**
	 * Method returns the number of data items in the stack
	 * @return number of items in the stack
	 */
	public int size() {
		return numItems;
	}
	
	/**
	 * Accessor method returns the top node of the stack
	 * @return top of stack
	 */
	public DoubleLinkedNode<T> getTop(){
		return top;
	}
	
	/**
	 * Method provides a String representation of the stack
	 * @return String representation of the stack
	 */
	public String toString() {
		String stringRep = "[";
		DoubleLinkedNode<T> current = top;
		
		for (int i = 0; i < numItems; i++) {
			stringRep += current.getElement();
			current = current.getPrevious();
			if (i != (numItems - 1)) {
				stringRep += " ";
			}
		}
		stringRep += "]";
		return stringRep;
	}
}
