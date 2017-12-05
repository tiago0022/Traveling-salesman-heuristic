package travelingSalesman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import graphRepresentation.*;

public class CitiesMap {
	
	private String Name, type, edgeWeightType, edgeWeightFormat, displayDataType, nodeCoordType;
	private int dimension;
	private JGrafo graph;
	
	// Reads a file and converts it's info to the Cities Map instance
	public CitiesMap(String fileName){
		
		Scanner sc2 = null;
	    try {
	        sc2 = new Scanner(new File(fileName));
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();  
	    }
	    Scanner s2;
	    while (sc2.hasNextLine()) {
	            s2 = new Scanner(sc2.nextLine());
	        while (s2.hasNext()) {
	            String s = s2.next();
	            
	            switch(s){
	            	case("NAME"):
	            		s2.next();
	            		this.Name = s2.next();
	            		while (s2.hasNext())
	            			this.Name += " " + s2.next();
	            	break;
	            	case("NAME:"):
	            		this.Name = s2.next();
		            	while (s2.hasNext())
	            			this.Name += " " + s2.next();
	            	break;
	            	
	            	case("COMMENT"):
	            		while (s2.hasNext())
	            			s2.next();
	            	break;
	            	case("COMMENT:"):
	            		while (s2.hasNext())
	            			s2.next();
	            	break;
	            	
	            	case("TYPE"):
	            		s2.next();
	            		this.type = s2.next();
	            		while (s2.hasNext())
	            			this.type += " " + s2.next();
	            	break;
	            	case("TYPE:"):
	            		this.type = s2.next();
	            		while (s2.hasNext())
	            			this.type += " " + s2.next();
	            	break;
	            	
	            	case("DIMENSION"):
	            		s2.next();
	            		this.dimension = Integer.parseInt(s2.next());
	            	break;
	            	case("DIMENSION:"):
	            		this.dimension = Integer.parseInt(s2.next());
	            	break;
	            	
	            	case("EDGE_WEIGHT_TYPE"):
	            		s2.next();
	            		this.edgeWeightType = s2.next();
	            		while (s2.hasNext())
	            			this.edgeWeightType += " " + s2.next();
	            	break;
	            	case("EDGE_WEIGHT_TYPE:"):
	            		this.edgeWeightType = s2.next();
	            		while (s2.hasNext())
	            			this.edgeWeightType += " " + s2.next();
	            	break;
	            	
	            	case("EDGE_WEIGHT_FORMAT"):
	            		s2.next();
	            		this.edgeWeightFormat = s2.next();
	            		while (s2.hasNext())
	            			this.edgeWeightFormat += " " + s2.next();
	            	break;
	            	case("EDGE_WEIGHT_FORMAT:"):
	            		this.edgeWeightFormat = s2.next();
	            		while (s2.hasNext())
	            			this.edgeWeightFormat += " " + s2.next();
	            	break;
	            	
	            	case("NODE_COORD_TYPE"):
	            		s2.next();
	            		this.nodeCoordType = s2.next();
	            		while (s2.hasNext())
	            			this.nodeCoordType += " " + s2.next();
	            	break;
	            	case("NODE_COORD_TYPE:"):
	            		this.nodeCoordType = s2.next();
	            		while (s2.hasNext())
	            			this.nodeCoordType += " " + s2.next();
	            	break;
	            	
	            	case("DISPLAY_DATA_TYPE"):
	            		s2.next();
	            		this.displayDataType = s2.next();
	            		while (s2.hasNext())
	            			this.displayDataType += " " + s2.next();
	            	break;
	            	case("DISPLAY_DATA_TYPE:"):
	            		this.displayDataType = s2.next();
	            		while (s2.hasNext())
	            			this.displayDataType += " " + s2.next();
	            	break;
	            	
	            	// reads all number and adds to the graph depending on the EDGE_WEIGHT_FORMAT
	            	case("EDGE_WEIGHT_SECTION"):
	            		graph = new JGrafo(this.dimension);
	            		if(this.edgeWeightFormat.equals("UPPER_DIAG_ROW")){
		            		for(int i = 0; i < this.dimension; i++){
	            				for(int j = i; j < this.dimension; j++){
		            				if(s2.hasNext()){
		            					s = s2.next();
		            					if(s == "EOF")
		            						break;
		            					this.graph.addDoubleEdge(i, j, Integer.parseInt(s));
		            				}
		            				else{
		            					if(s == "EOF")
		            						break;
		            					s2 = new Scanner(sc2.nextLine());
		            					this.graph.addDoubleEdge(i, j, Integer.parseInt(s2.next()));
		            				}
		            			}
		            		}
	            		} else if(this.edgeWeightFormat.equals("LOWER_DIAG_ROW")){
		            		for(int i = 0; i < this.dimension; i++){
		            			for(int j = 0; j <= i; j++){
		            				if(s2.hasNext()){
		            					s = s2.next();
		            					if(s == "EOF")
		            						break;
		            					this.graph.addDoubleEdge(i, j, Integer.parseInt(s));
		            				}
		            				else{
		            					if(s == "EOF")
		            						break;
		            					s2 = new Scanner(sc2.nextLine());
		            					this.graph.addDoubleEdge(i, j, Integer.parseInt(s2.next()));
		            				}
		            			}
		            		}
	            		}
	            	break;
	            }
	        }
	    }
	}
	
	

	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getEdgeWeightType() {
		return edgeWeightType;
	}



	public void setEdgeWeightType(String edgeWeightType) {
		this.edgeWeightType = edgeWeightType;
	}



	public String getEdgeWeightFormat() {
		return edgeWeightFormat;
	}



	public void setEdgeWeightFormat(String edgeWeightFormat) {
		this.edgeWeightFormat = edgeWeightFormat;
	}



	public String getDisplayDataType() {
		return displayDataType;
	}



	public void setDisplayDataType(String displayDataType) {
		this.displayDataType = displayDataType;
	}



	public String getNodeCoordType() {
		return nodeCoordType;
	}



	public void setNodeCoordType(String nodeCoordType) {
		this.nodeCoordType = nodeCoordType;
	}



	public int getDimension() {
		return dimension;
	}



	public void setDimension(int dimension) {
		this.dimension = dimension;
	}



	public JGrafo getGraph() {
		return graph;
	}



	public void setGraph(JGrafo graph) {
		this.graph = graph;
	}



	@Override
	public String toString() {
		return "CitiesMap [Name=" + Name + ", type=" + type + ", edgeWeightType="
				+ edgeWeightType + ", edgeWeightFormat=" + edgeWeightFormat
				+ ", displayDataType=" + displayDataType + ", nodeCoordType="
				+ nodeCoordType + ", dimension=" + dimension + "]";
	}
	
	

	
}
