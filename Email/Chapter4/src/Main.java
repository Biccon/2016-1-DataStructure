import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

	static Stack s = new Stack();
	static Queue q = new LinkedList();
	public static void main(String[] args) {
		/*
		Main m = new Main();
		m.push(5);
		m.push(3);
		m.pop();
		m.push(7);
		m.pop();
		m.top();
		m.pop();
		m.pop();
		m.isEmpty();
		*/
		Main m = new Main();
		m.enqueue(5);
		m.enqueue(3);
		m.dequeue();
		m.enqueue(7);
		m.dequeue();
		m.front();
		m.dequeue();
		m.dequeue();
		m.isEmpty();
		
	}
	public void enqueue(Object o){
		q.offer(o);
		System.out.println("Output: - Front : " + getFront());
	}
	public void dequeue(){
		Object o = q.poll();
		String tmp;
		if(o == null)
			tmp = "err";
		else
			tmp = o + "";
		System.out.println("Output: " + tmp + " Front : " + getFront());
	}
	public void front(){
		Object o = getFront();
		String tmp;
		if(o == null)
			tmp = "-";
		else
			tmp = o + "";
		System.out.println("Output: " + tmp + " Front : " + getFront());
	}
	public void isEmpty(){
		System.out.println("Output: " + q.isEmpty() + " Front : " + getFront());
	}

	public String getFront(){
		return q.peek()!=null?q.peek()+"":"";
	}
	/*
	public String getStack(){
		String temp = "";
		for(int i=0;i<s.size();i++){
			temp += s.get(i) + " ";
		}
		return temp;
	}
	public void push(Object o) {
		s.push(o);
		System.out.println("Output : - Stack : " + getStack());
	}
	public void pop(){
		try {
			System.out.println("Output : " + s.pop() + " Stack : " + getStack());
		}catch (EmptyStackException e){
			System.out.println("Output : Err Stack : " + getStack());
		}
	}
	public void top(){
		try {
			System.out.println("Output : " + s.peek() + " Stack : " + getStack());
		}catch (EmptyStackException e){
			System.out.println("Output : Err Stack : " + getStack());
		}
	}
	public void isEmpty(){
		System.out.println("Output : " + s.isEmpty() + " Stack : " + getStack());
	}

	 */

}
