import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Nubmer of disk : ");
		
		int size;
		size = scan.nextInt();
		
		Stack s1 = new Stack("A", size);
		Stack s2 = new Stack("B", size);
		Stack s3 = new Stack("C", size);
		
		for(int i=0;i<size;i++){
			s1.push(i + 1);
		}
		
		HanoiTower h = new HanoiTower(s1, s2, s3);
		h.HanoiTower(size, s1, s2, s3);
		
		System.out.println("Number of movement : " + h.getCount());
	}

}