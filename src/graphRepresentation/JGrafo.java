package graphRepresentation;

public class JGrafo {
	
	//Matriz de adjacência
	protected int mat[][];
	//Número de vértices
	protected int numVertices;
	//Posição atual na lista de adjacência do vértice explorado
	private int pos[];
	
	//Classe Aresta, com getters e setters para todos os atributos
	public static class Edge{
		
		//Conecta o vértice v1 ao vértice v2 com o peso "weight"
		private int v1, v2, weight;

		public Edge(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		public int getV1() {
			return v1;
		}

		public void setV1(int v1) {
			this.v1 = v1;
		}

		public int getV2() {
			return v2;
		}

		public void setV2(int v2) {
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
			return "[" + v1 + "]->[" + v2 + "]";
		}
		
	}

	/*
	 * Construtor que inicia a matriz com zeros, a posição mat[i][j] indica o peso da aresta que conecta
	 * v1 até v2, se o valor é 0, não existe tal aresta. A posição -1 em pos indica que a lista de adjacência
	 * do vértice ainda não foi explorada
	 */
	public JGrafo(int vertices) {
		
		this.numVertices = vertices;
		this.mat = new int[vertices][vertices];
		this.pos = new int[vertices];
		
		for(int i = 0; i < vertices ; i++)
			for(int j = 0; j < vertices ; j++){
				this.mat[i][j] = 0;
				this.pos[i] = -1;
			}
	}
	
	//Getters e Setters
	
	public int[][] getMat() {
		return mat;
	}

	public void setMat(int[][] mat) {
		this.mat = mat;
	}

	public int getVertices() {
		return numVertices;
	}

	public void setVertices(int vertices) {
		this.numVertices = vertices;
	}
	
	//Inserir aresta comum
	public void addEdge(int v1, int v2, int weight){
		this.mat[v1][v2] = weight;
	}
	
	//Inserir aresta sem peso (ou com o peso padrão que é 1)
	public void addEdge(int v1, int v2){
		this.mat[v1][v2] = 1;
	}
	
	//Inserir duas arestas (ou aresta não direcionada)
	public void addDoubleEdge(int v1, int v2, int weight){
		this.mat[v1][v2] = weight;
		this.mat[v2][v1] = weight;
	}
	
	//Inserir duas arestas (ou aresta não direcionada) sem peso (ou com o peso padrão que é 1)
	public void addDoubleEdge(int v1, int v2){
		this.mat[v1][v2] = 1;
		this.mat[v2][v1] = 1;
	}
	
	//Remover aresta
	public void removeEdge(int v1, int v2){
		this.mat[v1][v2] = 0;
	}
	
	//Remover duas arestas (ou aresta não direcionada)
	public void removeDoubleEdge(int v1, int v2){
		this.mat[v1][v2] = 0;
		this.mat[v2][v1] = 0;
	}
	
	//Verifica se existe uma aresta que vai de v1 a v2
	public boolean existsEdge(int v1, int v2){
		return (this.mat[v1][v2] > 0);
	}

	//Retorna a próxima aresta na pesquisa da lista de adjacência vértice v
	public Edge nextAdj(int v){
		for(int i = this.pos[v] + 1; i < this.numVertices; i++){
			//peso
			int w = this.mat[v][i];
			//encontrou uma aresta existente
			if(w > 0){
				//atualiza a posição atual
				this.pos[v] = i;
				//retorna a aresta
				return new Edge (v, i, w);
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
