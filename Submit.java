import java.util.*;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
public class Submit
{
	static  Connection connection()
	{
	 Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","dawood23");
			if(con!=null)
			{
				//JOptionPane.showMessageDialog(null, "connection is successfull");
			}
	
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "connection is not successfull");
		}
		return con;
	
	}
	static void addWeb(String a) throws IOException
	{
		
		BufferedReader br=new BufferedReader(new FileReader("C:\\Windows\\System32\\drivers\\etc\\hosts"));
		PrintWriter kr=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts",true)));
		int flag=0,h=0;
		String a1="";
		while((a1=br.readLine())!=null)
		{
			h++;
			if(h>21)
			{
				flag++;
			}
		}
		
		kr.println("127.0.0."+(flag+1)+" "+a);
		kr.flush();
		kr.close();
		br.close();
	
	}
	static void removeWeb(String a) throws IOException
	{
		/////////////////
		String s="";
		int start=0;
		BufferedReader br=null;
		StringBuffer buf=new StringBuffer();
		StringBuffer buf1=new StringBuffer();
		br=new BufferedReader(new FileReader("C:\\Windows\\System32\\drivers\\etc\\hosts"));
		

		String a1=" ";
		int k=0,flag=0;
		k=0;
		while((a1=br.readLine())!=null)
		{
			
			flag++;
		if(flag<=21)
		{
			buf1.append(a1);
			buf1.append("%");
			
			
		}
		else
		{
			k++;
	buf.append(a1);
	buf.append("%");
		}
			
				}
	
		String[] b=buf.toString().split("%");
		String[] b1=buf1.toString().split("%");
		int found=0,i=0;
		 for(i=0;i<b.length;i++)
			{
				char[] a2=b[i].toCharArray();
				found=0;
				for(int j=0;j<a2.length;j++)
				{
					if(a2[j]==' ')
					{
						String che=b[i].substring(j+1);
						if(che.contains(a))
						{
							start=i;
							found=1;
							break;
						}
					}
					
				}
				if(found==1){
					break;
				}
			}
		 if(found==0)
			{
				System.out.println("not found");
			}
		 else
		 { 
				for(i=start;i<b.length-1;i++)
			{ int start1=0;
				
				char[] w=b[i].toCharArray();
				char[] w1=b[i+1].toCharArray();
				for(int q=0;q<w.length;q++)
				{
					if(w[q]==' ')
					{
						start=q+1;
						break;
					}
				}
				for(int q=0;q<w1.length;q++)
				{
					if(w1[q]==' ')
					{
						start1=q+1;
						break;
					}
				}
			b[i]=b[i].replaceAll(b[i].substring(start),b[i+1].substring(start1));
			}
				
		b[i]="";
		PrintWriter kr=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts")));
		for(i=0;i<b1.length;i++)
		{
			
			kr.println(b1[i]);
			kr.flush();
			
		}
		for(i=0;i<b.length;i++)
		{
			if(b[i]==""){continue;}
			kr.println(b[i]);
			kr.flush();
			
		}
		kr.close();
		 }
			
		 
br.close();

		////////////////
	}
   public static void main(String[] args) throws IOException, SQLException {
	Connection c=Submit.connection();
	Scanner s=new Scanner(System.in);
	String sql="select id from administrator";
	PreparedStatement pst=c.prepareStatement(sql);
	ResultSet rs=pst.executeQuery();
	int id=-1;
while(rs.next())
{
	id=rs.getInt(1);
}
if(id==-1)
{
	System.out.println("set admin id and password only you can adda and delete websites you want to block");
	System.out.println("------------------------------------------------------------------");
	System.out.print("enter id to register");
	id=s.nextInt();
	System.out.print("enter password to register");
	String pass=s.next();
	
	String sql1="insert into administrator(id,password)values(?,?)";
	PreparedStatement pst1=c.prepareStatement(sql1);
	pst1.setInt(1, id);
	pst1.setString(2, pass);
	pst1.execute();
	System.out.println("successfully registered");
	System.out.println("-------------------------------------------------");

}
else
{
System.out.print("1-admin 2-visitor");
int option=s.nextInt();
if(option==1)
{
	System.out.println("enter id :");
	int iden=s.nextInt();
	System.out.println("enter password:");
	String passkey=s.next();
	String sqlite="select * from administrator";
	PreparedStatement pst2=c.prepareStatement(sqlite);
	ResultSet rs1=pst2.executeQuery();
	int check1=0;
	String check2="";
while(rs1.next())
{
	check1=rs1.getInt(1);
	check2=rs1.getString(2);
}

if(iden==check1&&passkey.contains(check2))
{
	System.out.println("welcome");
	System.out.println("-------------------------------------------------------------");
	int i=0;
	while(i<10)
	{
	System.out.print("1-add 2-remove");
	
	int n=s.nextInt();
	if(n==1)
	{
		System.out.print("ener the website you want to block");
		String a=s.next();
		Submit.addWeb(a);
	}
	else
	{
		System.out.print("ener the website you want to remove from list");
		String a=s.next();
		Submit.removeWeb(a);
	}
	i++;
	}
}
else
{
	System.out.println("sorry.........wrong id and password");
}
}
}
	s.close();
}
}
