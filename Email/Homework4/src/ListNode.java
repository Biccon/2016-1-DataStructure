
public class ListNode {
	private Object element;
	private ListNode nextNode;
	private ListNode prevNode;
	
	public ListNode(ListNode prevNode, ListNode nextNode, Object element){
		// 리스트 노드 초기화.
		this.element = element;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
	
	public void setNextNode(ListNode nextNode){
		// NextNode를 지정한다
		this.nextNode = nextNode;
	}
	public void setPrevNode(ListNode prevNode){
		// PrevNode를 지정한다
		this.prevNode = prevNode;
	}
	public Object getElement(){
		// 현재 노드의 Element를 반환한다
		return this.element;
	}
	public ListNode getNextNode(){
		// 해당 노드 기준 다음 노드를 반환한다
		return this.nextNode;
	}
	public ListNode getPrevNode(){
		// 해당 노드 기준 이전 노드를 반환한다.
		return this.prevNode;
	}
}
