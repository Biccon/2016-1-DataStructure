
public class bubblesort {
	public static void main(String[] args){
		int arr[] = { 5,1,6,3,2 };
		print(arr);
		bubbleSort(arr);
		print(arr);
	}
	
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr.length-1;j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	public static void print(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
