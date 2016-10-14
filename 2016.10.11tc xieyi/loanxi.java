import java.io.*;
import java.net.*;
public class loanxi{
	public static void main(String[] args)throws Exception {
		Socket s =new Socket(InetAddress.getLocalHost(),2000);
		// Socket s =new Socket("home",2000);

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:/abc.txt")));
		PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
		String line="";
		while((line=br.readLine())!=null){
			pw.println(line);
		}
		s.shutdownOutput();
		pw.close();
		br.close();
		s.close();
	}	

}