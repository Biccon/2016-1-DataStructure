
public class Main {

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.getRoot().addLeft("1.Mammal");
		t.getRoot().addRight("2. Birds");
		t.getRoot().getLeft().addLeft("1-1. Dog");
		t.getRoot().getLeft().addRight("1-2. Cat");
		t.getRoot().getRight().addLeft("2-1. Sparrow");
		t.getRoot().getRight().addRight("2-2. Eagle");
		System.out.println(t.height2(t.getRoot()));
		System.out.println(t.depth(t.getRoot().getRight().getLeft()));
		System.out.println();
		System.out.println("Tree t's height" + t.height1(t));
		System.out.println();
		/*
		// exercise 1
		t.getRoot().printData();
		t.getRoot().getRight().printData();
		t.getRoot().getRight().getRight().printData();
		t.getRoot().getLeft().getRight().printData();
		System.out.println();
		
		*/
		// exercise 2
		t.Preorder(t.getRoot());
		
		System.out.println();
		t.Postorder(t.getRoot());
		
	}

}
