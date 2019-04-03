
public class Node {
	private Node parent;
	private Node left;
	private Node right;
	private int data;
	
	public Node(){
		parent = null;
		left = null;
		right = null;
	}
	public Node(int data, Node p){
		this();
		this.data = data;
		this.parent = p;
	}
	
	public boolean isRoot(){
		return this.parent == null;
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return this.data;
	}

	public void addLeftChild(int data){
		Node newNode = new Node(data, this);
		this.left = newNode;
	}
	
	public void addRightChild(int data){
		Node newNode = new Node(data, this);
		this.right = newNode;
	}

	public void setLeftChild(Node p){
		this.left = p;
	}
	
	public void setRightChild(Node p){
		this.right = p;
	}
	
	public Node getLeftChild(){
		return this.left;
	}
	
	public Node getRightChild(){
		return this.right;
	}
	
	public boolean isLeft(){
		return this.left != null;
	}
	
	public boolean isRight(){
		return this.right != null;
	}
	
	public boolean isLeaf(){
		return this.left == null && this.right == null;
	}
}
