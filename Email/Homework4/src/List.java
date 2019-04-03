
public class List {
	private ListNode header;
	private ListNode trailer;
	private int size;
	public List(){
		// header와 trailer에 대한 객체를 만들어 준 다음 initialization()을 이용해서 header, trailer을 서로 연결해준다
		header = new ListNode(null, null, null);
		trailer = new ListNode(null, null, null);
		initialization();
	}
	public void initialization(){
		// 헤더와 트레일러를 서로 연결해주면 가운데에 있던 리스트들은 refer이 사라져 안에 있던 리스트들이 모두 삭제된다
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
		size = 0;
	}
	public void addLast(Object element){
		// trailer의 앞 부분(리스트의 맨 뒤)에 새 노드를 추가해준다
		ListNode newNode = new ListNode(trailer.getPrevNode(), trailer, element);
		trailer.getPrevNode().setNextNode(newNode);
		trailer.setPrevNode(newNode);
		size++;
	}
	public void addFirst(Object element){
		// header의 뒷 부분(리스트의 맨 앞)에 새 노드를 추가해준다
		ListNode newNode = new ListNode(header, header.getNextNode(), element);
		header.getNextNode().setPrevNode(newNode);
		header.setNextNode(newNode);
		size++;
	}
	public ListNode getNode(int i){
		// while문으로 trailer가 아닐때까지 index를 더하고 해당 노드 인덱스와 같으면 그 노드를 반환한다
		int index = 0;
		ListNode temp = header.getNextNode();
		while(temp != trailer){
			if(index == i){
				return temp;
			} else {
				index++;
				temp = temp.getNextNode();
			}
		}
		return null;
	}
	public int getSize(){
		// 노드의 사이즈 반환
		return size;
	}
}
