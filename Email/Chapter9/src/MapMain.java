
public class MapMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map m = new Map();
		System.out.println("Output\t| Map");
		System.out.println("================================================");
		System.out.println(m.isEmpty() + "\t| " + m.getMap());
		System.out.println(m.put(5, "A") + "\t| " + m.getMap());
		System.out.println(m.put(7, "B") + "\t| " + m.getMap());
		System.out.println(m.put(2, "C") + "\t| " + m.getMap());
		System.out.println(m.put(8, "D") + "\t| " + m.getMap());
		System.out.println(m.put(2, "E") + "\t| " + m.getMap());
		System.out.println(m.get(7) + "\t| " + m.getMap());
		System.out.println(m.get(4) + "\t| " + m.getMap());
		System.out.println(m.get(2) + "\t| " + m.getMap());
		System.out.println(m.size() + "\t| " + m.getMap());
		System.out.println(m.remove(5) + "\t| " + m.getMap());
		System.out.println(m.remove(2) + "\t| " + m.getMap());
		System.out.println(m.remove(2) + "\t| " + m.getMap());
		System.out.println(m.isEmpty() + "\t| " + m.getMap());
	}

}
