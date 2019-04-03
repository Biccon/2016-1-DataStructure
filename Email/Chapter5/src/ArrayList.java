
public class ArrayList {
	private int arr[];
	private int i;
	
	public ArrayList(){
		arr = new int[128];
		for(int k=0;k<arr.length;k++){
			arr[k]=0;
		}
		i = 0;
		System.out.println("Array is initialized");
	}
	public int size(){
		return i;
	}
	public boolean isEmpty(){
		return (i==0)?true:false;
	}
	public boolean add(int index, int num){
		if(size() >= arr.length){
			System.out.println("FULL");
			return false;
		} else {
			if(index > i || index < 0){
				System.out.println("Invalid");
				return false;
			} else if(index < i){
				for(int k=i;k>=index;k--){ // 값 복사
					arr[k+1] = arr[k];
				}
			}
			arr[index] = num;
			i++;
			return true;
		}
	}
	public int remove(int index){
		int temp = arr[index];
		if(index > i){
			System.out.println("Invalid");
			return -1;
		} else if(index < i || index < 0){
			for(int k=index;k<i;k++){ // k<i-1?? k<i??
				arr[k] = arr[k+1];
			}
		}
		arr[i] = 0;
		i--;
		return temp;
	}
	public int get(int index){
		if(index > i  || index < 0){
			System.out.println("invalid");
			return -1;
		}
		int temp = arr[index];
		return temp;
	}
	public boolean set(int index, int num){
		if(index > i || index < 0){
			return false;
		}
		return true;
	}
	public void print(){
		System.out.print("(");
		for(int k=0;k<i;k++){
			System.out.print(arr[k] + " ");
		}
		System.out.println(")");
	}
	/*
	 * add
	 * get
	 * set
	 * remove
	 * size
	 * isEmpty
	 * array
	 */
}
