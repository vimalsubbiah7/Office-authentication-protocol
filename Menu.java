import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;


public class Menu extends Thread {
	public void run() {
		String name;
		String id;
		String dep;
		String doj;
		Employee  employee= new Employee();
		synchronized(employee){
			Scanner sc = new Scanner(System.in);
			System.out.println("\t\t Welcome\n Please enter your \n Name, \n ID, \n Department \n Date of joining: \n");
			name=sc.nextLine();
			id=sc.nextLine();
			dep=sc.nextLine();
			doj=sc.nextLine();
			employee.empinfo(name, id, dep, doj);
			boolean c1, c2;
			c1=employee.ValidateDOJ();
			c2=employee.ValidateID();
			if(c1!=true)
			{
			do
			{
				System.out.println("\nInvalid Date of joining! Please enter again!");
				doj=sc.nextLine();
				employee.empinfo(name, id, dep, doj);
				c1=employee.ValidateDOJ();
			}while(c1!=true);
			}
			
			if(c2!=true)
			{
				do
				{
				System.out.println("\nInvalid ID! Please enter again!");
				id=sc.nextLine();
				employee.empinfo(name, id, dep, doj);
				c2=employee.ValidateID();
				}while(c2!=true);
			}
			if(c1==true&&c2==true)
			{	
			int c=employee.checkdep();
			if(c==0)
			{
				System.out.println("\nUnauthorised User!!\n");
				File file= new File("Unauthorised.txt");
				try
				{
				BufferedWriter writer=new BufferedWriter(new FileWriter(file, true));
				String str;
				str="\n"+name+" "+id+" "+dep+" "+doj+" ";
				writer.write(str);
				writer.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Authorization Complete");
				File file= new File("Authorised.txt");
				try
				{
				BufferedWriter writer=new BufferedWriter(new FileWriter(file, true));
				String str;
				str="\n"+name+" "+id+" "+dep+" "+doj+" ";
				writer.write(str);
				writer.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
			
			
		}
	}

}