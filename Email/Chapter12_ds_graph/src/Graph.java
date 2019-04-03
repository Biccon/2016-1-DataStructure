import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph<T> {
	private int numVertex = 0;
	private int numEdge = 0;
	private ArrayList<Vertex<T>> vertexList = new ArrayList<Vertex<T>>();
	private ArrayList<T> visited = new ArrayList<T>();
	
	public void addVertex(T ele){
		vertexList.add(new Vertex(ele));
		numVertex++;
	}
	
	public void printVertices(){
		System.out.println("printVertices");
		for(Vertex<T> vertex : vertexList){
			System.out.print(vertex.getElement() + " ");
		}
		System.out.println();
	}
	
	public Vertex<T> findVertex(T ele, boolean print){
		for(Vertex<T> vertex : vertexList){
			if(vertex.getElement().equals(ele)){
				if(print) System.out.println("Vertex found" + ele);
				return vertex;
			}
		}
		return null;
	}
	
	public void addEdge(T e1, T e2){
		findVertex(e1, false).addEdge(e2);
		findVertex(e2, false).addEdge(e1);
	}
	
	public void printGraph(){
		System.out.println("printGraph");
		for(Vertex<T> vertex : vertexList){
			vertex.printEdgeList();
		}
	}
	
	public void depthFirstSearch(){
		visited.clear();
		System.out.println("DepthFirstSearch");
		this.depthFirstSearch((T)"0");
	}
	
	private void depthFirstSearch(T ele){
		Vertex<T> find = this.findVertex(ele, false);
		System.out.println(find.getElement());
		visited.add(find.getElement());
		Iterator<T> iter = find.getEdgeList().iterator();
		while(iter.hasNext()){
			T temp = iter.next();
			if(!visited.contains(temp))
				depthFirstSearch(temp);
		}
	}
	
	
	public void breathFirstSearch(){
		visited.clear();
		System.out.println("BreathFirstSearch");
		breathFirstSearch((T) "0");
	}
	
	private void breathFirstSearch(T ele){
		Queue<T> q = new LinkedList<T>();
		q.offer(ele);
		visited.clear(); //왜해주지?
		visited.add(ele);
		while(!q.isEmpty()){
			T temp = q.poll();
			Vertex<T> find = this.findVertex(temp, false);
			System.out.println(find.getElement());
			Iterator<T> iter = find.getEdgeList().iterator();
			
			while(iter.hasNext()){
				T e = iter.next();
				if(!visited.contains(e)){
					q.offer(e);
					visited.add(e);
				}
			}
		}
		
	}
}
