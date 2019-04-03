public class Node {
	private Node parent;
	private Node left;
	private Node right;
	private String data;

	public Node(){
		parent = null;
		left = null;
		right = null;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public void printData(){
		System.out.println(this.data);
	}
	public void addLeft(String data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setParent(this);
		this.setLeft(newNode);
	}
	public void addRight(String data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setParent(this);
		this.setRight(newNode);
	}
}
