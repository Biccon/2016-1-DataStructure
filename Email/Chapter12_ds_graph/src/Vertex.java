import java.util.ArrayList;
import java.util.Iterator;


public class Vertex <T>{
	private T element;
	private ArrayList<T> edgeList = new ArrayList<T>();
	
	public Vertex(T ele){
		this.element = ele;
	}
	
	public T getElement(){
		return this.element;
	}
	
	public void addEdge(T edge){
		edgeList.add(edge);
	}
	
	public ArrayList<T> getEdgeList(){
		return this.edgeList;
	}
	
	public void  printEdgeList(){
		Iterator<T> iter = edgeList.iterator();
		System.out.print(this.element);
		while(iter.hasNext()){
			T e = iter.next();
			System.out.print("-->" + e);
		}
		System.out.println();
	}
}
