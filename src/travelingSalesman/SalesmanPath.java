package travelingSalesman;

import java.util.Arrays;

import graphRepresentation.*;

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
		return "SalesmanPath [totalDistance=" + totalDistance + "\nbestPath=" + Arrays.toString(bestPath)
				+ "]";
	}

	// Method to find the best path
	public void findBestPath(){
		
	}
	
}
