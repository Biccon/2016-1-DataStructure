public class HanoiTower {
	private int count;
	private Stack s1;
	private Stack s2;
	private Stack s3;
	
	public HanoiTower(Stack s1, Stack s2, Stack s3){
		this.count = 0;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	public void HanoiTower(int ring, Stack from, Stack temp, Stack to){
		if(ring == 1) {
			System.out.println(from.getName() + " -> " + to.getName());
			
			int pop = from.pop();
			to.push(pop);
			
			System.out.println("Stack 1 : " + this.s1.printStack());
			System.out.println("Stack 2 : " + this.s2.printStack());
			System.out.println("Stack 3 : " + this.s3.printStack());
			
			this.count ++;
		} else {
			HanoiTower(ring - 1, from, to, temp);
			HanoiTower(1, from, temp, to);
			HanoiTower(ring - 1, temp, from, to);
		}
	}
	
	public int getCount(){
		int temp;
		temp = this.count;
		this.count = 0;
		return temp;
	}
}