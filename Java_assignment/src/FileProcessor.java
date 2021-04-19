import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;


public class FileProcessor 
{
	static List<Yes> isCEO;
	public static double total = 0;
    public static double x1, x2, x3, x4, x5, x6, x7, x8, x9, x10;
    public static double yMales, nMales;
    public static double yFemales, nFemales;
    public static double yOB, yNOB;
    public static double yPT, yNPT;
    public static double yRural, yUrban;
    public static double yStudies, yNStudies;
    public static double nOB, nNOB;
    public static double nPT, nNPT;
    public static double nRural, nUrban;
    public static double nStudies, nNStudies;
    public static double y1, y2, y3, y4, y5, y6, y7, y8, y9, y10;
    public static double n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
    public static double c1 = 1, c2 = 1, c3 = 1, c4 = 1, c5 = 1;
    public static double v1 = 1, v2 = 1, v3 = 1, v4 = 1, v5 = 1;
    public static double ytotal , vtotal ;
    public static String ceoAttr;
	public String fileName;
	public static double[] temper = {0,0,0,0,0,0,0,0,0,0,0,0};
	//public static FileAnalytics yesAnalytics = new FileAnalytics();
	//public static FileAnalytics noAnalytics  = new FileAnalytics();
	public static double[] temper1 = {0,0,0,0,0,0,0,0,0,0,0,0};
	public static boolean buttonclick;
	
	public static void main(String args[])
	{
		//List<Yes> isCEO = readStudentsFromCSV("MLdata2.txt");
		
		java_screen myScreen = new java_screen();
	}
	
	public FileProcessor(String fileName, boolean isClicked) 
	{
		this.isCEO = readStudentsFromCSV("MLdata2.txt");
		this.buttonclick = isClicked;
	}
	
