package jmeter.jmx.util;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class execLinux {
    //http://blog.csdn.net/xh16319/article/details/17302947
    public static Object exec(String cmd) {  
        try {  
            String[] cmdA = { "/bin/sh", "-c", cmd };  
            Process process = Runtime.getRuntime().exec(cmdA);  
            LineNumberReader br = new LineNumberReader(new InputStreamReader(  
                    process.getInputStream()));  
            String result = "";
            String line;  
         while ((line = br.readLine()) != null) {  
//                 System.out.println(line); 
                 if(parseReport.isSummary(line))//判断是不是Summary
                     result = line;
            }  
            return result;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
    
    public static void main(String[] args) {  
        String pwdString = exec("cd /usr/local/apache-jmeter-2.13/bin/ ;sh jmeter -n -t /Users/yangengzhe/Documents/云平台/物流_游客查询.jmx").toString();
        System.out.println(pwdString);
    }  
}
