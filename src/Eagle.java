import java.util.ArrayList;

import com.eagle.crawler.Crawl;
import com.eagle.help.Compare;
import com.eagle.help.Invoke;
import com.eagle.mysql.*;
import org.apache.log4j.Logger;
public class Eagle {
	public static void main(String args[])
	{
/*
		Crawl cl = new Crawl();
		cl.getContent("http://www.genius.com.cn");
		cl.getContent("http://www.chengxuyuans.com/code/java/62090.html");
		cl.getContent("http://www.cnblogs.com/fzll/p/3400558.html");
		cl=null;
*/
		int len = 10;
		String[] ss =new String[len];

		System.out.print(ss.length);
		ArrayList<Integer> list  = new ArrayList<>();
		list.add(3);
		System.out.println(list.get(0).toString());

		System.out.println(Compare.max(234, 456, 234.5, 2456, 67));

        try{
            //反射调用指定类名和方法
            Invoke.invokeStatic("com.eagle.help.Compare", "print", new Object[]{"Hello World!"});
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("中文 测 试  ");

        Logger log= Logger.getLogger("test");
/*
		Mysql my = new Mysql();
		my.setDatabase("pgenius");
		my.getData("select * from pgenius.NEWS_MAIN limit 20;");
		my = null;
*/
	}

    public void print()
    {
        System.out.println("hello");
    }
}
