import java.util.Scanner;

public class exercise1 {
	public static int recFactorial(int n){
		if(n==0) return 1;
		else return n*recFactorial(n-1);
	}

	public static void main(String[] args) {
		int n, result;
		Scanner scan = new Scanner(System.in);
		System.out.println("Input n : ");
		n = scan.nextInt();
		double begin, end;
		begin = System.nanoTime();
		result = recFactorial(n);
		end = System.nanoTime();
		System.out.println("Execution time : " + (end-begin) + ", result : " + result);
	}

}

