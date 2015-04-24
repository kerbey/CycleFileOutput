package cyclefileoutput;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cycle
{
	private double numberOfWheel, weight;
	public Cycle(double numberOfWheel, double weight)
	{//values are going through this method first before going to the Cycle and toString next
		this.numberOfWheel=numberOfWheel;
		this.weight=weight;	
		System.out.println("number of wheel(s)="+this.numberOfWheel+
				" weight="+this.weight);
	}
	public Cycle()
	{
		this(100.0, 1000.0);
	}
	public String ToString()
	{
		String  CycleFile="Cycle.txt";
		PrintWriter textStream =Cycle.createTextWrite(CycleFile);
		{	//print message onto file
			textStream.println("Inside the ToString method we have: the number of wheels are \n"
					+this.numberOfWheel+" and the weight is "+this.weight);			
		}
		textStream.close(); // Close file after writing into it
		Scanner scanFile = Cycle.createTextRead(CycleFile);// scan a file
		scanFile.close();
		return "Inside the ToString method we have: the number of wheels are \n"
				+this.numberOfWheel+" and the weight is "+this.weight;
	}
	private static Scanner createTextRead(String b)
	{
		Scanner textFile = null;
		try
		{
			textFile = new Scanner(new FileInputStream(new File(b)));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found "+b.toString());
			System.out.println("or could not be opened."+b.toString());
		}
		return textFile;
	}
	private static PrintWriter createTextWrite(String b)
	{
		PrintWriter TStream = null;
		try
		{
			TStream = new PrintWriter(new FileOutputStream(b));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error opening the file in createTextWrite "+b.toString());
			System.exit(0);
		}
		return TStream;
	}
}