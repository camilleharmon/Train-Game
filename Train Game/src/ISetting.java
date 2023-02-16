
public interface ISetting {

	public String getName();
	
	public int getDay();
	
	public String getDescription();
	
	public boolean isUnlocked();

	public void setUnlocked(boolean unlocked);
}
