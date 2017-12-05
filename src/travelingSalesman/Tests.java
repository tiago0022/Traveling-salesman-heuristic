package travelingSalesman;

public class Tests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SalesmanPath cp = new SalesmanPath("pa561.tsp.input");
		System.out.println(cp);
		cp.getGraph().print();
		
	}

}
