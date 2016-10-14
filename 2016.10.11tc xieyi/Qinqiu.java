import java.io.*;
import java.net.*;
public class Qinqiu{
	public static void main(String[] args)throws Exception {
		Socket s=new Socket("172.30.31.152",8080);
		OutputStream os=s.getOutputStream();
		PrintWriter pw=new PrintWriter(os,true);
		pw.println("GET http://172.30.31.152:8080/myweb/index.html HTTP/1.1");
		pw.println("Host: 172.30.31.152:8080");
		pw.println("Accept: text/html");
		pw.println("Accept-Encoding: gzip, deflate, sdch");
		pw.println("Accept-Language: zh-CN,zh;q=0.8");
		pw.println();
		InputStream in=s.getInputStream();
		byte[] b=new byte[1024];
		int len=in.read(b);
		System.out.println(new String(b,0,len));

		PrintWriter pw1=new PrintWriter(new FileOutputStream("D:/ass.txt"),true);
		pw1.println(new String(b,0,len));
		if (in.available()==0) {
			s.close();
		}
		
	}
}