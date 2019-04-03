public class Main {
	public static void main(String[] args) {
		/*
		// exercise 1
		ArrayList al = new ArrayList();
		al.add(0, 5);
		al.add(1, 2);
		al.add(1, 7);
		al.add(0, 1);
		al.print();
		System.out.print(al.remove(1) + " ");
		al.print();
		al.add(0, 4);
		al.print();
		System.out.print(al.remove(10) + " ");
		al.print();
		System.out.print(al.remove(3) + " ");
		al.print();
		*/
		
		// exercise2
		LinkedList nl = new LinkedList();
		nl.addLast("A");
		nl.addLast("B");
		nl.addLast("C");
		nl.addLast("D");
		nl.addLast("E");
		nl.addLast("F");
		nl.addLast("G");
		nl.addLast("H");
		nl.addLast("I");
		nl.printAllNodes();
		nl.addBefore(2, "a");
		nl.addBefore(2, "b");
		nl.printAllNodes();
		nl.addBefore(10, "c");
		nl.printAllNodes();
	}
}