package travelingSalesman;

import java.util.Arrays;

public class SalesmanPath extends CitiesMap {

	private int bestPath[];
	private int totalDistance;
	
	public SalesmanPath(String fileName) {
		super(fileName);
		this.bestPath = new int [this.getDimension()];
		this.findBestPath();
	}
	
	public int[] getBestPath() {
		return bestPath;
	}

	public int getTotalDistance() {
		return totalDistance;
	}

	@Override
	public String toString() {
		return "SalesmanPath [\n\tname = " + this.getName() + ", totalDistance = " + totalDistance + ",\n\tbestPath = " + Arrays.toString(bestPath)
				+ "\n]";
	}

	// Method to find the best path
	public void findBestPath(){
		
	}
	
}
