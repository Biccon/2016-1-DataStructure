
public class Main {

	public static void main(String[] args) {
		LinkedList nl = new LinkedList();
		char[] name = {'K', 'i', 'm', 'D', 'o', 'n', 'g', 'E', 'o', 'n'};
		for(int i=0;i<name.length;i++){
			nl.addLast(String.valueOf(name[i]));
		}
		nl.printAllNodes();
		System.out.println(">> addAfter(\"m\", \"-\");");
		nl.addAfter("m", "-");
		nl.printAllNodes();
		System.out.println(">> printRev();");
		nl.printRev();
		
		nl.printAllNodes();
		System.out.println(">> set(\"E\", \"H\");");
		nl.set("E", "H");
		nl.printAllNodes();
		System.out.println(">> remove(\"m\");");
		nl.remove("m");
		nl.printAllNodes();
		System.out.println(">> addBefore(\"u\", \"E\");");
		nl.addBefore("-", "ng");
		nl.printAllNodes();
		System.out.println(">> addLast(\"JJang\");");
		nl.addLast("JJang");
		nl.printAllNodes();
	}

}
