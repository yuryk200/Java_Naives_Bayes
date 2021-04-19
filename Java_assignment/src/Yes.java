
public class Yes
{
	private String gender;
	private String job;
	private String partTime;
	private String address;
	private String subject;
	private String ceo;
	private FileProcessor file;
	
	public Yes(String gender, String job, String partTime, String address, String subject, String ceo) 
	{
		this.gender = gender;
		this.job = job;
		this.partTime = partTime;
		this.address = address;
		this.subject = subject;
		this.ceo = ceo;
	}
	

	public String getCeo() 
	{
		return ceo;
	}

	public void setCeo(String ceo) 
	{
		this.ceo = ceo;
	}

	public String getGender() 
	{
		return gender;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public String getJob() 
	{
		return job;
	}

	public void setJob(String job) 
	{
		this.job = job;
	}

	public String getPartTime() 
	{
		return partTime;
	}

	public void setPartTime(String partTime) 
	{
		this.partTime = partTime;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getSubject() 
	{
		return subject;
	}

	public void setSubject(String subject) 
	{
		this.subject = subject;
	}

	public String toString() 
	{
		return "Yes [gender=" + gender + ", job=" + job + ", partTime=" + partTime + ", address=" + address
				+ ", subject=" + subject + ", ceo=" + ceo + "]";
	}

	
	
	
	
}
