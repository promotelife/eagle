package com.eagle.help;

/**
 * Created by qinyu on 14-1-14.
 */
public class Compare{
    //参数数量可变方法
    //compare with a lot of variables
    public static double max(double... values)
    {
        double largest = Double.MIN_VALUE;
        for(double v:values) if (v>largest)largest=v;
        return largest;
    }
    public static double min(double... values)
    {
        double smallest = Double.MAX_VALUE;
        for(double v:values) if (v<smallest)smallest=v;
        return smallest;
    }

    public static void print(String strtt)
    {
        System.out.println(strtt);
    }
}
