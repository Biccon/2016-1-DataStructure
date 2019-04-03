
public class List {
	private ListNode header;
	private ListNode trailer;
	private int size;
	public List(){
		// header�� trailer�� ���� ��ü�� ����� �� ���� initialization()�� �̿��ؼ� header, trailer�� ���� �������ش�
		header = new ListNode(null, null, null);
		trailer = new ListNode(null, null, null);
		initialization();
	}
	public void initialization(){
		// ����� Ʈ���Ϸ��� ���� �������ָ� ����� �ִ� ����Ʈ���� refer�� ����� �ȿ� �ִ� ����Ʈ���� ��� �����ȴ�
		header.setNextNode(trailer);
		trailer.setPrevNode(header);
		size = 0;
	}
	public void addLast(Object element){
		// trailer�� �� �κ�(����Ʈ�� �� ��)�� �� ��带 �߰����ش�
		ListNode newNode = new ListNode(trailer.getPrevNode(), trailer, element);
		trailer.getPrevNode().setNextNode(newNode);
		trailer.setPrevNode(newNode);
		size++;
	}
	public void addFirst(Object element){
		// header�� �� �κ�(����Ʈ�� �� ��)�� �� ��带 �߰����ش�
		ListNode newNode = new ListNode(header, header.getNextNode(), element);
		header.getNextNode().setPrevNode(newNode);
		header.setNextNode(newNode);
		size++;
	}
	public ListNode getNode(int i){
		// while������ trailer�� �ƴҶ����� index�� ���ϰ� �ش� ��� �ε����� ������ �� ��带 ��ȯ�Ѵ�
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
		// ����� ������ ��ȯ
		return size;
	}
}
