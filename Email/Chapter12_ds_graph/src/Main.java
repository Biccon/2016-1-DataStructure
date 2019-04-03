public class Main {
	public static void main(String[] args){
		Graph<String> g = new Graph<>();
		for(int i=0;i<8;i++)
			g.addVertex(i+"");

		g.addEdge("0", "4");
		g.addEdge("0", "3");
		g.addEdge("0", "2");
		g.addEdge("1", "3");
		g.addEdge("1", "6");
		g.addEdge("2", "5");
		g.addEdge("5", "6");
		g.addEdge("6", "7");
		g.addEdge("7", "4");
		g.addEdge("3", "7");
		
		g.printGraph();
		
		g.depthFirstSearch();
		
		g.breathFirstSearch();
	}
}