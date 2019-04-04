import java.util.HashMap;

public class Vertex<T1, T2> {
	private T1 element;
	private HashMap<T1, T2> edgeList;
	
	// vertex 초기화
	public Vertex(){
		edgeList = new HashMap<>();
	}
	// element 설정
	public T1 getElement(){
		return this.element;
	}
	// edge를 추가해준다. edge == vertex name.
	// 해당 vertex name 에 value도 들어있다
	public void addEdge(T1 edge, T2 value){
		edgeList.put(edge, value);
	}
	
	// 가지고 있는 edgelist를 반환해준다
	public HashMap<T1, T2> getEdgeList(){
		return this.edgeList;
	}
	
	// edgelist에 추가되어잇는 edge들을 형식에 맞게 출력한다
	public void printEdgeList(){
		System.out.print(element);
		for(T1 key : edgeList.keySet()){
			System.out.print("-->" + key+"(" + edgeList.get(key) + ")");
		}
		System.out.println();
	}
	// 해당 vertex의 element를 설정해준다
	public void setElement(T1 element) {
		this.element = element;
	}
}
