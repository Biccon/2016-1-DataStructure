
public class Heap extends CBTree {

	public Heap(){
		super();
	}
	public Heap(Object data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	public void swap(Node a, Node b){
		Object temp = a.getData();
		a.setData(b.getData());
		b.setData(temp);
	}
	
	public void insert(int key, Object data){
		Node newNode = super.add(new Entry(key, data));
		up_heap_bubbling();
	}
	
	// 끝
	public void up_heap_bubbling(){
		Node temp = lastNode;
		while(temp.getParent() != null){
			int tempKey = ((Entry)temp.getData()).getKey();
			int parentKey = ((Entry)temp.getParent().getData()).getKey();
			if(tempKey < parentKey)
				swap(temp.getParent(), temp);
			temp = temp.getParent();
		}
	}
	
	public void down_heap_bubbling(){
		Node temp = this.root;
		while(temp != null && !temp.isLeaf()){
			Node tempChild = null;
			// 둘 다 가지고 있을 때
			if(temp.isLeft() && temp.isRight()){
				int leftKey = ((Entry)temp.getLeftChild().getData()).getKey();
				int rightKey = ((Entry)temp.getRightChild().getData()).getKey();
				if(rightKey > leftKey)
					tempChild = temp.getLeftChild();
				else
					tempChild = temp.getRightChild();
			} else if(!temp.isRight()){
				tempChild = temp.getLeftChild();
			} else if(!temp.isLeft()){
				tempChild = temp.getRightChild();
			}
			int parentKey = ((Entry)temp.getData()).getKey();
			int childKey = ((Entry)tempChild.getData()).getKey();
			if(parentKey > childKey){
				swap(tempChild, temp);
			}
			temp = tempChild;
		}
	}
	
	public Object removeMin(){
		swap(this.lastNode, this.root);
		Object tempObject = super.remove();
		down_heap_bubbling();
		return tempObject;
	}

}
