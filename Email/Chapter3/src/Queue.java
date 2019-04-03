public class Queue {
	private int[] number;
	private int index;
	private int size = 100;
	public Queue(){
		number = new int[size];
		index = -1;
		System.out.println("Queue initialized");
	}
	public void enqueue(int number){
		if(this.index == this.size - 1)
			return ;
		this.index++;
		this.number[index] = number;
		System.out.println("(" + index + ", " + number + ")");
	}
	public int dequeue(){
		if(this.index == -1){
			System.out.println("EmptyQueueException");
			return 0;
		}
		int number;
		number = this.number[0];
		for(int i=1;i<=this.index;i++){
			this.number[i-1] = this.number[i];
		}
		this.index--;
		System.out.println("(" + number + ")");
		return number;
	}
	public int front(){
		if(this.index == -1){
			System.out.println("EmptyQueueException");
			return 0;
		}
		int number;
		number = this.number[0];
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
	public void show(){
		for(int i=0;i<5;i++){
			System.out.println(this.number[i]);
		}
	}
}