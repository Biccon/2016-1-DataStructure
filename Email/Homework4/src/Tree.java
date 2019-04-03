public class Tree {
	private TreeNode root;
	private TreeNode findNode;
	private List list;
	private List subList;
	private int height;
	private Object[] treeArray;
	
	public Tree(Object element){
		// Tree의 생성자 메소드. element를 가지게 하고 부모에 null값을 준다(root)
		root = new TreeNode(element, null);
		height = 0;
	}
	private void findReculsive(TreeNode t, String str){
		// preorder 방식으로 tree를 돌면서 str을 가지고있는 노드를 찾아 반환한다
		if(t.getData().equals(str)){
			findNode = t;
			return ;
		}	
		if(t.isLeft()) findReculsive(t.getLeftChild(), str);
		if(t.isRight()) findReculsive(t.getRightChild(), str);
	}
	public TreeNode findNode(String data){
		// findReculsive를 이용해 String을 입력받아 그 노드를 반환한다
		findReculsive(root, data);
		return findNode;
	}
	
	public void preorder(TreeNode p){
		// preorder 방식으로 tree를 돌면서 해당 노드 값을 출력한다
		System.out.println(p.getData());
		if(p.isLeft()) preorder(p.getLeftChild());
		if(p.isRight()) preorder(p.getRightChild());		
	}
	
	public TreeNode getRoot(){
		// 해당 트리의 루트를 반환한다
		return this.root;
	}
	public void printNodeList(){
		// 리스트에 들어있는 element를 TreeNode로 Downcasting 시키고 그 트리노드의 데이터를 출력한다
		for(int i=0;i<list.getSize();i++){
			System.out.println(((TreeNode)list.getNode(i).getElement()).getData());
		}
	}
	
	public void getAncestors(TreeNode node){
		// 해당 노드의 조상들을 가져온다
		// 리스트에 임시로 저장하고 저장한 순서대로 차례대로 출력한다. ( printNodeList()이용 )
		list = new List();
		TreeNode temp = node;
		while(temp != null){
			list.addFirst(temp);
			temp = temp.getParent();
		}
		printNodeList();
	}
	
	// 미구현
	public void getCommonNode(TreeNode node1, TreeNode node2){
		// list에 node1의 부모 노드들을 입력(자신 포함)
		list = new List();
		TreeNode temp1 = node1;
		while(temp1 != null){
			list.addLast(temp1);
			temp1 = temp1.getParent();
		}
		// sublist에 node2의 부모 노드들을 입력(자신 포함)
		subList = new List();
		TreeNode temp2 = node2;
		while(temp2 != null){
			subList.addLast(temp2);
			temp2 = temp2.getParent();
		}
		for(int i=0;i<list.getSize();i++){
			for(int k=0;k<subList.getSize();k++){
				
				// 리스트에 들어있는 트리노드 ((TreeNode)list.getNode(i).getElement())
				// 서브리스트에 들어있는 트리노드 ((TreeNode)subList.getNode(k).getElement())
				if(((TreeNode)list.getNode(i).getElement()) == ((TreeNode)subList.getNode(k).getElement())){
					TreeNode temp = ((TreeNode)list.getNode(i).getElement());
					// edge구하는 방법 = A 노드에서 B노드의 depth를 빼주면 구할 수 있다.
					int depth = ((depth(node1) - depth(temp)) + (depth(node2) - depth(temp)));
					
					System.out.println(temp.getData() + " 거리 " + depth);
					return ;
				}
			}
		}
		
		System.out.println("End");
		
	}
	
	public void printSameLevelNodes(int level){
		// 리스트를 초기화 한다
		list = new List();
		// 현재 트리의 루트로부터 같은 level에 있는 트리노드들을 리스트에 더한다. root의 depth는 0이므로 0을 넘겨줌
		printSameLevelNodes(this.getRoot(), level, 0);
		// 노드리스트 출력
		printNodeList();
	}
	public void printSameLevelNodes(TreeNode t, int level, int depth){
		// 재귀를 통하여 level은 내가 찾고 있는 레벨, depth는 넘겨줄 노드의 레벨으로 level과 depth가 같으면 리스트에 추가시켜준다.
		if(level == depth) list.addLast(t);
		if(t.isLeft()) printSameLevelNodes(t.getLeftChild(), level, depth(t.getLeftChild()));
		if(t.isRight()) printSameLevelNodes(t.getRightChild(), level, depth(t.getRightChild()));
	}
	
	public int depth(TreeNode t){
		// 부모노드의 depth + 1형식으로 재귀를 통해 해당 노드의 depth를 구한다. baseline -> root일때 depth 0
		if(t.isRoot()) return 0;
		
		int h;
		h = depth(t.getParent()) + 1;
		return h;
	}
	
	public void treeNumbering(TreeNode t, String str){
		// 재귀를 통하여 Numbering을 해준다. left일 때는 str뒤에 .1 right일때는 .2도 같이 넘겨준다
		System.out.println(str + " : " + t.getData());
		if(t.isLeft()) treeNumbering(t.getLeftChild(), str + ".1");
		if(t.isRight()) treeNumbering(t.getRightChild(), str + ".2");
	}
	
	public void getHeight(TreeNode t, int depth){
		// 전역변수인 height와 매개변수로 넘어온 depth중 가장 큰 값(Math.max이용)을 height에 할당하고 재귀로 아래 노드들까지 체크해준다
		height = Math.max(height, depth);
		if(t.isLeft()) getHeight(t.getLeftChild(), depth(t.getLeftChild()));
		if(t.isRight()) getHeight(t.getRightChild(), depth(t.getRightChild()));
	}
	
	public void printHeight(){
		// 트리의 height를 구하는 함수. height를 0으로 초기화 시키고 getHeight 함수를 실행한다. 그리고 계산된 값을 print해줌
		height = 0;
		getHeight(this.getRoot(), 0);
		System.out.println("Height of Tree : " + height);
	}
	
	public void treeToArray(){
		// 트리의 높이를 일단 구한다.
		getHeight(this.getRoot(), 0);
		// root 포함해야 하므로 2^(height + 1)개의 배열 생성
		treeArray = new Object[(int) Math.pow(2, height + 1)];
		treeArray[0] = "";
		for(int i=1;i<treeArray.length;i++){ // Index = 0인 곳은 아무것도 들어가지 않아야 함 -> treeArray[0] 에 "" 대입 해줌
			treeArray[i] = new Object();
		}
		// 재귀를 이용해서 treeArray 배열의 값을 체워준다
		treeToArray(this.getRoot());
		// for문을 이용해서 treeArray의 값들을 출력해준다.
		
		for(int i=0;i<treeArray.length;i++){
			System.out.print(String.format("%5d", i));
		}
		System.out.println();
		for(int i=0;i<treeArray.length;i++){
			System.out.print(String.format("%5s", treeArray[i]));
		}
		System.out.println();
	}
	public void treeToArray(TreeNode t){
		// treeArray의 p(t) 인덱스에 t의 데이터를 넣어준다.
		treeArray[p(t)] = t.getData();
		if(t.isLeft()){
			// t의 leftchild가 있으면 재귀호출
			treeToArray(t.getLeftChild());
		} else if(!t.isLeft() && (p(t) * 2) < treeArray.length) {
			// left가 없을 때 treeArray자리에 null을 넣어줘야 하므로 p(leftChild)를 직접 구해준다.
			// 계산된 left공간의 index가 전체 배열의 크기보다 작아야 함. 그렇지 않으면 ArrayIndexOutOfBoundsException
			treeArray[p(t) * 2] = null;
		}
		if(t.isRight()){
			treeToArray(t.getRightChild());
		} else if(!t.isRight() && (p(t) * 2 + 1) < treeArray.length) {
			// 마찬가지 이유로 p(rightChild)를 직접 구해준다
			// 계산된 right공간의 index가 위아 마찬가지로 전체 배열의 크기보다 작아야함.
			treeArray[p(t) * 2 + 1] = null;
		}
	}
	
	public int p(TreeNode v){
		// p(v) 계산하는 함수
		// v 가 루트일 때는 p(v) = 1
		if(v.isRoot())
			return 1;
		// v 가 u(v의 부모)의 left 노드일 때 p(v) = p(u) * 2
		else if(v.getParent().getLeftChild() == v)
			return p(v.getParent()) * 2;
		// v 가 u(v 의 부모)의 right 노드일 때 p(v) = p(v) * 2 + 1
		else if(v.getParent().getRightChild() == v)
			return p(v.getParent()) * 2 + 1;
		return 0;
	}
}
