package jmeter.jmx;

import org.omg.CORBA.PUBLIC_MEMBER;

import jmeter.jmx.pojo.summaryPojo;
import jmeter.jmx.util.execLinux;
import jmeter.jmx.util.parseReport;

public class jmeter {
    public static void main(String args[])
    {//16:46
        summaryPojo[] summarys = new summaryPojo[51];
        final String  ipadress = "192.168.191.1";
        for(int i=1;i<=1;i+=50)
        {
            int count = i;
            String cmd = "cd /usr/local/apache-jmeter-2.13/bin/ ;sh jmeter -n -t /Users/yangengzhe/Documents/云平台/物流_游客查询.jmx -Jthread="+count+" -Jipadress="+ipadress;
            summarys[1] = parseReport.parsePojo(execLinux.exec(cmd).toString());
            System.out.println("当"+count+"个用户并发时，吞吐率="+summarys[1].getThroughput());
        }
        
    }
}
