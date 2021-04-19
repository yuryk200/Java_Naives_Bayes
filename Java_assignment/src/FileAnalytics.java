import java.util.ArrayList;

public class FileAnalytics 
{
	public double numOfMales;
	public double numOfFemales;
	public double numOfpartTime;
	public double numOfNpartTime;
	public double numOfJob;
	public double numOfNjob;
	public double numOfrural;
	public double numOfurban;
	public double numOfbusSub;
	public double numOfNbusSub;
	public double totalCEO;
	public double totalNceo;
	
	public FileAnalytics() 
	{
		this.numOfMales = 0;
		this.numOfFemales = 0;
		this.numOfJob = 0;
		this.numOfNjob = 0;
		this.numOfpartTime = 0;
		this.numOfNpartTime = 0;
		this.numOfrural = 0;
		this.numOfurban = 0;
		this.numOfbusSub = 0;
		this.numOfNbusSub = 0;
		this.totalCEO = 0;
		this.totalNceo = 0;
	}
	
	public void countMale(String value)
	{
		if (value.contains("Male")) 
		{
			this.numOfMales += 1;
		}
	}
	
	public void countFemale(String value)
	{
		if (value.contains("Female")) 
		{
			this.numOfFemales += 1;
		}
	}
	
	public void countJob(String value)
	{
		if (value.contains("Yes"))
		{
			this.numOfJob += 1;
		}
	}
	
	public void countNoJob(String value)
	{
		if (value.contains("No"))
		{
			this.numOfNjob += 1;
		}
	}
	
	public void countPartTime(String value)
	{
		if (value.contains("Yes"))
		{
			this.numOfpartTime += 1;
		}
	}
	
	public void countNpartTime(String value)
	{
		if (value.contains("No"))
		{
			this.numOfNpartTime += 1;
		}
	}
	
	public void countRural(String value)
	{
		if (value.contains("Rural"))
		{
			this.numOfrural += 1;
		}
	}
	
	public void countUrban(String value)
	{
		if (value.contains("Urban"))
		{
			this.numOfurban += 1;
		}
	}
	
	public void countSubBus(String value)
	{
		if (value.contains("Yes"))
		{
			this.numOfbusSub += 1;
		}
	}
	
	public void countNsubBus(String value)
	{
		if (value.contains("No"))
		{
			this.numOfNbusSub += 1;
		}
	}
	
	public void countCEO(String value)
	{
		if (value.contains("Yes"))
		{
			this.totalCEO += 1;
		}
	}
	
	public void countNceo(String value)
	{
		if (value.contains("No"))
		{
			this.totalNceo += 1;
		}
	}
	
	public void analyseRecord(String[] attributes) 
	{
		countMale(attributes[0]);
		countFemale(attributes[0]);
		countJob(attributes[1]);
		countNoJob(attributes[1]);
		countPartTime(attributes[2]);
		countNpartTime(attributes[2]);
		countRural(attributes[3]);
		countUrban(attributes[3]);
		countSubBus(attributes[4]);
		countNsubBus(attributes[4]);
		countCEO(attributes[5]);
		countNceo(attributes[5]);
		
	}
	
	
}
