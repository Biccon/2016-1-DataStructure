import java.util.LinkedList;

public class Map {
	LinkedList<Entry> l;
	public Map(){
		this.l = new LinkedList<Entry>();
	}
	
	public int size(){
		return l.size();
	}
	
	public boolean isEmpty(){
		return this.size() == 0;
	}
	
	public Object get(int key){
		for(Entry e : l){
			if(e.getKey() == key){
				return e.getValue();
			}
		}
		return null;
	}
	
	public Object put(int key, Object value){
		Object tempObj = get(key);
		if(tempObj == null){
			l.add(new Entry(key, value));
		} else {
			for(Entry e : l){
				if(e.getKey() == key){
					tempObj = e.getValue();
					e.setValue(value);
					break;
				}
			}
		}
		return tempObj;
	}
	
	public Object remove(int key){
		for(Entry e : l){
			if(e.getKey() == key){
				l.remove(e);
				return e.getValue();
			}
		}
		return null;
	}
	
	public LinkedList<Integer> keys(){
		LinkedList<Integer> keys = new LinkedList<Integer>();
		for(Entry e : l){
			keys.add(e.getKey());
		}
		return keys;
	}
	
	public LinkedList<Object> values(){
		LinkedList<Object> values = new LinkedList<Object>();
		for(Entry e : l){
			values.add(e.getValue());
		}
		return values;
	}
	
	public LinkedList<Entry> entries(){
		return this.l;
	}
	
	public String getMap(){
		String temp = null;
		if(!this.isEmpty()) {
			temp = "";
			for(Entry e : l){
				temp += "(" + e.getKey() + "," + e.getValue() + ")";
				if(l.getLast() != e)
					temp += ", ";
			}
		}
		return temp;
	}
}
