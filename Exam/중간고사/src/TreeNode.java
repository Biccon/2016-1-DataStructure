public class TreeNode {
	private Object element;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	public TreeNode(Object element, TreeNode parent){
		this.parent = parent;
		this.element = element;
	}
	
	public void addLeftChild(Object element){
		// 왼쪽에 element를 가지는 노드를 추가한다.
		TreeNode newNode = new TreeNode(element, this);
		this.left = newNode;
	}
	public void addRightChild(Object element){
		// 오른쪽에 element를 가지는 노드를 추가한다
		TreeNode newNode = new TreeNode(element, this);
		this.right = newNode;
	}
	public void printData(){
		// 해당 노드가 가지고 있는 Object를 출력한다
		System.out.println(this.element);
	}
	public Object getData(){
		// 해당 노드가 가지고 있는 Object를 리턴한다
		return this.element;
	}
	public TreeNode getLeftChild(){
		// 왼쪽 노드를 리턴한다
		return this.left;
	}
	public TreeNode getRightChild(){
		// 오른쪽 노드를 리턴한다
		return this.right;
	}
	public boolean isLeft(){
		// 왼쪽 노드가 null이 아닐 때 왼쪽 노드를 가지고 있다.
		return (this.left != null);
	}
	public boolean isRight(){
		// 오른쪽 노드가 null이 아닐 때 오른쪽 노드를 가지고있다
		return (this.right != null);
	}
	public boolean isRoot(){
		// 부모 노드가 없을 때 자기 자신이 루트이다.
		return (this.parent == null);
	}
	public TreeNode getParent(){
		// 부모 노드를 리턴한다
		return this.parent;
	}
	public TreeNode getRoot(){
		// 자기 노드를 기준으로부터 부모 노드가 null이 아닐동안 루프를 돌아 부모가 null일 때의 노드를 리턴한다
		TreeNode temp = this;
		while(temp.getParent() != null){
			temp = temp.getParent();
		}
		return temp;
	}
}