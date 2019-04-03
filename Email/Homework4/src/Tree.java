public class Tree {
	private TreeNode root;
	private TreeNode findNode;
	private List list;
	private List subList;
	private int height;
	private Object[] treeArray;
	
	public Tree(Object element){
		// Tree�� ������ �޼ҵ�. element�� ������ �ϰ� �θ� null���� �ش�(root)
		root = new TreeNode(element, null);
		height = 0;
	}
	private void findReculsive(TreeNode t, String str){
		// preorder ������� tree�� ���鼭 str�� �������ִ� ��带 ã�� ��ȯ�Ѵ�
		if(t.getData().equals(str)){
			findNode = t;
			return ;
		}	
		if(t.isLeft()) findReculsive(t.getLeftChild(), str);
		if(t.isRight()) findReculsive(t.getRightChild(), str);
	}
	public TreeNode findNode(String data){
		// findReculsive�� �̿��� String�� �Է¹޾� �� ��带 ��ȯ�Ѵ�
		findReculsive(root, data);
		return findNode;
	}
	
	public void preorder(TreeNode p){
		// preorder ������� tree�� ���鼭 �ش� ��� ���� ����Ѵ�
		System.out.println(p.getData());
		if(p.isLeft()) preorder(p.getLeftChild());
		if(p.isRight()) preorder(p.getRightChild());		
	}
	
	public TreeNode getRoot(){
		// �ش� Ʈ���� ��Ʈ�� ��ȯ�Ѵ�
		return this.root;
	}
	public void printNodeList(){
		// ����Ʈ�� ����ִ� element�� TreeNode�� Downcasting ��Ű�� �� Ʈ������� �����͸� ����Ѵ�
		for(int i=0;i<list.getSize();i++){
			System.out.println(((TreeNode)list.getNode(i).getElement()).getData());
		}
	}
	
	public void getAncestors(TreeNode node){
		// �ش� ����� ������� �����´�
		// ����Ʈ�� �ӽ÷� �����ϰ� ������ ������� ���ʴ�� ����Ѵ�. ( printNodeList()�̿� )
		list = new List();
		TreeNode temp = node;
		while(temp != null){
			list.addFirst(temp);
			temp = temp.getParent();
		}
		printNodeList();
	}
	
	// �̱���
	public void getCommonNode(TreeNode node1, TreeNode node2){
		// list�� node1�� �θ� ������ �Է�(�ڽ� ����)
		list = new List();
		TreeNode temp1 = node1;
		while(temp1 != null){
			list.addLast(temp1);
			temp1 = temp1.getParent();
		}
		// sublist�� node2�� �θ� ������ �Է�(�ڽ� ����)
		subList = new List();
		TreeNode temp2 = node2;
		while(temp2 != null){
			subList.addLast(temp2);
			temp2 = temp2.getParent();
		}
		for(int i=0;i<list.getSize();i++){
			for(int k=0;k<subList.getSize();k++){
				
				// ����Ʈ�� ����ִ� Ʈ����� ((TreeNode)list.getNode(i).getElement())
				// ���긮��Ʈ�� ����ִ� Ʈ����� ((TreeNode)subList.getNode(k).getElement())
				if(((TreeNode)list.getNode(i).getElement()) == ((TreeNode)subList.getNode(k).getElement())){
					TreeNode temp = ((TreeNode)list.getNode(i).getElement());
					// edge���ϴ� ��� = A ��忡�� B����� depth�� ���ָ� ���� �� �ִ�.
					int depth = ((depth(node1) - depth(temp)) + (depth(node2) - depth(temp)));
					
					System.out.println(temp.getData() + " �Ÿ� " + depth);
					return ;
				}
			}
		}
		
		System.out.println("End");
		
	}
	
	public void printSameLevelNodes(int level){
		// ����Ʈ�� �ʱ�ȭ �Ѵ�
		list = new List();
		// ���� Ʈ���� ��Ʈ�κ��� ���� level�� �ִ� Ʈ�������� ����Ʈ�� ���Ѵ�. root�� depth�� 0�̹Ƿ� 0�� �Ѱ���
		printSameLevelNodes(this.getRoot(), level, 0);
		// ��帮��Ʈ ���
		printNodeList();
	}
	public void printSameLevelNodes(TreeNode t, int level, int depth){
		// ��͸� ���Ͽ� level�� ���� ã�� �ִ� ����, depth�� �Ѱ��� ����� �������� level�� depth�� ������ ����Ʈ�� �߰������ش�.
		if(level == depth) list.addLast(t);
		if(t.isLeft()) printSameLevelNodes(t.getLeftChild(), level, depth(t.getLeftChild()));
		if(t.isRight()) printSameLevelNodes(t.getRightChild(), level, depth(t.getRightChild()));
	}
	
	public int depth(TreeNode t){
		// �θ����� depth + 1�������� ��͸� ���� �ش� ����� depth�� ���Ѵ�. baseline -> root�϶� depth 0
		if(t.isRoot()) return 0;
		
		int h;
		h = depth(t.getParent()) + 1;
		return h;
	}
	
	public void treeNumbering(TreeNode t, String str){
		// ��͸� ���Ͽ� Numbering�� ���ش�. left�� ���� str�ڿ� .1 right�϶��� .2�� ���� �Ѱ��ش�
		System.out.println(str + " : " + t.getData());
		if(t.isLeft()) treeNumbering(t.getLeftChild(), str + ".1");
		if(t.isRight()) treeNumbering(t.getRightChild(), str + ".2");
	}
	
	public void getHeight(TreeNode t, int depth){
		// ���������� height�� �Ű������� �Ѿ�� depth�� ���� ū ��(Math.max�̿�)�� height�� �Ҵ��ϰ� ��ͷ� �Ʒ� ������� üũ���ش�
		height = Math.max(height, depth);
		if(t.isLeft()) getHeight(t.getLeftChild(), depth(t.getLeftChild()));
		if(t.isRight()) getHeight(t.getRightChild(), depth(t.getRightChild()));
	}
	
	public void printHeight(){
		// Ʈ���� height�� ���ϴ� �Լ�. height�� 0���� �ʱ�ȭ ��Ű�� getHeight �Լ��� �����Ѵ�. �׸��� ���� ���� print����
		height = 0;
		getHeight(this.getRoot(), 0);
		System.out.println("Height of Tree : " + height);
	}
	
	public void treeToArray(){
		// Ʈ���� ���̸� �ϴ� ���Ѵ�.
		getHeight(this.getRoot(), 0);
		// root �����ؾ� �ϹǷ� 2^(height + 1)���� �迭 ����
		treeArray = new Object[(int) Math.pow(2, height + 1)];
		treeArray[0] = "";
		for(int i=1;i<treeArray.length;i++){ // Index = 0�� ���� �ƹ��͵� ���� �ʾƾ� �� -> treeArray[0] �� "" ���� ����
			treeArray[i] = new Object();
		}
		// ��͸� �̿��ؼ� treeArray �迭�� ���� ü���ش�
		treeToArray(this.getRoot());
		// for���� �̿��ؼ� treeArray�� ������ ������ش�.
		
		for(int i=0;i<treeArray.length;i++){
			System.out.print(String.format("%5d", i));
		}
		System.out.println();
		for(int i=0;i<treeArray.length;i++){
			System.out.print(String.format("%5s", treeArray[i]));
		}
		System.out.println();
	}
	public void treeToArray(TreeNode t){
		// treeArray�� p(t) �ε����� t�� �����͸� �־��ش�.
		treeArray[p(t)] = t.getData();
		if(t.isLeft()){
			// t�� leftchild�� ������ ���ȣ��
			treeToArray(t.getLeftChild());
		} else if(!t.isLeft() && (p(t) * 2) < treeArray.length) {
			// left�� ���� �� treeArray�ڸ��� null�� �־���� �ϹǷ� p(leftChild)�� ���� �����ش�.
			// ���� left������ index�� ��ü �迭�� ũ�⺸�� �۾ƾ� ��. �׷��� ������ ArrayIndexOutOfBoundsException
			treeArray[p(t) * 2] = null;
		}
		if(t.isRight()){
			treeToArray(t.getRightChild());
		} else if(!t.isRight() && (p(t) * 2 + 1) < treeArray.length) {
			// �������� ������ p(rightChild)�� ���� �����ش�
			// ���� right������ index�� ���� ���������� ��ü �迭�� ũ�⺸�� �۾ƾ���.
			treeArray[p(t) * 2 + 1] = null;
		}
	}
	
	public int p(TreeNode v){
		// p(v) ����ϴ� �Լ�
		// v �� ��Ʈ�� ���� p(v) = 1
		if(v.isRoot())
			return 1;
		// v �� u(v�� �θ�)�� left ����� �� p(v) = p(u) * 2
		else if(v.getParent().getLeftChild() == v)
			return p(v.getParent()) * 2;
		// v �� u(v �� �θ�)�� right ����� �� p(v) = p(v) * 2 + 1
		else if(v.getParent().getRightChild() == v)
			return p(v.getParent()) * 2 + 1;
		return 0;
	}
}
