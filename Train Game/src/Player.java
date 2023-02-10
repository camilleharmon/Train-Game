
public class Player {
	
	protected String name;
	protected int money;
	protected int location;
	
	public Player(String n, int m, int l)
	{
		name = n;
		money = m;
		location = l;
	}

	public String getName()
		{
			return name;
		}

	public void setName(String name)
		{
			this.name = name;
		}

	public int getMoney()
		{
			return money;
		}

	public void setMoney(int money)
		{
			this.money = money;
		}

	public int getLocation()
		{
			return location;
		}

	public void setLocation(int location)
		{
			this.location = location;
		}
	

}
