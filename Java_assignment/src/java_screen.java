import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class java_screen extends JFrame implements ActionListener
{
	JButton addStudent, saveStudents, cancel, predict, predictx5, predictx10, predictx15;
	JPanel panel, panel1, panel2, p1, p2, p3;
	JTextArea gui;
	public boolean buttonclick = false;
	JList gender, ownsBusiness, partTime, address, subject, CEO;
	JLabel l1, l2, l3, l4, l5, l6, t1, t2, t3;
	JTextField prediction;
	public static int add1 = 1;
	public static String f1,f2,f3,f4,f5,f6;
	public static String[] rand;
	public int r1 = 1, r2 = 2, r3 = 3, r4 =4, r5 = 5, r6 = 6, r7 = 7, r8 = 8, r9 = 9, r10 = 10, r11 = 11, r12 = 12;
	
	public static double[] totalMale ,totalFemale, totalOwnsBus, totalNoBus, totalPT, totalNPT, totalRural, totalUrban, totalStudies, totalDontStudy;
    
    java_screen ()
    {
    	setSize(550,400);
		setLayout(new FlowLayout());
		

		panel = new JPanel(new FlowLayout());
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new FlowLayout());
		
		add(panel);
		add(panel1);
		add(panel2);
		
		l1 = new JLabel("Gender |");
		String x1[] = {"Male", "Female"};
		gender = new JList(x1);
		gender.setSelectedIndex(0);
		gender.setPreferredSize(new Dimension(50, 40));
		
		l2 = new JLabel("Parent Owns business |");
		String x2[] = {"Yes","No"};
		ownsBusiness = new JList(x2);
		ownsBusiness.setSelectedIndex(1);
		ownsBusiness.setPreferredSize(new Dimension(130, 40));
		
		l3 = new JLabel("Works part time |");
		String x3[] = {"Yes", "No"};
		partTime = new JList(x3);
		partTime.setSelectedIndex(1);
		partTime.setPreferredSize(new Dimension(90, 40));
		
		l4 = new JLabel("address |");
		String x4[] = {"Rural", "Urban"};
		address = new JList(x4);
		address.setSelectedIndex(0);
		address.setPreferredSize(new Dimension(60, 40));
		
		l5 = new JLabel("Does business |");
		String x5[] = {"Yes", "No"};
		subject = new JList(x5);
		subject.setSelectedIndex(1);
		subject.setPreferredSize(new Dimension(90, 40));
		
		l6 = new JLabel("Predicted CEO ");
		String x6[] = {"Yes", "No"};
		
		prediction = new JTextField();
		prediction.setToolTipText("Press predict button or type Yes or No");
		prediction.setPreferredSize(new Dimension(80, 20));
		
		panel.add(l1);
		panel1.add(gender);
		
		panel.add(l2);
		panel1.add(ownsBusiness);
		
		panel.add(l3);
		panel1.add(partTime);
		
		panel.add(l4);
		panel1.add(address);
		
		panel.add(l5);
		panel1.add(subject);
		
		panel.add(l6);
		panel1.add(prediction);
		
		addStudent = new JButton("add student");
		saveStudents = new JButton("show students");
		cancel = new JButton("cancel");
		predict = new JButton("predict");
		
		predict.addActionListener(this);
		addStudent.addActionListener(this);
		
		panel2.add(addStudent);
		panel2.add(saveStudents);
		panel2.add(cancel);
		panel2.add(predict);
		
		predict.doClick();
		
		setVisible(true);
		
		buttonclick = true;
		
    }
    
    void java_screen2 (int add1)
    {
    	if(add1 == 0)
    	{
    		//setSize(400,300);
        	//setLayout(new FlowLayout());
        	
        	p1 = new JPanel(new FlowLayout());
        	p2 = new JPanel(new FlowLayout());
        	p3 = new JPanel(new FlowLayout());
        	
        	add(p1);
        	add(p2);
        	add(p3);
        	
        	predictx5 = new JButton("add 5 random students");
        	predictx10 = new JButton("add 10 random students");
        	predictx15 = new JButton(" add 15 random students");
        	
        	predictx5.addActionListener(this);
        	predictx10.addActionListener(this);
        	predictx15.addActionListener(this);
        	
        	p1.add(predictx5);
        	p2.add(predictx10);
        	p3.add(predictx15);
        	
        	add1 = add1 + 1;
        	
        	setVisible(true);
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(this,"Buttons have already been added");
    	}
    }
    
    public void actionPerformed(ActionEvent e) 
	{
    	FileProcessor fileProcessor = new FileProcessor("MLdata2.txt", buttonclick);
    	List<Yes> data = fileProcessor.isCEO;
    	
    	if(e.getSource() == predict)
    	{
    		if(gender.getSelectedValue() == "Male")
    		{
    			totalMale = fileProcessor.calcMales();
    			
    			fileProcessor.PredictFutureYes(totalMale[0],"Male");
    			fileProcessor.PredictFutureNO(totalMale[1], "Male");
    			
    		}
    		else if(gender.getSelectedValue() == "Female")
    		{
    			totalFemale = fileProcessor.calcFemales();
    			
    			fileProcessor.PredictFutureYes(totalFemale[0],"Female");
    			fileProcessor.PredictFutureNO(totalFemale[1], "Female");
    		}
    		
    		if(ownsBusiness.getSelectedValue() == "Yes")
    		{
    			totalOwnsBus = fileProcessor.calcOwnsBusiness();
    			
    			fileProcessor.PredictFutureYes(totalOwnsBus[0],"1");
    			fileProcessor.PredictFutureNO(totalOwnsBus[1], "1");
    		}
    		else if(ownsBusiness.getSelectedValue() == "No")
    		{
    			totalNoBus = fileProcessor.calcNoBusiness();
    			
    			fileProcessor.PredictFutureYes(totalNoBus[0],"2");
    			fileProcessor.PredictFutureNO(totalNoBus[1],"2");
    		}
    		
    		if(partTime.getSelectedValue() == "Yes")
    		{
    			totalPT = fileProcessor.calcPartTime();
    			
    			fileProcessor.PredictFutureYes(totalPT[0],"3");
    			fileProcessor.PredictFutureNO(totalPT[1], "3");
    			
    		}
    		else if(partTime.getSelectedValue() == "No")
    		{
    			totalNPT = fileProcessor.calcNoPartTime();
    			
    			fileProcessor.PredictFutureYes(totalNPT[0],"4");
    			fileProcessor.PredictFutureNO(totalNPT[1], "4");
    			
    		}
    		
    		if(address.getSelectedValue() == "Rural")
    		{
    			totalRural = fileProcessor.calcRural();
    			
    			fileProcessor.PredictFutureYes(totalRural[0], "5");
    			fileProcessor.PredictFutureNO(totalRural[1], "5");
    			
    		}
    		else if(address.getSelectedValue() == "Urban")
    		{
    			totalUrban = fileProcessor.calcUrban();
    			
    			fileProcessor.PredictFutureYes(totalUrban[0], "6");
    			fileProcessor.PredictFutureNO(totalUrban[1], "6");
    		}
    		
    		if(subject.getSelectedValue() == "Yes")
    		{
    			totalStudies = fileProcessor.calcStudiedBusiness();
    			
    			fileProcessor.PredictFutureYes(totalStudies[0], "7");
    			fileProcessor.PredictFutureNO(totalStudies[1], "7");
    		}
    		else if(subject.getSelectedValue() == "No")
    		{
    			totalDontStudy = fileProcessor.calcDidntStudyBusiness();
    			
    			fileProcessor.PredictFutureYes(totalDontStudy[0], "8");
    			fileProcessor.PredictFutureNO(totalDontStudy[1], "8");
    		}
    		
    	 	String predictCEO;
        	
        	predictCEO = fileProcessor.predictTotal();
        	
        	if(predictCEO == "Yes")
        	{
        		prediction.setText("Yes");
        	}
        	else
        	{
        		prediction.setText("No");
        	}
    	}
    	
    	if(e.getSource() == addStudent)
    	{
    		add1 = add1 - 1;
    		
    		java_screen2(add1);
    	}
    	
    	if(e.getSource() == predictx5)
    	{
  
    		for(int i=0; i<5;i++)
    		{
    			int randint1 = (int)Math.floor(Math.random()*(r2-r1+1)+r1);
    			int randint2 = (int)Math.floor(Math.random()*(r4-r3+1)+r3);
    			int randint3 = (int)Math.floor(Math.random()*(r6-r5+1)+r5);
    			int randint4 = (int)Math.floor(Math.random()*(r8-r7+1)+r7);
    			int randint5 = (int)Math.floor(Math.random()*(r10-r9+1)+r9);
    			int randint6 = (int)Math.floor(Math.random()*(r12-r11+1)+r11);
    			
    			
    			if(randint1 == 1)
    			{
    				f1 = "Male";
    			}
    			else
    			{
    				f1 = "Female";
    			}
    			
    			if(randint2 == 3)
    			{
    				f2 = "Yes";
    			}
    			else
    			{
    				f2 = "No";
    			}
    			
    			if(randint3 == 5)
    			{
    				f3 = "Yes";
    			}
    			else
    			{
    				f3 = "No";
    			}
    			
    			if(randint4 == 7)
    			{
    				f4 = "Rural";
    			}
    			else
    			{
    				f4 = "Urban";
    			}
    			
    			if(randint5 == 9)
    			{
    				f5 = "Yes";
    			}
    			else
    			{
    				f5 = "No";
    			}
    			
    			if(randint6 == 11)
    			{
    				f6 = "Yes";
    				
    				fileProcessor.addNewYes(f1,f2,f3,f4,f5,f6);
    			}
    			else
    			{
    				f6 = "No";
    				
    				fileProcessor.addNewNo(f1,f2,f3,f4,f5,f6);
    			}
    			
    			//System.out.println(f1);
    		}
    	}
    		
    		if(e.getSource() == predictx10)
        	{
        		
        		for(int i=0; i<10;i++)
        		{
        			int randint1 = (int)Math.floor(Math.random()*(r2-r1+1)+r1);
        			int randint2 = (int)Math.floor(Math.random()*(r4-r3+1)+r3);
        			int randint3 = (int)Math.floor(Math.random()*(r6-r5+1)+r5);
        			int randint4 = (int)Math.floor(Math.random()*(r8-r7+1)+r7);
        			int randint5 = (int)Math.floor(Math.random()*(r10-r9+1)+r9);
        			int randint6 = (int)Math.floor(Math.random()*(r12-r11+1)+r11);
        			
        			
        			if(randint1 == 1)
        			{
        				f1 = "Male";
        			}
        			else
        			{
        				f1 = "Female";
        			}
        			
        			if(randint2 == 3)
        			{
        				f2 = "Yes";
        			}
        			else
        			{
        				f2 = "No";
        			}
        			
        			if(randint3 == 5)
        			{
        				f3 = "Yes";
        			}
        			else
        			{
        				f3 = "No";
        			}
        			
        			if(randint4 == 7)
        			{
        				f4 = "Rural";
        			}
        			else
        			{
        				f4 = "Urban";
        			}
        			
        			if(randint5 == 9)
        			{
        				f5 = "Yes";
        			}
        			else
        			{
        				f5 = "No";
        			}
        			
        			if(randint6 == 11)
        			{
        				f6 = "Yes";
        				
        				fileProcessor.addNewYes(f1,f2,f3,f4,f5,f6);
        			}
        			else
        			{
        				f6 = "No";
        				
        				fileProcessor.addNewNo(f1,f2,f3,f4,f5,f6);
        			}
        			
        			//System.out.println(f1);
        		}
    		
        	}
    	
    		if(e.getSource() == predictx15)
        	{
        		
        		for(int i=0; i<15;i++)
        		{
        			int randint1 = (int)Math.floor(Math.random()*(r2-r1+1)+r1);
        			int randint2 = (int)Math.floor(Math.random()*(r4-r3+1)+r3);
        			int randint3 = (int)Math.floor(Math.random()*(r6-r5+1)+r5);
        			int randint4 = (int)Math.floor(Math.random()*(r8-r7+1)+r7);
        			int randint5 = (int)Math.floor(Math.random()*(r10-r9+1)+r9);
        			int randint6 = (int)Math.floor(Math.random()*(r12-r11+1)+r11);
        			
        			
        			if(randint1 == 1)
        			{
        				f1 = "Male";
        			}
        			else
        			{
        				f1 = "Female";
        			}
        			
        			if(randint2 == 3)
        			{
        				f2 = "Yes";
        			}
        			else
        			{
        				f2 = "No";
        			}
        			
        			if(randint3 == 5)
        			{
        				f3 = "Yes";
        			}
        			else
        			{
        				f3 = "No";
        			}
        			
        			if(randint4 == 7)
        			{
        				f4 = "Rural";
        			}
        			else
        			{
        				f4 = "Urban";
        			}
        			
        			if(randint5 == 9)
        			{
        				f5 = "Yes";
        			}
        			else
        			{
        				f5 = "No";
        			}
        			
        			if(randint6 == 11)
        			{
        				f6 = "Yes";
        				
        				fileProcessor.addNewYes(f1,f2,f3,f4,f5,f6);
        			}
        			else
        			{
        				f6 = "No";
        				
        				fileProcessor.addNewNo(f1,f2,f3,f4,f5,f6);
        			}
        			
        			//System.out.println(f1);
        		}
    		
        	}
    	
	}
}