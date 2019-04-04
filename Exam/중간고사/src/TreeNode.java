public class TreeNode {
	private Object element;
	private TreeNode left;
	private TreeNode right;
	private TreeNode parent;
	public TreeNode(Object element, TreeNode parent){
		this.parent = parent;
		this.element = element;
	}
	
	public void addLeftChild(Object element){
		// ���ʿ� element�� ������ ��带 �߰��Ѵ�.
		TreeNode newNode = new TreeNode(element, this);
		this.left = newNode;
	}
	public void addRightChild(Object element){
		// �����ʿ� element�� ������ ��带 �߰��Ѵ�
		TreeNode newNode = new TreeNode(element, this);
		this.right = newNode;
	}
	public void printData(){
		// �ش� ��尡 ������ �ִ� Object�� ����Ѵ�
		System.out.println(this.element);
	}
	public Object getData(){
		// �ش� ��尡 ������ �ִ� Object�� �����Ѵ�
		return this.element;
	}
	public TreeNode getLeftChild(){
		// ���� ��带 �����Ѵ�
		return this.left;
	}
	public TreeNode getRightChild(){
		// ������ ��带 �����Ѵ�
		return this.right;
	}
	public boolean isLeft(){
		// ���� ��尡 null�� �ƴ� �� ���� ��带 ������ �ִ�.
		return (this.left != null);
	}
	public boolean isRight(){
		// ������ ��尡 null�� �ƴ� �� ������ ��带 �������ִ�
		return (this.right != null);
	}
	public boolean isRoot(){
		// �θ� ��尡 ���� �� �ڱ� �ڽ��� ��Ʈ�̴�.
		return (this.parent == null);
	}
	public TreeNode getParent(){
		// �θ� ��带 �����Ѵ�
		return this.parent;
	}
	public TreeNode getRoot(){
		// �ڱ� ��带 �������κ��� �θ� ��尡 null�� �ƴҵ��� ������ ���� �θ� null�� ���� ��带 �����Ѵ�
		TreeNode temp = this;
		while(temp.getParent() != null){
			temp = temp.getParent();
		}
		return temp;
	}
}