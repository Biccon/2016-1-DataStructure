
public class LinkedList {
	private Node header = new Node();
	private Node trailer = new Node();
	private int size = 0;

	public LinkedList(){
		/*
		 * Header와 Tailer를 서로 연결한다.
		 */
		header.setNext(trailer);
		trailer.setPrev(header);
	}

	public void addFirst(String e){
		/*
		 * LinkedList 맨 앞에 e를 가지는 Node를 추가시킨다.
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
		 * LinkedList 맨 뒤에 e를 가지는 Node를 추가시킨다.
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
		 * LinkedList에서 f를 가지는 노드 뒤에 e를 가지는 Node를 추가시킨다.
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
		 * LinkedList에서 f를 가지는 노드 앞에 e를 가지는 Node를 추가시킨다.
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
		 * LinkedList에서 f를 가지는 노드를 e로 바꾼다.
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
		 * LinkedList에서 f를 가지는 노드 전후의 노드들을 서로 잇고 f를 가지는 노드를 없앤다(G.C가 알아서)
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
		 * LinkedList에서 연결된(Header ~ Trailer) 모든 노드를 출력한다.
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
		 * LinkedList에서 연결된(Trailer ~ Header) 모든 노드를 출력한다.
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
		 * LinkedList의 요소 개수를 반환한다.
		 */
		return this.size;
	}
	
	public boolean isEmpty(){
		/*
		 * LinkedList가 요소를 가지고 있는지 아닌지를 반환한다.
		 */
		return size==0?true:false;
	}
}
