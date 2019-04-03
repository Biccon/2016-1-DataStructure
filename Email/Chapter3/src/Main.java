public class Main {
	public static void main(String[] args) {
		/*
		Stack s = new Stack();
		s.push(100);
		s.push(3);
		s.push(10);
		s.size();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.isEmpty();
		s.push(7);
		s.isEmpty();
		*/
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(3);
		q.size();
		q.front();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.isEmpty();
	}
}
