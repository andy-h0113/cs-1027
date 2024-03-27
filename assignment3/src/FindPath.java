/**
 * This class finds the path you can take to collect all the treasures safely
 * @author ihwang9 | 251217976
 */
public class FindPath {
	
	/**
	 * Reference to map of pyramid
	 */
	private Map pyramidMap;
	
	/**
	 * Constructor initializes pyramidMap value
	 * @param fileName
	 */
	public FindPath(String fileName) {
		try {
			pyramidMap = new Map(fileName);
		} catch (Exception e) {
			System.out.println("File Error");
		}
	}
	
	/**
	 * Method finds the path to take to reach all the treasures safely
	 * @return stack containing the path to take and empty stack if there is no path
	 */
	public DLStack<Chamber> path() {
		DLStack<Chamber> pathStack = new DLStack<Chamber>();
		int numTreasures = pyramidMap.getNumTreasures();
		int numFound = 0;
		
		// Pushes entrance of Map to the stack and marks it
		pathStack.push(pyramidMap.getEntrance());
		pathStack.peek().markPushed();
		
		// Loops until a path is found or not found
		while (!pathStack.isEmpty()) {
			Chamber current = pathStack.peek();
			
			//Checks if the current tile is the final treasure tile
			if (current.isTreasure() && numFound == numTreasures) {
				break;
			}
			
			// Gets the next best chamber and either pops the stack or pushes the chamber to the stack
			Chamber nextChamber = this.bestChamber(current);
			if (nextChamber == null) {
				pathStack.pop().markPopped();
			} else {
				pathStack.push(nextChamber);
				pathStack.peek().markPushed();
				if (pathStack.peek().isTreasure()) numFound++;
			}
		}
		return pathStack;
	}
	
	/**
	 * Accessor method to get the value of pyramidMap
	 * @return value of pyramidMap
	 */
	public Map getMap() {
		return pyramidMap;
	}
	
	/**
	 * Method checks if the given chamber is dim
	 * @param currentChamber chamber to check
	 * @return true if the chamber is dim and false if the chamber is not dim
	 */
	public boolean isDim(Chamber currentChamber) {
		boolean dimCheck = false;
		if (currentChamber.isSealed() || currentChamber.isLighted() || currentChamber.isTreasure() || currentChamber == null) {
			dimCheck = false;
		} else {
			// Checks surrounding chambers to see if one is Lighted
			for (int i = 0; i < 6; i++) {
				if (currentChamber.getNeighbour(i) != null) {
					if (currentChamber.getNeighbour(i).isLighted()) {
						dimCheck = true;
					}
				}
			}
		}
		return dimCheck;
	}
	
	/**
	 * Method finds the best chamber to move to next given the current chamber
	 * @param currentChamber current chamber position
	 * @return null if there are no good options or Chamber object to "travel" to next
	 */
	public Chamber bestChamber(Chamber currentChamber) {
		// Checks if the current Chamber has a unmarked treasure chamber as a neighbour
		for (int i = 0; i < 6; i++) {
			if (currentChamber.getNeighbour(i) != null) {
				if (currentChamber.getNeighbour(i).isTreasure() && !currentChamber.getNeighbour(i).isMarked()) {
					return currentChamber.getNeighbour(i);
				}
			}
		}
		
		// Checks if the current Chamber has a unmarked lighted chamber as a neighbour
		for (int i = 0; i < 6; i++) {
			if (currentChamber.getNeighbour(i) != null) {
				if (currentChamber.getNeighbour(i).isLighted() && !currentChamber.getNeighbour(i).isMarked()) {
					return currentChamber.getNeighbour(i);
				}
			}
		}
		
		// Checks if the current Chamber has a unmarked dim chamber as a neighbour
		for (int i = 0; i < 6; i++) {
			if (currentChamber.getNeighbour(i) != null) {
				if (this.isDim(currentChamber.getNeighbour(i)) && !currentChamber.getNeighbour(i).isMarked()) {
					return currentChamber.getNeighbour(i);
				}
			}
		}
		
		// If the chamber has no unmarked lighted, treasure, or dim neighbouring chambers, returns null
		return null;
	}
}
