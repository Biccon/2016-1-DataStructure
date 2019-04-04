import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph<T1, T2> {
	private ArrayList<Vertex<T1, T2>> vertexList;
	private Hashtable <T1, T1> visited;
	private boolean terminated = false;
	
	// �׷����� �ʱ�ȭ ��Ų��
	
	public Graph(){
		vertexList = new ArrayList<>();
		visited = new Hashtable<>();
	}
	
	// �׷����� ���� �ϳ��� �߰���Ų��
	public void addVertex(T1 ele){
		Vertex newVertex = new Vertex();
		newVertex.setElement(ele);
		vertexList.add(newVertex);
	}
	
	// �׷����� �ִ� ���� v1�� v2�� �հ� value���� ������ edge�� �ϳ� �߰���Ų��.
	public void addEdge(T1 v1, T1 v2, T2 value){
		this.findVertex(v1, false).addEdge(v2, value);
		this.findVertex(v2, false).addEdge(v1, value);
	}
	
	// ele�� ������ �ִ� vertex�� for���� �̿��ؼ� ã�� print�ϰų� ���� �ʴ´�.
	public Vertex<T1, T2> findVertex(T1 ele, Boolean print){
		Vertex tempVertex = null;
		for(Vertex<T1, T2> v : vertexList){
			if(v.getElement().equals(ele)){
				tempVertex = v;
				if(print)
					System.out.println(v.getElement());
			}
		}
		return tempVertex;
	}
	
	// �׷����� ����ִ� ��� ������ ������ش�
	public void printVertices(){
		System.out.println("=======printVertices=======");
		for(Vertex<T1, T2> v : vertexList){
			System.out.print(v.getElement() + " ");
		}
		System.out.println();
	}
	
	// ������ �ٷ� ����Ǿ��ִ� �ٸ� �������� ã�Ƽ� ��ȯ�Ѵ�.
	public ArrayList<T1> getAdjactiveVertices(Vertex v){
		ArrayList<T1> AdjactiveList = new ArrayList<>();
		for(Vertex<T1, T2> p : vertexList){
			if(p == v){
				HashMap<T1, T2> hm = p.getEdgeList();
				// key�� ���ؼ� hashMap�� forEach �ؼ� �ش� ���� ����Ʈ�� �߰����ش�.
				for(T1 key : hm.keySet()){
					AdjactiveList.add(key);
				}
				break;
			}
		}
		return AdjactiveList;
	}
	
	// ������ edge���� ���Ŀ� �°� ����Ѵ�.
	// vertex�� printEdgeList(���� ���Ḯ��Ʈ)�� �����Ƿ� �ش� �޼ҵ带 �̿��Ͽ� ������ش�.
	public void printGraph(){
		System.out.println("=======printGraph=======");
		for(Vertex<T1, T2> v : vertexList){
			v.printEdgeList();
		}
	}
	
	// data�� �޾ƿ� T2[][] �迭�� �̿��ؼ� edge�� �߰����ش�.
	// data[i][i]�� �ش� ���̰�
	// data[i][j]�� �ش� ���� ����Ǿ����� ���ڰ� �������ִ�. 0�� �ƴ� ��쿡 ���� �� ���̹Ƿ� edge�� �߰����ش�
	// edge�� value�� �ش� �迭�� ����(0�� �ƴ� ��)
	public void convertGraph (T2[][] data){
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				if((Integer)data[i][j] != 0)
					this.addEdge(vertexList.get(i).getElement(), vertexList.get(j).getElement(), data[i][j]);
			}
		}
	}
	
	// ���� �켱 ������� ele�κ��� �����ؼ� ���� �������� Ž���Ѵ�
	public void depthFirstSearch(T1 ele, T1 from){
		System.out.println(ele);
		visited.put(ele, ele);
		ArrayList<T1> temp = this.getAdjactiveVertices(this.findVertex(ele, false));
		for(T1 v : temp){
			if(!visited.contains(v)){
				depthFirstSearch(v, from);
				//if(v.equals(from))
				//	break;
			}
		}
	}
	
	// ȯ�¿��� ������ش�. ���� �������� 2������ ���� ���(����, ���� ���� �ٸ� ��) ȯ�¿����� �����Ǿ� ����Ѵ�.
	public void printTranslateStation(){
		System.out.println("=======ȯ�¿�=======");
		for(Vertex<T1, T2> v : vertexList){
			HashMap<T1, T2> hm = v.getEdgeList();
			if(hm.size() > 2) // ���� Vertex�� 2������ ������ ȯ�¿��̴�.
				System.out.println(v.getElement());
		}
		// ȯ�¿� ����Ʈ
		// �սʸ�, ����, �Ǵ��Ա�, ����
	}
	
	// �������� ������� ȯ�¿����� ������ ���� ArrayList�� �����Ͽ� ��ȯ�Ѵ�.
	public ArrayList<T1> getTranslateStation(){
		ArrayList<T1> temp = new ArrayList<>();
		for(Vertex<T1, T2> v : vertexList){
			HashMap<T1, T2> hm = v.getEdgeList();
			if(hm.size() > 2) // ���� Vertex�� 2������ ������ ȯ�¿��̴�.
				temp.add(v.getElement());
		}
		return temp;
	}
	
	// �ʺ�켱Ž�� ������� Graph�� Ž���Ѵ�.
	public void breadthFirstSearch(T1 ele){
		Queue<T1> q = new LinkedList<T1>();
		Stack<T1> s = new Stack();
		q.offer(ele);
		s.add(ele);
		visited.clear();
		visited.put(ele, ele);
		System.out.println("=============Breadth First Search=============");
		int level = 0;
		int t = 1;
		while(!q.isEmpty()){
			T1 temp = q.poll();
			s.remove(temp);
			Vertex<T1, T2> find = this.findVertex(temp, false);
			System.out.println(level + " " + find.getElement());
			t = find.getEdgeList().keySet().size();
			for(T1 key : find.getEdgeList().keySet()){
				if(!visited.containsKey(key)){
					q.offer(key);
					s.add(key);
					visited.put(key, key);// (T1) String.valueOf(level));
				}
			}
			
		}
	}
	
	// �ҿ�ð��� ������ִ� �Լ� pathã�¹�İ� �����ϰ� �����Ѵ�
	public void getTime(T1 ele1, T1 ele2){
		clearVisited();
		ArrayList<T1> path = new ArrayList<>();
		pathFind(ele1, ele2, path);
		int sumTime = 0;
		for(int i=0;i<path.size()-1;i++){
			Vertex<T1, T2> t1 =findVertex(path.get(i), false);
			Vertex<T1, T2> t2 = findVertex(path.get(i+1), false);
			
		}
		System.out.println();
	}

	public void clearVisited(){
		visited.clear();
		
	}
	
	
	// ele1���� ele2���� ���� ��θ� dfs������� Ž���ؼ� path��� ��� ����Ʈ�� �߰����ش�.
	public void pathFind(T1 ele1, T1 ele2){
		clearVisited();
		ArrayList<T1> path = new ArrayList<>();
		pathFind(ele1, ele2, path);
		System.out.println(ele1 + " ���� " + ele2 + " ������ ��ö��");
		for(T1 e : path){
			String tmpStr = e.toString();
			// ���� ���� �ƴ� ���߿� ȯ�¿��� ���ԵǾ������� ȯ���� ��
			if(getTranslateStation().contains(e) && e != ele1)
				tmpStr += "(ȯ��)";
			System.out.print(tmpStr + " ");
		}
		System.out.println();
	}
	
	//�Ʒ� �Լ��� ��������� ȣ���Ͽ� path��� ���� ����Ʈ�� dfs������� �����Ͽ� �߰����ִ� �Լ�
	public void pathFind(T1 ele, T1 from, ArrayList path){
		path.add(ele);
		visited.put(ele, ele);
		ArrayList<T1> temp = this.getAdjactiveVertices(this.findVertex(ele, false));
		for(T1 v : temp){
			if(!visited.contains(v)){
				if(findVertex(v, false) == findVertex(from, false)){
					path.add(v);
					terminated = true;
				}
				if(terminated)
					return;
				pathFind(v, from, path);
			}
		}
	}
}
