
public class Setting implements ISetting{
	
	protected String name;
	protected int day;
	protected String description;
	
	Setting()
	{
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDescription()
		{
			return description;
		}

	public void setDescription(String description)
		{
			this.description = description;
		}


}
