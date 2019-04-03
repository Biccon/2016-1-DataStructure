
public class HeapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap h = new Heap();
		h.insert(8, "A"); h.preorder();
		System.out.println("=========================");
		h.insert(7, "B"); h.preorder();
		System.out.println("=========================");
		h.insert(6, "C"); h.preorder();
		System.out.println("=========================");
		h.insert(5, "D"); h.preorder();
		System.out.println("=========================");
		h.insert(4, "E"); h.preorder();
		System.out.println("=========================");
		h.insert(3, "F"); h.preorder();
		System.out.println("=========================");
		h.insert(2, "G"); h.preorder();
		System.out.println("=========================");
		h.insert(1, "H"); h.preorder();
		
		System.out.println("=======removeMin()=======");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		h.removeMin(); h.preorder();
		System.out.println("=========================");
		
	}	
}
