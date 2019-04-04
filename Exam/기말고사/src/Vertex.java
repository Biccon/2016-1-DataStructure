import java.util.HashMap;

public class Vertex<T1, T2> {
	private T1 element;
	private HashMap<T1, T2> edgeList;
	
	// vertex �ʱ�ȭ
	public Vertex(){
		edgeList = new HashMap<>();
	}
	// element ����
	public T1 getElement(){
		return this.element;
	}
	// edge�� �߰����ش�. edge == vertex name.
	// �ش� vertex name �� value�� ����ִ�
	public void addEdge(T1 edge, T2 value){
		edgeList.put(edge, value);
	}
	
	// ������ �ִ� edgelist�� ��ȯ���ش�
	public HashMap<T1, T2> getEdgeList(){
		return this.edgeList;
	}
	
	// edgelist�� �߰��Ǿ��մ� edge���� ���Ŀ� �°� ����Ѵ�
	public void printEdgeList(){
		System.out.print(element);
		for(T1 key : edgeList.keySet()){
			System.out.print("-->" + key+"(" + edgeList.get(key) + ")");
		}
		System.out.println();
	}
	// �ش� vertex�� element�� �������ش�
	public void setElement(T1 element) {
		this.element = element;
	}
}
