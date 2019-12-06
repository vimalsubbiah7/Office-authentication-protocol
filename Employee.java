import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Employee {
	String name;
	String id;
	String dep;
	String dob;
	public void empinfo(String name, String id, String dep, String dob)
	{
		this.name=name;
		this.id=id;
		this.dep=dep;
		this.dob=dob;
	}
	public int checkdep()
	{
		File file= new File("Department.txt");
		int flag=0;
		if(file.exists())
		{
		try {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String st;
			try {
				while((st=reader.readLine())!=null)
				{
					if(this.dep.equalsIgnoreCase(st))
					{
						flag=1;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
		else
			System.out.println("SORRY TRY AGAIN SOME TIME LATER");
		return flag;
	}
	public boolean ValidateID()
	{
		String[] arr=this.id.split("@", -1);
		
		if(arr[0].equals("google"))
		{
			
			int n=Integer.parseInt(arr[1]);
			if(n>0&&n<9999)
				return true;
		}
		
		return false;
	}
		
	public boolean ValidateDOB()
	{
		String[] arr=this.dob.split("/", -1);
		int dd=Integer.parseInt(arr[0]);
		int mm=Integer.parseInt(arr[1]);
		int yy=Integer.parseInt(arr[2]);
		
		if(dd>0&&dd<32)
		{
			if(mm>0&&mm<13)
			{
				if(yy>1920&&yy<2004)
					return true;
			}
		}
		return false;
	}
	
}