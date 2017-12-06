package graphRepresentation;

public class JGrafo {
	
	//Matriz de adjacência
	protected Edge mat[][];
	//Vetor de vértices
	protected Vertex vertices[];
	//Número de vértices
	protected int numVertices;
	//Posição atual na lista de adjacência do vértice explorado
	private int pos[];
	
	// Classe vértice
	public static class Vertex{
		protected int id;
		protected boolean visited;
				
		public Vertex(int id) {
			this.id = id;
			this.visited = false;
		}

		@Override
		public String toString() {
			return "" + id;
		}
		
	}
	
	//Classe Aresta, com getters e setters para todos os atributos
	public static class Edge{
		
		//Conecta o vértice v1 ao vértice v2 com o peso "weight"
		private Vertex v1, v2;
		private int weight;

		public Edge(Vertex v1, Vertex v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public Vertex getV1() {
			return v1;
		}

		public void setV1(Vertex v1) {
			this.v1 = v1;
		}

		public Vertex getV2() {
			return v2;
		}

		public void setV2(Vertex v2) {
			this.v2 = v2;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "" + weight;
		}
		
	}

	/*
	 * Construtor que inicia a matriz com zeros, a posição mat[i][j] indica o peso da aresta que conecta
	 * v1 até v2, se o valor é 0, não existe tal aresta. A posição -1 em pos indica que a lista de adjacência
	 * do vértice ainda não foi explorada
	 */
	public JGrafo(int vertices) {
		
		this.numVertices = vertices;
		this.mat = new Edge[vertices][vertices];
		this.pos = new int[vertices];
		this.vertices = new Vertex[vertices];
		
		for(int i = 0; i < vertices; i++)
			this.vertices[i] = new Vertex(i);
		
		for(int i = 0; i < vertices ; i++){
			for(int j = 0; j < vertices ; j++){
				this.mat[i][j] = new Edge(this.vertices[i], this.vertices[j], 0);
				this.pos[i] = -1;
			}
		}
	}
	
	//Getters e Setters
	
	public Edge[][] getMat() {
		return mat;
	}

	public void setMat(Edge[][] mat) {
		this.mat = mat;
	}

	public int getVertices() {
		return numVertices;
	}

	public void setVertices(int vertices) {
		this.numVertices = vertices;
	}
	
	public void setVisited(int vertex){
		this.vertices[vertex].visited = true;
	}
	
	public void setUnvisited(int vertex){
		this.vertices[vertex].visited = false;
	}
	
	public boolean wasVisited(int vertex){
		return vertices[vertex].visited;
	}
	
	//Inserir aresta comum
	public void addEdge(int v1, int v2, int weight){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), weight);
	}
	
	//Inserir aresta sem peso (ou com o peso padrão que é 1)
	public void addEdge(int v1, int v2){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), 1);
	}
	
	//Inserir duas arestas (ou aresta não direcionada)
	public void addDoubleEdge(int v1, int v2, int weight){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), weight);
		this.mat[v2][v1] = new Edge(new Vertex(v2), new Vertex(v1), weight);
	}
	
	//Inserir duas arestas (ou aresta não direcionada) sem peso (ou com o peso padrão que é 1)
	public void addDoubleEdge(int v1, int v2){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), 1);
		this.mat[v2][v1] = new Edge(new Vertex(v2), new Vertex(v1), 1);
	}
	
	//Remover aresta
	public void removeEdge(int v1, int v2){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), 0);
	}
	
	//Remover duas arestas (ou aresta não direcionada)
	public void removeDoubleEdge(int v1, int v2){
		this.mat[v1][v2] = new Edge(new Vertex(v1), new Vertex(v2), 0);
		this.mat[v2][v1] = new Edge(new Vertex(v2), new Vertex(v1), 0);
	}
	
	//Verifica se existe uma aresta que vai de v1 a v2
	public boolean existsEdge(int v1, int v2){
		return (this.mat[v1][v2].weight > 0);
	}
	
	//Retorna o peso entre duas arestas
	public int getWeight(int v1, int v2){
		return this.mat[v1][v2].weight;
	}

	//Retorna a próxima aresta na pesquisa da lista de adjacência vértice v
	public Edge nextAdj(int v){
		for(int i = this.pos[v] + 1; i < this.numVertices; i++){
			//peso
			int w = this.mat[v][i].weight;
			//encontrou uma aresta existente
			if(w > 0){
				//atualiza a posição atual
				this.pos[v] = i;
				//retorna a aresta
				return new Edge (new Vertex(v), new Vertex(i), w);
			}
		}
		this.pos[v] = this.numVertices;
		return null;
	}
	
	//Inicia a pesquisa da lista de adjacência vértice v e retorna a primeira aresta que sai de v
	public Edge firstEdge (int v){
		this.pos[v] = -1;
		return this.nextAdj(v);
	}
	
	//Imprime a matriz
	public void print () {
	    
		System.out.println ();
		System.out.print ("     ");
	
		for (int i = 0; i < this.numVertices; i++) 
				System.out.print (String.format("%1$4s", i) + "|");
		System.out.println();
		for (int i = 0; i < this.numVertices; i++)
			System.out.print ("-----");
		System.out.println();
	
		for (int i = 0; i < this.numVertices; i++) { 
	  
			System.out.print (String.format("%1$4s", i) + "|");
			for (int j = 0; j < this.numVertices; j++)
				System.out.print (String.format("%1$4s", this.mat[i][j]) + "|");
			System.out.println ();
	    }
		System.out.println ();
	}
	
}
