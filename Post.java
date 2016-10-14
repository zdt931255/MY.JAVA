import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Arrays;
public class Post{
	public static void main(String[] args) {

		String[] postStamp={"20160201","20160412","20160629","20160720","20160802","20160812"};
		int[] zan={12,44,78,1350,2300,23};
		String url="http://120.32.4.343:8080/login.jsp?name=yuann&&password=123456&&sex=men&&login=1472525131959";


		//获取用户信息
		int index=url.indexOf("?");
		String tmp=url.substring(index+1);
		String[] tmpArr=tmp.split("&&");//name=yuann,password=123456,sex=men,login=1470277690256
		String[] userInfo=new String[tmpArr.length];		
		for (int i=0; i<tmpArr.length; i++) {
			String str=tmpArr[i];
			int index1=str.indexOf("=");
		    userInfo[i]=str.substring(index1+1);
		}


		//用户登录时间格式化
		long time=Long.parseLong(userInfo[userInfo.length-1]);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String loginStr=sdf.format(time);
		System.out.println("用户名:"+userInfo[0]+" 登录时间："+loginStr);


		//计算帖子过期的数量
		Calendar c=Calendar.getInstance();//获取当前时间
		int currentDayOfYear=c.get(Calendar.DAY_OF_YEAR);//当前时间在一年中的第几天  

		String[] newPostStamp=null;
		//通过计数器的思想来实现数组的大小的动态定义
		int count=0;
		for (int i=0;i<postStamp.length ;i++ ) {			
			String postTime=postStamp[i];
			int dayOfYear=getDayOfYear(postTime);
			if((currentDayOfYear-dayOfYear)>100){
				count++;
			}						
		}
		//拷贝数组的第一种方式
		newPostStamp=Arrays.copyOfRange(postStamp,count,postStamp.length);//将数组拷贝到一个新的数组中
		//拷贝数组的第二种方式
		// newPostStamp=new String[count];
		// for (int i=0;i<count; i++) {
		// 	newPostStamp[i]=postStamp[postStamp.length-count+i];
		// 	System.out.println(newPostStamp[i]+" ");
		// }
		//打印筛选过后的数组
		for (int i=0; i<newPostStamp.length;i++ ) {
			System.out.println(newPostStamp[i]);
		}


		//点赞最大值下标的获取
		int[] newZan=Arrays.copyOfRange(zan,count,zan.length);
		int maxIndex=0;
		int max=newZan[0];
		for (int i=0;i<newZan.length;i++) {
			if(newZan[i]>max){
				max=newZan[i];
				maxIndex=i;
			}
		}

		System.out.println("点赞数量最大的帖子是："+newPostStamp[maxIndex]+"点赞数是："+newZan[maxIndex]);
	}

	/**
	*获取当前日期在一年中的第几天
	*/
	public static int getDayOfYear(String str){
		int year=Integer.parseInt(str.substring(0,4));
		int month=Integer.parseInt(str.substring(4,6))-1;
		int day=Integer.parseInt(str.substring(6));
		Calendar c=Calendar.getInstance();
		c.set(year,month,day);		
		// int dayOfYear=c.get(Calendar.DAY_OF_YEAR);
		// return dayOfYear;
		return c.get(Calendar.DAY_OF_YEAR);
	}
}