
public class Main {

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.getRoot().addLeft("1.Mammal");
		t.getRoot().addRight("2. Birds");
		t.getRoot().getLeft().addLeft("1-1. Dog");
		t.getRoot().getLeft().addRight("1-2. Cat");
		t.getRoot().getRight().addLeft("2-1. Sparrow");
		t.getRoot().getRight().addRight("2-2. Eagle");
		System.out.println(t.getRoot().getData() + "'s Height : " + t.height(t.getRoot()));
		System.out.println(t.getRoot().getRight().getData() + "'s Depth : " + t.depth(t.getRoot().getRight()));
	}

}
