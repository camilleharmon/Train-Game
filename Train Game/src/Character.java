
public class Character {

	protected String name;
	protected String secondName;
	protected int location;
	protected int bond;
	
	protected Character(String n, String sN, int l, int b) {
		
		name = n;
		secondName = sN;
		location = l;
		bond = b;
	}

        public String getName()
		{
			return name;
		}

	public void setName(String name)
		{
			this.name = name;
		}
        public String getSecondName()
		{
			return secondName;
		}

	public void setSecondName(String secondName)
		{
			this.secondName = secondName;
		}
        public int getLocation()
		{
			return location;
		}

	public void setLocation(int location)
		{
			this.location = location;
		}
        public int getBond()
		{
			return bond;
		}

	public void setBond(int bond)
		{
			this.bond = bond;
		}
}
