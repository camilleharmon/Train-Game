
public class MyObject {
	
	protected String name;
	protected int location;
	protected int num;
	
	protected MyObject(String n, int l, int nn) {
		
		name = n;
		location = l;
		num = nn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
///