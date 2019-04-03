public class BinaryTree {
	private Node root = new Node();
	private int size;
	
	public BinaryTree(){
		root.setData("ROOT");
		root.setParent(null);
		size = 0;
	}
	
	public Node getRoot(){
		return this.root;
	}
	
	public Node addRoot(String data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setParent(null);
		this.size++;
		return newNode;
	}
	
	public Node insertLeft(Node v, String data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setParent(v);
		v.setLeft(newNode);
		return newNode;
	}
	
	public Node insertRight(Node v, String data){
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setParent(v);
		v.setRight(newNode);
		return newNode;
	}
	
	public boolean isRoot(Node v){
		return (v.getParent()==null)?true:false;
	}
	
	public boolean isInternal(Node v){
		return (hasLeft(v) || hasRight(v))?true:false;
	}
	
	public boolean isExternal(Node v){
		return !isInternal(v);
	}
	
	public boolean isLeaf(Node v){
		return isExternal(v);
	}
	
	public int depth(Node v){
		if(this.isRoot(v))
			return 0;
		else 
			return 1 + depth(v.getParent());
	}
	
	public int height(Node v){
		if(this.isExternal(v)) return 0;
		int h = 0;
		h = Math.max(height(v.getLeft()), height(v.getRight()));
		return 1 + h;
	}
	
	public void Preorder(Node v){
		v.printData();
		if(hasLeft(v)) this.Preorder(v.getLeft());
		if(hasRight(v)) this.Preorder(v.getRight());
	}
	
	public void Postorder(Node v){
		if(hasLeft(v)) this.Postorder(v.getLeft());
		if(hasRight(v)) this.Postorder(v.getRight());
		v.printData();
	}
	
	public void inOrder(Node v){
		if(hasLeft(v))
			inOrder(v.getLeft());
		System.out.println(v.getData());
		if(hasRight(v))
			inOrder(v.getRight());
	}
	
	public void attach(Node a, Node b, Node c){
		if(!isExternal(a)){
			System.out.println("Exception: Node " + a.getData() + " is not External");
			return ;
		} else {
			b.setParent(a);
			c.setParent(a);
			a.setLeft(b);
			a.setRight(c);
		}
	}
	
	// remove는 수정해야합니다.
	public void remove(Node v){
		if(isExternal(v.getParent())){ // 부모가 External 노드일 때 -> Parent가 ROOT
			v.getParent().setLeft(v.getLeft());
			v.getParent().setRight(v.getRight());
		} else if(hasLeft(v.getParent()) || hasRight(v.getParent())){
			if( (hasLeft(v) && hasRight(v))){
				System.out.println("Exception: Node has two nodes.");
				return ;
			} else {
				
			}
		}
		/*
		if(hasLeft(v.getParent()) && hasRight(v.getParent())){
			System.out.println("Exception: Node " + v.getParent().getData() + " has two nodes.");
			return ;
		} else if(isInternal(v.getParent())){ // 부모가 노드를 한가지 이상 가지고 있고
			if(hasLeft(v) && hasRight(v)){ // 현재 노드가 두개의 노드를 가지고 있으면,
				System.out.println("Exception: Node " + v.getParent().getData() + " has one more nodes.");
				return ;
			} else if(!hasLeft(v) && hasRight(v)){
				
			} else if(hasLeft(v) && !hasRight(v)){
				
			}
		} else if(isExternal(v)){
			v.getParent().setLeft(v.getLeft());
			v.getParent().setRight(v.getRight());
		}
		*/
	}
	
	public boolean hasLeft(Node v){
		return (v.getLeft()!=null)?true:false;
	}
	
	public boolean hasRight(Node v){
		return (v.getRight()!=null)?true:false;
	}

	public Node root(Node v){
		Node temp = v.getParent();
		while(temp != null){
			temp = temp.getParent();
		}
		return temp;
	}
	
	public Node parent(Node v){
		return v.getParent();
	}
	
	public Node left(Node v){
		return v.getLeft();
	}
	
	public Node right(Node v){
		return v.getRight();
	}
	
	/*
	 * addRoot
	 * insertLeft
	 * insertRight
	 * attach -> Node e is not external
	 * remove -> Exception: This node has two children
	 */
}