
public class ListNode {
	private Object element;
	private ListNode nextNode;
	private ListNode prevNode;
	
	public ListNode(ListNode prevNode, ListNode nextNode, Object element){
		// ����Ʈ ��� �ʱ�ȭ.
		this.element = element;
		this.prevNode = prevNode;
		this.nextNode = nextNode;
	}
	
	public void setNextNode(ListNode nextNode){
		// NextNode�� �����Ѵ�
		this.nextNode = nextNode;
	}
	public void setPrevNode(ListNode prevNode){
		// PrevNode�� �����Ѵ�
		this.prevNode = prevNode;
	}
	public Object getElement(){
		// ���� ����� Element�� ��ȯ�Ѵ�
		return this.element;
	}
	public ListNode getNextNode(){
		// �ش� ��� ���� ���� ��带 ��ȯ�Ѵ�
		return this.nextNode;
	}
	public ListNode getPrevNode(){
		// �ش� ��� ���� ���� ��带 ��ȯ�Ѵ�.
		return this.prevNode;
	}
}
