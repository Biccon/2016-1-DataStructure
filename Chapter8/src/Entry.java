public class Entry {
	private int key;
	private Object value;
	public Entry(int key, Object data){
		this.key = key;
		this.value = data;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
}
