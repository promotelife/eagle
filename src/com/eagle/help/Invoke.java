package com.eagle.help;

/**
 * Created by qinyu on 14-1-14.
 */

import java.lang.reflect.Method;
public class Invoke {
    //动态调用方法
    //类名要指定路径
    //不可调用参数数量可变的方法

    //动态调用方法 指定对象
    public static Object invokeObject(Object owner,String methodName,Object[] args) throws Exception
    {
        return  invokeMethod(null, owner, methodName,false, args);
    }
    //动态调用方法 根据类名
    public static Object invokeClass(String className,String methodName,Object[] args) throws Exception
    {
        return  invokeMethod(className, null, methodName,false, args);
    }
    //动态调用方法 静态方法
    public static Object invokeStatic(String className,String methodName,Object args[]) throws Exception
    {
        return  invokeMethod(className, null, methodName,true, args);
    }
    private static Object invokeMethod(String className,Object owner,String methodName,boolean isStatic,Object args[]) throws Exception
    {

        Class<?>  ownerClass;
        //如果存在类名，按照类名装载一个类
        if (className != null)
        {
            ownerClass =Class.forName(className);
            //如果不是静态方法 还要生成实例
            if (!isStatic && owner == null)
            {
                owner = ownerClass.newInstance();
            }
        }
        else
        {
            ownerClass = owner.getClass();
        }

        Class[] argsClass = new Class[args.length];
        for(int i=0;i<args.length;i++)
        {
            argsClass[i]=args[i].getClass();
        }
        Method method = ownerClass.getMethod(methodName,argsClass);
        return  method.invoke(owner,args);
    }
}
