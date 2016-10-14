import java.io.*;
import java.net.*;
public class CustomServer{
	public static void main(String[] args) throws Exception{
		ServerSocket ss=new ServerSocket(2000);
		
		
			Socket s=ss.accept();
			InputStream in=s.getInputStream();
			byte[] b=new byte[1024];
			int len=0;
			len=in.read(b);
			System.out.println(new String(b,0,len));
			
			
			PrintWriter pw=new PrintWriter(new FileOutputStream("D:/asd.txt"),true);
			
			pw.println(new String(b,0,len));
			
			s.close();
			ss.close();
		
		
	}
	
}