
public class Main {
	/*
	public static void main(String[] args) {
		Graph<String, Integer> graph = new Graph<>();
		System.out.println("Test Code");
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addEdge("A", "B", 1);
		graph.addEdge("B", "C", 3);
		graph.addEdge("C", "A", 4);
		graph.printGraph();
	}
	*/
	public static void main(String[] args) {
    	Graph<String,Integer> graph=new Graph<>();
    	graph.addVertex("�Ǵ��Ա�");	graph.addVertex("����");
    	graph.addVertex("����");		graph.addVertex("����");
    	graph.addVertex("�Ҽ�");		graph.addVertex("�Ѿ��");
    	graph.addVertex("�սʸ�");		graph.addVertex("��սʸ�");
    	graph.addVertex("���");		graph.addVertex("�Ŵ�");
    	graph.addVertex("����");		graph.addVertex("���");
    	graph.addVertex("��ʸ�");		graph.addVertex("������");
    	graph.addVertex("����");		graph.addVertex("������");
    	graph.addVertex("�Ҽ�������");	graph.addVertex("��̴����");
    	graph.addVertex("�߰�");
    	graph.printVertices();
    	Integer[][] table =
    	       {{0,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,0},
    	        {2,0,0,0,1,0,0,0,3,0,0,0,0,0,0,0,0,0,0},
    	        {3,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,1,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,0,0,0,2,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,0,0,0,0,2,0,1,0,0,2,2,0,0,0,0,0,0,0},
    	        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0},
    	        {0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0},
    	        {0,0,0,0,0,0,2,0,0,0,0,0,2,0,0,0,0,0,0},
    	        {0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {0,0,0,0,0,0,0,0,0,0,2,0,0,3,0,0,0,0,0},
    	        {0,0,0,0,0,0,0,0,0,0,0,0,3,0,3,0,0,0,0},
    	        {0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,2,0,2,2},
    	        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
    	        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    	        {2,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0},
    	        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0}};
    	graph.convertGraph(table);
    	graph.printGraph();
    	System.out.println("=======DFS=======");
    	graph.depthFirstSearch("�Ǵ��Ա�","����");
    	graph.printTranslateStation();
    	graph.breadthFirstSearch("�Ǵ��Ա�");

    	graph.pathFind("�Ǵ��Ա�", "������");
    	
    	//graph.printPath();
    	
    	//graph.pathFind("�Ǵ��Ա�","������");
    	
    }
}
