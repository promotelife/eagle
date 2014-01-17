package com.eagle.crawler;
  
import java.io.*; 
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Crawl {
	public String content;
	 
	 public  void getContent(String urlStr)
	 { 
		try {
			 String urlEncode = new String();		 
			  URL url;
				url = new URL(urlStr);
			  URLConnection conn=url.openConnection();
//			  conn.setRequestProperty("User-Agent","Mozilla/4.0 " +  
//	                  "(compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 2.0.50727)");  
			  conn.connect();
			  urlEncode = conn.getContentEncoding();
			  if (urlEncode == null)
			  {
				  urlEncode=getCharset(conn.getContentType());
			  }
	
//			  BufferedReader bufin=new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//			  BufferedReader bufin=new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			  InputStream in= conn.getInputStream(); 
	
	          System.out.println(urlEncode);  
//	          System.out.println("a");  
			  ByteArrayOutputStream baos = convertBAOS(conn.getInputStream());
			  InputStream in1= new ByteArrayInputStream(baos.toByteArray());
			  InputStream in2= new ByteArrayInputStream(baos.toByteArray());
	
//	          System.out.println("b");  
	 
			  String line=null;
			  if  (urlEncode == null)
			  {
				  BufferedReader bufin=new BufferedReader(new InputStreamReader(in1));
				  
				  String reg_charset = "<meta[^>]*?charset=([a-z|A-Z|0-9]*[\\-]*[0-9]*)[\\s|\\S]*";
				  Pattern p = Pattern.compile(reg_charset);  
				  while((line=bufin.readLine())!=null){  
					  Matcher m = p.matcher(line);  
					  
					  if (m.find()) {   
				            urlEncode = m.group(1);     
				            break;
				        } 
				  }  
			  }
	          System.out.println(urlEncode);    
//	          按指定编码读取流
			  line=null; 
			  BufferedReader  bufin2=new BufferedReader(new InputStreamReader(in2,urlEncode));
			  while((line=bufin2.readLine())!=null){ 
			    System.out.println(line); 
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	 }
	 
	 public String getCharset(String _type)
	 {
		 String encode=null;
		 String sArray[] =_type.split(";"); 

		 for(int i=0;i<sArray.length;i++)
		 {
			 	 if(sArray[i].indexOf("charset")>0)
			 	 {
			 		encode=sArray[i].split("=")[1];
			 	 }
			  
		 }
		 return encode;
	 }
 /*
	  * 生成字节流以便复制输入流
	  * InputStream is1 = new ByteArrayInputStream(baos.toByteArray()); 
	  * 
  */
	 public ByteArrayOutputStream convertBAOS(InputStream input)
	 {	
		 ByteArrayOutputStream baos = new ByteArrayOutputStream();
		   
		    try {
		    	byte[] buffer = new byte[40960];
			    int len;
				while ((len = input.read(buffer)) > -1 ) {
				    baos.write(buffer, 0, len);
				}
			    baos.flush();
			} catch (IOException e) { 
				e.printStackTrace();
			}
	 
		    return baos;
	 }
}
