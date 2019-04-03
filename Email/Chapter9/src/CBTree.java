public class CBTree {
	protected Node root = null;
	protected int max = 0;
	protected Node lastNode = null;
	
	public CBTree(){
		root = null;
		lastNode = null;
	}
	public CBTree(Object data) {
		root = new Node(data, null);
		lastNode = root;
	}

	public Node add(Object data) {
		if(this.root == null){
			this.root = new Node(data, null);
		} else {
			String temp = Integer.toBinaryString(p(lastNode));
			// lastNode가 Full Binary Tree의 마지막 노드일 때
			if(temp.contains("0") == false){
				Node a = this.root;
				while(!a.isLeaf())
					a = a.getLeftChild();
				a.addLeftChild(data);
			} else {
				temp = Integer.toBinaryString(p(lastNode) + 1);
				add(this.root, data, temp.substring(0,  temp.length()-1));
			}
		}
		setLastNode();
		return lastNode;
	}
	
	private void add(Node v, Object data, String str){
		if(v.isLeft()) add(v.getLeftChild(), data, str);
		if(Integer.toBinaryString(p(v)).equals(str)){
			if(!v.isLeft()){
				v.addLeftChild(data);
			} else {
				v.addRightChild(data);
			}
			return ;
		}
		if(v.isRight()) add(v.getRightChild(), data, str);
	}
	
	public Object remove() {
		if(lastNode == null)
			return 0;
		Object temp = lastNode.getData();
		if(!lastNode.isRoot()) {
			if(lastNode.getParent().getLeftChild() == lastNode){
				lastNode.getParent().setLeftChild(null);
			} else if(lastNode.getParent().getRightChild() == lastNode){
				lastNode.getParent().setRightChild(null);
			}
		} else {
			root = null;
		}
		setLastNode();
		return temp;
	}
	
	public void setLastNode() {
		if(this.root == null){
			lastNode = null;
			return ;
		}
		max = 0;
		setLastNode(this.root, "1");
	}
	
	private void setLastNode(Node p, String str) {
		if(p.isLeft()) setLastNode(p.getLeftChild(), str + "0");
		int temp = Integer.valueOf(str);
		if(temp > max) {
			lastNode = p;
			max = temp;
		}
		if(p.isRight()) setLastNode(p.getRightChild(), str + "1");
	}
	
	/*
	public void setLastNode2() {
		Node temp = lastNode;
		while(!(temp.getParent() == root || temp.getParent().getRightChild() == temp)){
			temp = temp.getParent();
		}
		if(temp.isLeft()) temp = temp.getLeftChild();
		while(!temp.isLeaf())
			temp = temp.getRightChild();
		System.out.println(temp.getData());
	}
	
	public void s(Node p) {
		lastNode = p;
	}
	*/
	public Node getLastNode() {
		return this.lastNode;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	public int p(Node v){
		if(v.isRoot())
			return 1;
		else if(v.getParent().getLeftChild() == v)
			return p(v.getParent()) * 2;
		else if(v.getParent().getRightChild() == v)
			return p(v.getParent()) * 2 + 1;
		return 0;
	}

	public void inorder(){
		inorder(this.root);
	}
	
	private void inorder(Node v){
		if(v.isLeft()) inorder(v.getLeftChild());
		System.out.println(((Entry)v.getData()).getKey() + ", " + ((Entry)v.getData()).getValue());
		if(v.isRight()) inorder(v.getRightChild());
	}

	public void preorder(){
		preorder(this.root);
	}
	
	private void preorder(Node v){
		System.out.println(((Entry)v.getData()).getKey() + ", " + ((Entry)v.getData()).getValue());
		if(v.isLeft()) preorder(v.getLeftChild());
		if(v.isRight()) preorder(v.getRightChild());
	}
	
	
}
