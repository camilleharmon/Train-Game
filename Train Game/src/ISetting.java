
public interface ISetting {

	public String getName();
	
	public int getDay();
	
	public String getDescription();
	
	public boolean isUnlocked();

	public void setUnlocked(boolean unlocked);

	public void setName(String name);
	
	public void setDay(int day);

}
