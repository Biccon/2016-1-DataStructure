
public class LinkedList {
	private Node header = new Node();
	private Node trailer = new Node();
	private int size = 0;

	public LinkedList(){
		/*
		 * Header�� Tailer�� ���� �����Ѵ�.
		 */
		header.setNext(trailer);
		trailer.setPrev(header);
	}

	public void addFirst(String e){
		/*
		 * LinkedList �� �տ� e�� ������ Node�� �߰���Ų��.
		 */
		Node newNode = new Node();
		newNode.setPrev(header);
		newNode.setElement(e);
		newNode.setNext(header.getNext());
		
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		size++;
	}
	
	public void addLast(String e){
		/*
		 * LinkedList �� �ڿ� e�� ������ Node�� �߰���Ų��.
		 */
		Node newNode = new Node();
		newNode.setPrev(trailer.getPrev());
		newNode.setElement(e);
		newNode.setNext(trailer);
		
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		size++;
	}
	
	public void addAfter(String f, String e){
		/*
		 * LinkedList���� f�� ������ ��� �ڿ� e�� ������ Node�� �߰���Ų��.
		 */
		Node temp = header.getNext();
		while(temp != trailer){
			if(temp.getElement().equals(f)){
				Node newNode = new Node();
				newNode.setPrev(temp);
				newNode.setElement(e);
				newNode.setNext(temp.getNext());
				
				temp.getNext().setPrev(newNode);
				temp.setNext(newNode);
				size++;
				break;
			}
			temp = temp.getNext();
		}
	}
	public void addBefore(String f, String e){
		/*
		 * LinkedList���� f�� ������ ��� �տ� e�� ������ Node�� �߰���Ų��.
		 */
		Node temp = header.getNext();
		while(temp != trailer){
			if(temp.getElement().equals(f)){
				Node newNode = new Node();
				
				newNode.setPrev(temp.getPrev());
				newNode.setElement(e);
				newNode.setNext(temp);
				
				temp.getPrev().setNext(newNode);
				temp.setPrev(newNode);
				
				size++;
				break;
			}
			temp = temp.getNext();
		}
	}
	public void set(String f, String e){
		/*
		 * LinkedList���� f�� ������ ��带 e�� �ٲ۴�.
		 */
		Node temp = header.getNext();
		while(temp != trailer){
			if(temp.getElement().equals(f)){
				temp.setElement(e);
				break;
			}
			temp = temp.getNext();
		}
	}
	
	public void remove(String f){
		/*
		 * LinkedList���� f�� ������ ��� ������ ������ ���� �հ� f�� ������ ��带 ���ش�(G.C�� �˾Ƽ�)
		 */
		Node temp = trailer.getPrev();
		while(temp != header){
			if(temp.getElement().equals(f)){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				size--;
				// how to deletion?
				break;
			}
			
			temp = temp.getPrev();
		}
	}
	
	public void printAllNodes(){
		/*
		 * LinkedList���� �����(Header ~ Trailer) ��� ��带 ����Ѵ�.
		 */
		Node temp = header.getNext();
		while(temp != trailer){
			System.out.print(temp.getElement() + "");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public void printRev(){
		/*
		 * LinkedList���� �����(Trailer ~ Header) ��� ��带 ����Ѵ�.
		 */
		Node temp = trailer.getPrev();
		while(temp != header){
			System.out.print(temp.getElement() + "");
			temp = temp.getPrev();
		}
		System.out.println();
	}

	public int size(){
		/*
		 * LinkedList�� ��� ������ ��ȯ�Ѵ�.
		 */
		return this.size;
	}
	
	public boolean isEmpty(){
		/*
		 * LinkedList�� ��Ҹ� ������ �ִ��� �ƴ����� ��ȯ�Ѵ�.
		 */
		return size==0?true:false;
	}
}
