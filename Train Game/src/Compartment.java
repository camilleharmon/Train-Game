
public class Compartment extends Setting{

	protected boolean unlocked;
	
	public Compartment(String n, int d, boolean u, String dd)
		{
			name = n;
			day = d;
			unlocked = u;
			description = dd;
		}

	public boolean isUnlocked()
		{
			return unlocked;
		}

	public void setUnlocked(boolean unlocked)
		{
			this.unlocked = unlocked;
		}
	
}
