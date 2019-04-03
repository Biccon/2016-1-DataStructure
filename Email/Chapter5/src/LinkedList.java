public class LinkedList {
	private Node header = new Node();
	private Node trailer = new Node();
	private int size = 0;

	public LinkedList(){
		header.setNext(trailer);
		trailer.setPrev(header);
	}
	
	public void addLast(String e){
		Node newNode = new Node();
		newNode.setPrev(trailer.getPrev());
		newNode.setElement(e);
		newNode.setNext(trailer);
		
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}
	
	public boolean addBefore(int n, String e){
		Node temp = header.getNext();
		int index = 0;
		while(temp!=trailer){
			if(index == n){
				Node newNode = new Node();
				newNode.setPrev(temp.getPrev());
				newNode.setElement(e);
				newNode.setNext(temp);
				
				temp.getPrev().setNext(newNode);
				temp.setPrev(newNode);
				return true;
			}
			temp = temp.getNext();
			index++;
		}
		return false;
	}
	
	public void printAllNodes(){
		Node temp = header.getNext();
		while(temp != trailer){
			System.out.print(temp.getElement());
			temp = temp.getNext();
		}
		System.out.println();
	}
}
