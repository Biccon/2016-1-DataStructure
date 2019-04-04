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
	
	// 그래프를 초기화 시킨다
	
	public Graph(){
		vertexList = new ArrayList<>();
		visited = new Hashtable<>();
	}
	
	// 그래프에 정점 하나를 추가시킨다
	public void addVertex(T1 ele){
		Vertex newVertex = new Vertex();
		newVertex.setElement(ele);
		vertexList.add(newVertex);
	}
	
	// 그래프에 있는 정점 v1과 v2를 잇고 value값을 가지는 edge를 하나 추가시킨다.
	public void addEdge(T1 v1, T1 v2, T2 value){
		this.findVertex(v1, false).addEdge(v2, value);
		this.findVertex(v2, false).addEdge(v1, value);
	}
	
	// ele를 가지고 있는 vertex를 for문을 이용해서 찾고 print하거나 하지 않는다.
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
	
	// 그래프에 들어있는 모든 정점을 출력해준다
	public void printVertices(){
		System.out.println("=======printVertices=======");
		for(Vertex<T1, T2> v : vertexList){
			System.out.print(v.getElement() + " ");
		}
		System.out.println();
	}
	
	// 정점과 바로 연결되어있는 다른 정점들을 찾아서 반환한다.
	public ArrayList<T1> getAdjactiveVertices(Vertex v){
		ArrayList<T1> AdjactiveList = new ArrayList<>();
		for(Vertex<T1, T2> p : vertexList){
			if(p == v){
				HashMap<T1, T2> hm = p.getEdgeList();
				// key를 통해서 hashMap을 forEach 해서 해당 인접 리스트에 추가해준다.
				for(T1 key : hm.keySet()){
					AdjactiveList.add(key);
				}
				break;
			}
		}
		return AdjactiveList;
	}
	
	// 정점과 edge들을 형식에 맞게 출력한다.
	// vertex에 printEdgeList(인접 연결리스트)가 있으므로 해당 메소드를 이용하여 출력해준다.
	public void printGraph(){
		System.out.println("=======printGraph=======");
		for(Vertex<T1, T2> v : vertexList){
			v.printEdgeList();
		}
	}
	
	// data로 받아온 T2[][] 배열을 이용해서 edge를 추가해준다.
	// data[i][i]는 해당 역이고
	// data[i][j]는 해당 역과 연결되었는지 숫자가 적혀져있다. 0이 아닐 경우에 연결 된 것이므로 edge를 추가해준다
	// edge의 value는 해당 배열의 내용(0이 아닌 수)
	public void convertGraph (T2[][] data){
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[i].length;j++){
				if((Integer)data[i][j] != 0)
					this.addEdge(vertexList.get(i).getElement(), vertexList.get(j).getElement(), data[i][j]);
			}
		}
	}
	
	// 깊이 우선 방식으로 ele로부터 시작해서 인접 정점들을 탐색한다
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
	
	// 환승역을 출력해준다. 인접 정점들이 2개보다 많은 경우(상행, 하행 제외 다른 역) 환승역으로 구별되어 출력한다.
	public void printTranslateStation(){
		System.out.println("=======환승역=======");
		for(Vertex<T1, T2> v : vertexList){
			HashMap<T1, T2> hm = v.getEdgeList();
			if(hm.size() > 2) // 인접 Vertex가 2개보다 많으면 환승역이다.
				System.out.println(v.getElement());
		}
		// 환승역 리스트
		// 왕십리, 성수, 건대입구, 군자
	}
	
	// 마찬가지 방법으로 환승역으로 구별된 역을 ArrayList로 저장하여 반환한다.
	public ArrayList<T1> getTranslateStation(){
		ArrayList<T1> temp = new ArrayList<>();
		for(Vertex<T1, T2> v : vertexList){
			HashMap<T1, T2> hm = v.getEdgeList();
			if(hm.size() > 2) // 인접 Vertex가 2개보다 많으면 환승역이다.
				temp.add(v.getElement());
		}
		return temp;
	}
	
	// 너비우선탐색 방법으로 Graph를 탐색한다.
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
	
	// 소요시간을 출력해주는 함수 path찾는방식과 동일하게 진행한다
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
	
	
	// ele1에서 ele2까지 가는 경로를 dfs방법으로 탐색해서 path라는 어레이 리스트에 추가해준다.
	public void pathFind(T1 ele1, T1 ele2){
		clearVisited();
		ArrayList<T1> path = new ArrayList<>();
		pathFind(ele1, ele2, path);
		System.out.println(ele1 + " 에서 " + ele2 + " 까지의 전철역");
		for(T1 e : path){
			String tmpStr = e.toString();
			// 시작 역이 아닌 역중에 환승역이 포함되어있으면 환승한 것
			if(getTranslateStation().contains(e) && e != ele1)
				tmpStr += "(환승)";
			System.out.print(tmpStr + " ");
		}
		System.out.println();
	}
	
	//아래 함수는 재귀적으로 호출하여 path라는 연결 리스트에 dfs방식으로 접근하여 추가해주는 함수
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
