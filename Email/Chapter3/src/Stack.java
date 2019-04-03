public class Stack {
	private int number[];
	private int index;
	private int size = 100;
	public Stack(){
		number = new int[size];
		index = -1;
		System.out.println("Stack initialized");
	}
	public void push(int number){
		if(index == size - 1){
			System.out.println("FullStackException");
			return ;
		}
		index++;
		this.number[index] = number;
		System.out.println("(" + index + ", " + number + ")");
	}
	public int pop(){
		if(index == -1){
			System.out.println("EmptyStackException");
			return 0;
		}
		int number;
		number = this.number[index];
		index--;
		System.out.println("(" + number + ")");
		return number;
	}
	public int top(){
		if(index == -1){
			System.out.println("EmptyStackException");
			return 0;
		}
		int number;
		number = this.number[index];
		System.out.println("(" + number + ")");
		return number;
	}
	public int size(){
		int size;
		size = this.index + 1;
		System.out.println("size : " + size);
		return size;
	}
	public boolean isEmpty(){
		if(this.index == -1){
			System.out.println("(true)");
			return true;
		} else {
			System.out.println("(false)");
			return false;
		}
	}
}
