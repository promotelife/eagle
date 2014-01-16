import com.eagle.test.*;
import java.util.ArrayList;

public class jtest  
{
	public  static void main(String[] args) { 
		jcls jc =new jcls();
		jc.print();
		jc.LoggerTest(); 
		System.out.print("中文测试!");

		int len = 10;
		String[] ss =new String[len];

		System.out.println(ss.length);

		int i=100;
		assert i>0:i;



		ArrayList<Integer> list  = new ArrayList<>();
		list.add(3); 
		System.out.println(list.get(0).toString());
	} 
}