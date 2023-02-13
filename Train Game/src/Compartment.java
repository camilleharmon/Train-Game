
public class Compartment extends Setting{

	protected boolean unlocked;
	
	public Compartment(String n, int d, boolean u)
		{
			name = n;
			day = d;
			unlocked = u;
		}
}
