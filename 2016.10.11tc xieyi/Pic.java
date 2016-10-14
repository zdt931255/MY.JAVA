import java.io.*;
import java.net.*;
public class Pic{
	public static void main(String[] args) throws Exception{
		URL url=new URL("http://172.30.31.152:8080/myweb/11.jpg");
		//URL url=new URL("http://att.img.xiushuang.com/allimg/141030/103Z61553-0.jpg");
		// URL url=new URL("http://b.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=92e00c9b8f5494ee8722081f15ce87c3/29381f30e924b899c83ff41c6d061d950a7bf697.jpg");
		URLConnection con=url.openConnection();
		InputStream in=con.getInputStream();
		FileOutputStream fos=new FileOutputStream("D:/13.jpg");
		byte[] b=new byte[1024*10];
		int len=0;
		while((len=in.read(b))!=-1){
			fos.write(b,0,len);
		}
		fos.close();
	}
}
class copyPic{

	public void pic(){

	}
}