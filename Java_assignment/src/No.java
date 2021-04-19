
public class No 
{
	private String Ngender;
	private String Nbusiness;
	private String NpartTime;
	private String Naddress;
	private String Nsubject;
	private String Nceo;
	
	public No(String ngender, String nbusiness, String npartTime, String naddress, String nsubject, String nceo) 
	{
		Ngender = ngender;
		Nbusiness = nbusiness;
		NpartTime = npartTime;
		Naddress = naddress;
		Nsubject = nsubject;
		Nceo = nceo;
	}

	public String getNgender() 
	{
		return Ngender;
	}

	public void setNgender(String ngender) 
	{
		Ngender = ngender;
	}

	public String getNbusiness() 
	{
		return Nbusiness;
	}

	public void setNbusiness(String nbusiness) 
	{
		Nbusiness = nbusiness;
	}

	public String getNpartTime() 
	{
		return NpartTime;
	}

	public void setNpartTime(String npartTime) 
	{
		NpartTime = npartTime;
	}

	public String getNaddress() 
	{
		return Naddress;
	}

	public void setNaddress(String naddress) 
	{
		Naddress = naddress;
	}

	public String getNsubject() 
	{
		return Nsubject;
	}

	public void setNsubject(String nsubject) 
	{
		Nsubject = nsubject;
	}

	public String getNceo() 
	{
		return Nceo;
	}

	public void setNceo(String nceo) 
	{
		Nceo = nceo;
	}

	@Override
	public String toString() 
	{
		return "No [gender=" + Ngender + ", business=" + Nbusiness + ", partTime=" + NpartTime + ", address="
				+ Naddress + ", subject=" + Nsubject + ", ceo=" + Nceo + "]";
	}
	
	
	
}
