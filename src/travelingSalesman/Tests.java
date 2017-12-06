package travelingSalesman;

public class Tests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SalesmanPath sp1 = new SalesmanPath("inputs/si1032.input");
		SalesmanPath sp1 = new SalesmanPath("inputs/si535.input");
		SalesmanPath sp2 = new SalesmanPath("inputs/si1032.input");
		SalesmanPath sp3 = new SalesmanPath("inputs/pa561.tsp.input");
		System.out.println(sp1);
//		sp1.getGraph().print();
		System.out.println(sp2);
		System.out.println(sp3);	
	}

}
