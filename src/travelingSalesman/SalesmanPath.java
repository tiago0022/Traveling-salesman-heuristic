package travelingSalesman;

import java.util.Arrays;

public class SalesmanPath extends CitiesMap {

	private int bestPath[];
	private int totalDistance;
	
	// Internal auxiliar variables 
	int path[];
	int visited; // count the amount of cities visited
	
	public SalesmanPath(String fileName) {
		super(fileName);
		// The path is a circuit, so the first and last elements are the same city
		this.bestPath = new int [this.getDimension() + 1];
		// Finds the best path
		this.totalDistance = -1; // Invalid total distance
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

	// Returns the distance between two cities
	private int dist(int city1, int city2){
		return this.getGraph().getWeight(city1, city2);
	}
	
	// Method to find the best path
	private void findBestPath(){
		// The method will try to find the best path for every starting point and will use the minimum
		for(int start = 0; start < this.getDimension(); start++){
			findBestPath(start);	
		}	
	}
	
	// Sets all cities as unvisited
	private void setAllUnvisited(){
		for(int i = 0; i < this.getDimension(); i++)
			this.getGraph().setUnvisited(i);
		this.visited = 0;
	}
	
	// Visits a city
	private void visitCity(int when, int to){
		path[when] = to;
		this.getGraph().setVisited(to);
		visited++;
	}
	
	// Finds ou if a city was visited
	private boolean wasVisited(int city){
		return this.getGraph().wasVisited(city);
	}
	
	// Method to find the best path from a begining point
	private void findBestPath(int start){
		int n = this.getDimension(); // for readability
		int lastCity, minDist = 0, moment = 0;
		
		this.path = new int[this.getDimension() + 1];
		this.visited = 0; 
		
		setAllUnvisited();
		
		visitCity(moment, start); // visits the first city in time 0
		lastCity = start;
//		System.out.println(Arrays.toString(this.path) + " > " + this.visited);
		// Repeats until all cities were visited
		while(visited < n){
//			System.out.println("LC:" + lastCity + " MD:" + minDist + " M:" + moment);
			moment++;
			
			// Finds the closest city
			int closest = -1, closestDist = -1;
			for(int i = 0; i < n; i++){
				if(!wasVisited(i)){
					if(dist(lastCity, i) < closestDist || closestDist == -1){ // If it's the first iteration or found a closer city
						closest = i;
						closestDist = dist(lastCity, closest);
					}
				}
			}
			
			// Updates distance
			minDist += dist(lastCity, closest);
			
			// Visits the closest city
			visitCity(moment, closest);
			lastCity = closest;
//			System.out.println(Arrays.toString(this.path) + " > " + minDist);
			
		}
		
		// Returns to the first city
		visitCity(moment + 1, start);
		minDist += dist(lastCity, start);
		
		if(minDist < this.totalDistance || this.totalDistance == -1){
			this.totalDistance = minDist;
			this.bestPath = this.path.clone();
		}
//		System.out.println(Arrays.toString(this.path) + " -----> " + minDist);
	}
}
