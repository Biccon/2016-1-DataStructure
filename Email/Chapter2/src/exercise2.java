import java.util.Scanner;

public class exercise2 {
	public static int[] LinearFib(int n){
		int arr[] = new int[2];
		if(n <= 1){
			arr[0] = n;
			arr[1] = 0;
		} else {
			int temp;
			arr = LinearFib(n - 1);
			temp = arr[0];
			arr[0] = arr[0] + arr[1];
			arr[1] = temp;
		}
		return arr;
	}
	/*
	 * 주석처리 했습니다.
	public static int LinearFib2(int n){
		if(n <= 1) return n;
		int prev = 0, curr = 1;
		int next = 0;
		for(int i=2;i<=n;i++){
			next = curr + prev;
			prev = curr;
			curr = next;
		}
		return next;
	}*/
	public static void main(String[] args) {
		int result, n;
		double begin, end;
		Scanner scan = new Scanner(System.in);
		System.out.print("Input : ");
		n = scan.nextInt();
		begin = System.nanoTime();
		result = LinearFib(n)[0];
		end = System.nanoTime();
		System.out.println("Execution time : " + (end-begin) + ", result : " + result);
	}

}
