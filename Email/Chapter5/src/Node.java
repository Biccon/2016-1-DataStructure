
public class Node {
	private Node prev;
	private String e;
	private Node next;
	
	public Node(){
		this.prev = null;
		this.e = "없음";
		this.next = null;
	}
	public Node(Node prev, String e, Node next){
		this.prev = prev;
		this.e = e;
		this.next = next;
	}
	public Object element(){
		return this.e;
	}
	public void setElement(String e){
		this.e = e;
	}
	public String getElement(){
		return this.e;
	}
	public void setPrev(Node p){
		this.prev = p;
	}
	public Node getPrev(){
		return this.prev;
	}
	public void setNext(Node p){
		this.next = p;
	}
	public Node getNext(){
		return this.next;
	}
}
