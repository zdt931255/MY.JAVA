import java.io.*;
import java.net.*;
public class lianxi1{
	public static void main(String[] args) throws Exception{
		ServerSocket ss =new ServerSocket(2000);
		while(true){
			// ServerSocket ss =new ServerSocket(2000);
			Socket s=ss.accept();
			new Thread(new ReceiveRunnable(s)).start();
		}	
	}	
}
class ReceiveRunnable implements Runnable{
	private Socket s;
	public ReceiveRunnable(Socket s){
		this.s=s;
	}
	public void run(){
		System.out.println(Thread.currentThread().getName()+"正在传入文件");
			BufferedReader br=null;
			PrintWriter pw=null;
		try{
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw=new PrintWriter(new FileOutputStream("D:/asd.txt"),true);
			String line="";
			while((line=br.readLine())!=null){
				pw.println(line);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if (pw!=null) {
					pw.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (pw!=null) {
					pw.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			try{
				if (s!=null) {
					s.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}
}