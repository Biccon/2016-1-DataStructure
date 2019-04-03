public class Stack {
	private int number[];
	private int index;
	private int size;
	private String name;
	public Stack(){
		this.number = new int[size];
		this.index = -1;
		this.size = 3;
		System.out.println("Stack initialized");
	}
	public Stack(String name, int size){
		this.number = new int[size];
		this.index = -1;
		this.name = name;
		this.size = size;
		System.out.println("Stack initialized");
	}
	public void push(int number){
		if(index == size - 1){
			System.out.println("FullStackException");
			return ;
		}
		this.index++;
		this.number[index] = number;
	}
	public int pop(){
		if(index == -1){
			System.out.println("EmptyStackException");
			return 0;
		}
		int number;
		number = this.number[index];
		for(int i=index;i<this.number.length;i++){
			this.number[i] = 0;
		}
		this.index--;
		return number;
	}
	public int top(){
		if(this.index == -1){
			System.out.println("EmptyStackException");
			return 0;
		}
		int number;
		number = this.number[index];
		return number;
	}
	public int size(){
		int size;
		size = this.index + 1;
		return size;
	}
	public boolean isEmpty(){
		if(this.index == -1){
			return true;
		} else {
			return false;
		}
	}
	public String printStack(){
		String temp = "";
		if(isEmpty()) 
			temp = "NULL";
		else {
			for(int i=0;i<=this.index;i++){
				temp += this.number[i] + " ";
			}			
		}
		return temp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}