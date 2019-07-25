import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class WebsiteBlocker {
public static void main(String[] args) throws IOException {
	Scanner s=new Scanner(System.in);
	
		System.out.println("                      WELCOME TO WEBSITE BLOCKER                       ");
	System.out.println("---------------------------------------------------------------------");
	char c = 0;
	int n=0;
	do
	{
		int flag=0,k=0,start=0,i=0;
		StringBuffer buf=new StringBuffer();
		StringBuffer buf1=new StringBuffer();
		System.out.println("                Enter your option::1-add 2-delete 3-exit");
		System.out.println("---------------------------------------------------------------------");
	 n=s.nextInt();
	 BufferedReader read=new BufferedReader(new FileReader("try1.txt"));
	 PrintWriter write=new PrintWriter(new BufferedWriter(new FileWriter("try1.txt",true)));
	 switch(n)
	 {
	
	 case 1:
		

		 String a="";
		 
		 
		 
		 
		 while((a=read.readLine())!=null)
			{
				
				++flag;
				//System.out.println(flag);
			if(flag>22)
			{
				
				++k;
				//System.out.println(k);
			}
			
			}
		 //System.out.print("ok::"+k);
		 write.println("127.0.0."+(k+1)+" www.amazon.com");
		write.flush(); 
		
		 break;
	
	 case 2:
		 
	 
	//kr.println("127.0.0."+k+" www.helo.com");
	//kr.flush();

		 while((a=read.readLine())!=null)
			{
				
				//System.out.println(a);
				flag++;
			//	System.out.println(flag);
			if(flag<=21)
			{
				buf1.append(a);
				buf1.append("%");
				//kr.println(a);
			//	kr.flush();
				
			}
			else
			{
				k++;
		buf.append(a);
		buf.append("%");
			}
				
					}
			String k1="www.yahoo.com";
			//System.out.print(buf.toString());
			String[] b=buf.toString().split("%");
			//String[] b1=buf1.toString().split("%");
		// f=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts",true)));
		//f.println("\n127.0.0.1"+" "+"www.facebook.com");
			//f.close();
			/*for(int i=0;i<b.length;i++)
			{
				//kr.println(k1);
				System.out.println(b[i]);
				
			}*/
			int found=0;
			 for(i=0;i<b.length;i++)
				{
					char[] a2=b[i].toCharArray();
					found=0;
					for(int j=0;j<a2.length;j++)
					{
						if(a2[j]==' ')
						{
							//System.out.println(a[i].substring(j+1));
							String che=b[i].substring(j+1);
							if(che.contains(k1))
							{
								//System.out.println(b[i].substring(j+1));
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
					//System.out.print(a[i+1].substring(start1));
				b[i]=b[i].replaceAll(b[i].substring(start),b[i+1].substring(start1));
					//System.out.println(b[i]);
				}
					
			b[i]=" ";
				if(found==0)
				{
					System.out.println("not found");
				}

				for(i=0;i<b.length;i++)
				{
					//kr.println(k1);
					System.out.println(b[i]);
					
				}

	 ////////////////
		 break;
		 
	 }
	 System.out.println("---------------------------------------------------------------------");
		System.out.println("press y to continue or else press n");
		c=s.next().charAt(0);
		 read.close();
		 write.close();
	}while(c!='n');
	
	//write.close();
	s.close();
}
}