	public static List<Yes> readStudentsFromCSV(String fileName)
	{
		List<Yes> yesCEO = new ArrayList();
		List<No> noCEO = new ArrayList();
		FileAnalytics yesAnalytics = new FileAnalytics();
		FileAnalytics noAnalytics  = new FileAnalytics();
		FileAnalytics yesTestAnalytics  = new FileAnalytics();
		FileAnalytics noTestAnalytics  = new FileAnalytics();
		Path DataFile = Paths.get(fileName);
		
		try(BufferedReader b1 = Files.newBufferedReader(DataFile))
		{
			String line = b1.readLine();
			
			while(line != null)
			{
				String[] attributes = line.split(",");
				ceoAttr = attributes[attributes.length-1];
				
				if (ceoAttr.contains("Yes"))
				{
					Yes CEO = createCEO(attributes);
					yesCEO.add(CEO);
					yesAnalytics.analyseRecord(attributes);
				}
				else
				{
					No nCEO = createnCEO(attributes);
					noCEO.add(nCEO);
					noAnalytics.analyseRecord(attributes);
				}
				
				line = b1.readLine();
			}
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		int numOfYesCEO = yesCEO.size();
		int testYesDataSize = (numOfYesCEO/100)*30;

		for (int i = 0; i < testYesDataSize; i++) 
		{
			yesTestAnalytics.analyseRecord(yesCEO.get(i).toString().split(","));
		}
		
		int numOfNoCEO = noCEO.size();
		int testNoDataSize = (numOfNoCEO/100)*30;

		for (int i = 0; i <= testNoDataSize; i++) 
		{
			noTestAnalytics.analyseRecord(noCEO.get(i).toString().split(","));
		}
	
		System.out.println(buttonclick);
		if (buttonclick == true) 
		{
		  analyseRecords(yesAnalytics, noAnalytics); // 100%
		}
		else 
		{
          analyseRecords(yesTestAnalytics, noTestAnalytics); //30%
		}
		
        
        
		return yesCEO;
	}
	
	public static void analyseRecords(FileAnalytics yesAnalytics, FileAnalytics noAnalytics) 
	{
		yesAnalytics.numOfMales += temper[0];
		yesAnalytics.numOfFemales += temper[1];
		yesAnalytics.numOfJob += temper[2];
		yesAnalytics.numOfNjob += temper[3];
		yesAnalytics.numOfpartTime += temper[4];
		yesAnalytics.numOfNpartTime += temper[5];
		yesAnalytics.numOfrural += temper[6];
		yesAnalytics.numOfurban += temper[7];
		yesAnalytics.numOfbusSub += temper[8];
		yesAnalytics.numOfNbusSub += temper[9];
		yesAnalytics.totalNceo += temper[11];
		noAnalytics.numOfMales += temper1[0];
		noAnalytics.numOfFemales += temper1[1];
		noAnalytics.numOfJob += temper1[2];
		noAnalytics.numOfNjob += temper1[3];
		noAnalytics.numOfpartTime += temper1[4];
		noAnalytics.numOfNpartTime += temper1[5];
		noAnalytics.numOfrural += temper1[6];
		noAnalytics.numOfurban += temper1[7];
		noAnalytics.numOfbusSub += temper1[8];
		noAnalytics.numOfNbusSub += temper1[9];
		noAnalytics.totalCEO += temper1[10];
		noAnalytics.totalNceo += temper1[11];
		
	total = noAnalytics.totalNceo + yesAnalytics.totalCEO;
	x1 = (noAnalytics.numOfFemales + yesAnalytics.numOfFemales)/total;
	x2 = (noAnalytics.numOfJob + yesAnalytics.numOfJob)/total;
	x3 = (noAnalytics.numOfpartTime + yesAnalytics.numOfpartTime)/total;
	x4 = (noAnalytics.numOfrural + yesAnalytics.numOfrural)/total;
	x5 = (noAnalytics.numOfbusSub + yesAnalytics.numOfbusSub)/total;
	x6 = (noAnalytics.numOfMales + yesAnalytics.numOfMales)/total;
	x7 = (noAnalytics.numOfNjob + yesAnalytics.numOfNjob)/total;
	x8 = (noAnalytics.numOfNpartTime + yesAnalytics.numOfNpartTime)/total;
	x9 = (noAnalytics.numOfurban + yesAnalytics.numOfurban)/total;
	x10 = (noAnalytics.numOfNbusSub + yesAnalytics.numOfNbusSub)/total;
	
	yMales = yesAnalytics.numOfMales/yesAnalytics.totalCEO;
	nMales = noAnalytics.numOfMales/noAnalytics.totalNceo;
	
	yFemales = yesAnalytics.numOfFemales/yesAnalytics.totalCEO;
	nFemales = noAnalytics.numOfFemales/noAnalytics.totalNceo;
	
	yOB = yesAnalytics.numOfJob/yesAnalytics.totalCEO;
	nOB = noAnalytics.numOfJob/noAnalytics.totalNceo;
	
	yNOB = yesAnalytics.numOfNjob/yesAnalytics.totalCEO;
	nNOB = noAnalytics.numOfNjob/noAnalytics.totalNceo;
	
	yPT = yesAnalytics.numOfpartTime/yesAnalytics.totalCEO;
	nPT = noAnalytics.numOfpartTime/noAnalytics.totalNceo;
	
	yNPT = yesAnalytics.numOfNpartTime/yesAnalytics.totalCEO;
	nNPT = noAnalytics.numOfNpartTime/noAnalytics.totalNceo;
	
	yRural = yesAnalytics.numOfrural/yesAnalytics.totalCEO;
	nRural = noAnalytics.numOfrural/noAnalytics.totalNceo;
	
	yUrban = yesAnalytics.numOfurban/yesAnalytics.totalCEO;
	nUrban = noAnalytics.numOfurban/noAnalytics.totalNceo;
	
	yStudies = yesAnalytics.numOfbusSub/yesAnalytics.totalCEO;
	nStudies = noAnalytics.numOfbusSub/noAnalytics.totalNceo;
	
	yNStudies = yesAnalytics.numOfNbusSub/yesAnalytics.totalCEO;
	nNStudies = noAnalytics.numOfNbusSub/noAnalytics.totalNceo;
	
	
	System.out.println("numOfFemales: " + noAnalytics.numOfFemales + " numOfMales " + noAnalytics.numOfMales);
	System.out.println("numOfFemales: " + yesAnalytics.numOfFemales + " numOfMales " + yesAnalytics.numOfMales);
	System.out.println("Parents own a Business: " + noAnalytics.numOfJob + " Parents dont own a Business: " + noAnalytics.numOfNjob);
	System.out.println("Parents own a Business: " + yesAnalytics.numOfJob + " Parents dont own a Business: " + yesAnalytics.numOfNjob);
	System.out.println("Has a part time job: " + noAnalytics.numOfpartTime + " doesnt have a part time job: " + noAnalytics.numOfNpartTime);
	System.out.println("Has a part time job: " + yesAnalytics.numOfpartTime + " doesnt have a part time job: " + yesAnalytics.numOfNpartTime);
	System.out.println("Rural: " + noAnalytics.numOfrural + " Urban: " + noAnalytics.numOfurban);
	System.out.println("Rural: " + yesAnalytics.numOfrural + " Urban: " + yesAnalytics.numOfurban);
	System.out.println("Studies business: " + noAnalytics.numOfbusSub + " doesnt study business: " + noAnalytics.numOfNbusSub);
	System.out.println("Studies business: " + yesAnalytics.numOfbusSub + " doesnt study business: " + yesAnalytics.numOfNbusSub);
	System.out.println("Became an entrepenuer: " + noAnalytics.totalCEO + " didn't become an entrepenuer: " + noAnalytics.totalNceo);
	System.out.println("Became an entrepenuer: " + yesAnalytics.totalCEO + " Became an entrepenuer: " + yesAnalytics.totalNceo);
	System.out.println("total students: " + total);
	System.out.println("P(x1 = Females) = " + x1);
	System.out.println("P(x2 = Parents own business) = " + x2);
	System.out.println("P(x3 = Works part time) = " + x3);
	System.out.println("P(x4 = Rural) = " + x4);
	System.out.println("P(x5 = Studies business) = " + x5);
	}


	private static No createnCEO(String[] data1) 
	{
		String ngender = data1[0];
		String njob = data1[1];
		String npartTime = data1[2];
		String naddress = data1[3];
		String nsubject = data1[4];
		String nceo = data1[5];
		
		return new No(ngender, njob, npartTime, naddress, nsubject, nceo);	
	}

	private static Yes createCEO(String[] data) 
	{
		String gender = data[0];
		String job = data[1];
		String partTime = data[2];
		String address = data[3];
		String subject = data[4];
		String ceo = data[5];
		
		return new Yes(gender, job, partTime, address, subject, ceo);
	}
	
	public static double[] calcMales()
	{
		double[] males = {yMales, nMales};
		
		return males;
	}
	
	public static double[] calcFemales()
	{
		double[] females = {yFemales, nFemales};
		
		return females;
	}
	
	public static double[] calcOwnsBusiness()
	{
		double[] ownsBus = {yOB, nOB};
		
		return ownsBus;
	}
	
	public static double[] calcNoBusiness()
	{
		double[] noBus = {yNOB, nNOB};
		
		return noBus;
	}
	
	public static double[] calcPartTime()
	{
		double[] PT = {yPT, nPT};
		
		return PT;
	}
	
	public static double[] calcNoPartTime()
	{
		double[] NPT = {yNPT, nNPT};
		
		return NPT;
	}
	

	public static double[] calcRural()
	{
		double[] Rural = {yRural, nRural};
		
		return Rural;
	}
	
	
	public static double[] calcUrban()
	{
		double[] Urban = {yUrban, nUrban};
		
		return Urban;
	}
	
	
	public static double[] calcStudiedBusiness()
	{
		double[] Studied = {yStudies, nStudies};
		
		return Studied;
	}
	
	public static double[] calcDidntStudyBusiness()
	{
		double[] isntStudy = {yNStudies, nNStudies};
		
		return isntStudy;
	}
	
	public void PredictFutureYes(double t, String y)
	{
		//double count =  t;
		double ttotal = 1;
		String check = y;
		int delim = 0;
		
		
		if(check == "Male")
		{
			y1 = t;
			c1 = x6;
			delim = 1;
		}
		if(check == "Female")
		{
			y2 = t;
			c1 = x1;
			delim = 1;
		}
		
		if(check == "1")
		{
			y3 = t;
			c2 = x2;
			delim = 2;
		}
		if(check == "2")
		{
			y4 = t;
			c2 = x7;
			delim = 2;
		}
		if(check == "3")
		{
			y5 = t;
			c3 = x3;
			delim = 3;
		}
		
		if(check == "4")
		{
			y6 = t;
			c3 = x8;
			delim = 3;
		}
		
		if(check == "5")
		{
			y7 = t;
			c4 = x4;
			delim = 4;
		}
		
		if(check == "6")
		{
			y8 = t;
			c4 = x9;
			delim = 4;
		}
		
		if(check == "7")
		{
			y9 = t;
			c5 = x5;
			delim = 5;
		}
		
		if(check == "8")
		{
			y10 = t;
			c5 = x10;
			delim = 5;
		}
		
		double[] keep = {y1, y2, y3, y4, y5, y6, y7, y8, y9, y10};
		
		if(delim == 1)
		{
			for(int i = 0;i<2; i++)
			{
				if(keep[i] != 0)
				{
					ttotal = ttotal*keep[i];
				}
			}
		}
		
		if(delim == 2)
		{
			for(int i = 0;i<4; i++)
			{
				if(keep[i] != 0)
				{
					ttotal = ttotal*keep[i];
				}
			}
		}
		
		if(delim == 3)
		{
			for(int i = 0;i<6; i++)
			{
				if(keep[i] != 0)
				{
					ttotal = ttotal*keep[i];
				}
			}
		}
		
		if(delim == 4)
		{
			for(int i = 0;i<8; i++)
			{
				if(keep[i] != 0)
				{
					ttotal = ttotal*keep[i];
				}
			}
		}
		
		if(delim == 5)
		{
			for(int i = 0;i<10; i++)
			{
				if(keep[i] != 0)
				{
					ttotal = ttotal*keep[i];
				}
			}
		}
		
		System.out.println(ttotal);
		
		ttotal = ttotal/(c1*c2*c3*c4*c5);
		ytotal = ttotal;
		
		//System.out.println(c1*c2*c3*c4*c5);
		System.out.println(ytotal);
		
		//ttotal = 0;
		
		predictTotal();
	}
	
	
	public void PredictFutureNO(double d, String n) 
	{	
		double count1 = d;
		String check1 = n;
		double ntotal = 1;
		int delim1 = 0;
		
		if(check1 == "Male")
		{
			n1 = count1;
			v1 = x6;
			delim1 = 1;
		}
		if(check1 == "Female")
		{
			n2 = count1;
			v1 = x1;
			delim1 = 1;
		}
		
		if(check1 == "1")
		{
			n3 = count1;
			v2 = x2;
			delim1 = 2;
		}
		if(check1 == "2")
		{
			n4 = count1;
			v2 = x7;
			delim1 = 2;
		}
		if(check1 == "3")
		{
			n5 = count1;
			v3 = x3;
			delim1 = 3;
		}
		
		if(check1 == "4")
		{
			n6 = count1;
			v3 = x8;
			delim1 = 3;
		}
		
		if(check1 == "5")
		{
			n7 = count1;
			v4 = x4;
			delim1 = 4;
		}
		
		if(check1 == "6")
		{
			n8 = count1;
			v4 = x9;
			delim1 = 4;
		}
		
		if(check1 == "7")
		{
			n9 = count1;
			v5 = x5;
			delim1 = 5;
		}
		
		if(check1 == "8")
		{
			n10 = count1;
			v5 = x10;
			delim1 = 5;
		}
		
		double[] keep1 = {n1, n2, n3, n4, n5, n6, n7, n8, n9, n10};
		
		if(delim1 == 1)
		{
			for(int i = 0;i<2; i++)
			{
				if(keep1[i] != 0)
				{
					ntotal = ntotal*keep1[i];
				}
			}
		}
		
		if(delim1 == 2)
		{
			for(int i = 0;i<4; i++)
			{
				if(keep1[i] != 0)
				{
					ntotal = ntotal*keep1[i];
				}
			}
		}
		
		if(delim1 == 3)
		{
			for(int i = 0;i<6; i++)
			{
				if(keep1[i] != 0)
				{
					ntotal = ntotal*keep1[i];
				}
			}
		}
		
		if(delim1 == 4)
		{
			for(int i = 0;i<8; i++)
			{
				if(keep1[i] != 0)
				{
					ntotal = ntotal*keep1[i];
				}
			}
		}
		
		if(delim1 == 5)
		{
			for(int i = 0;i<10; i++)
			{
				if(keep1[i] != 0)
				{
					ntotal = ntotal*keep1[i];
				}
			}
		}
		
		ntotal = ntotal/(c1*c2*c3*c4*c5);
		vtotal = ntotal;
		
		System.out.println(vtotal);
		
		ntotal = 0;
		
		predictTotal();
		
		return;
	}
	
	public String predictTotal() 
	{
		double predictYes;
		double predictNo;
		String predict;
		
		predictYes = ytotal;
		predictNo = vtotal;
		
		if(predictYes > predictNo)
		{
			predict = "Yes";
		}
		else
		{
			predict = "No";
		}
		
		System.out.println(predict);
		
		predictYes = 0;
		predictNo = 0;
		
		y1 = 1;
		y2 = 1;
		y3 = 1;
		y4 = 1;
		y5 = 1;
		y6 = 1;
		y7 = 1;
		y8 = 1;
		y9 = 1;
		y10 = 1;
		
		n1 = 1;
		n2 = 1;
		n3 = 1;
		n4 = 1;
		n5 = 1;
		n6 = 1;
		n7 = 1;
		n8 = 1;
		n9 = 1;
		n10 = 1;
		
		return predict;
	}
	
	public void addNewYes(String f1, String f2, String f3, String f4, String f5, String f6)
	{
		
		
		System.out.println(f1);
		
		String temp1 = f1;
		String temp2 = f2;
		String temp3 = f3;
		String temp4 = f4;
		String temp5 = f5;
		String temp6 = f6;
		
		if(temp1 == "Male")
		{
			temper[0] += 1;
		}
		else
		{
			temper[1] += 1;
		}
		
		if(temp2 == "Yes")
		{
			temper[2] += 1;
		}
		else
		{
			temper[3] += 1;
		}
		
		if(temp3 == "Yes")
		{
			temper[4] += 1;
		}
		else
		{
			temper[5] += 1;
		}
		
		if(temp4 == "Rural")
		{
			temper[6] += 1;
		}
		else
		{
			temper[7] += 1;
		}
		
		if(temp5 == "Yes")
		{
			temper[8] += 1;
		}
		else
		{
			temper[9] += 1;
		}
		
		if(temp6 == "Yes")
		{
			temper[10] += 1;
		}
		else
		{
			temper[11] += 1;
		}
		
	}
	
	public void addNewNo(String f1, String f2, String f3, String f4, String f5, String f6)
	{
		
		String temp7 = f1;
		String temp8 = f2;
		String temp9 = f3;
		String temp10 = f4;
		String temp11 = f5;
		String temp12 = f6;
		
		if(temp7 == "Male")
		{
			temper1[0] +=  1;
		}
		else
		{
			temper1[1] += 1;
		}
		
		if(temp8 == "Yes")
		{
			temper1[2] += 1;
		}
		else
		{
			temper1[3] += 1;
		}
		
		if(temp9 == "Yes")
		{
			temper1[4] += 1;
		}
		else
		{
			temper1[5] += 1;
		}
		
		if(temp10 == "Rural")
		{
			temper1[6] += 1;
		}
		else
		{
			temper1[7] += 1;
		}
		
		if(temp11 == "Yes")
		{
			temper1[8] += 1;
		}
		else
		{
			temper1[9] += 1;
		}
		
		if(temp12 == "Yes")
		{
			temper1[10] += 1;
		}
		else
		{
			temper1[11] += 1;
		}
		
		
	}

}


