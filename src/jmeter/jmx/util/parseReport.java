package jmeter.jmx.util;

import jmeter.jmx.pojo.summaryPojo;

public class parseReport {
    public static final int[] time_sec = {1,60,3600};
    public static boolean isSummary(String line){
        return line.contains("summary =");
    }
    public static double convertSec(String src){
        String[] con = src.split("\\/");
        double result = Double.parseDouble(con[0]);
        switch (con[1]) {
            case "s":
                break;
            case "min":
                result = result/60d;
                break;
            case "hour":
                result = result/3600d;
                break;
            default:
                break;
        }
        return result;
    }
    //时间转换成秒
    //时间格式不对，3.4min
    public static long time_convertSec(String src){
        src = src.replaceAll("\\s+", "").replaceAll("[a-zA-Z]+", "|");
        String[] con = src.split("\\|");
        long result = 0;
//        for(int i=con.length-1;i>=0;i--)
//            result += Long.parseLong(con[i])*time_sec[con.length-i-1];
        return result;
    }
    public static summaryPojo parsePojo(String line){
        if(line == null || line.equals(""))
            return null;
        line = line.replaceFirst("[^0-9]*", "").replaceFirst("\\%\\)$", "").replaceAll(" [^0-9]*", "|");
        String[] result = line.split("\\|");//summary =    560 in     9s =   62.7/s Avg:   141 Min:     3 Max:  2369 Err:     0 (0.00%)
        summaryPojo summary = new summaryPojo();
        summary.setRequests(Integer.parseInt(result[0]));
        summary.setTimes(time_convertSec(result[1]));
        summary.setThroughput(convertSec(result[2]));
        summary.setAvg(Integer.parseInt(result[3]));
        summary.setMin(Integer.parseInt(result[4]));
        summary.setMax(Integer.parseInt(result[5]));
        summary.setError(Float.parseFloat(result[7]));
        return summary;
    }
    public static void main (String args[])
    {
//        System.out.println(isSummary("summary =    560 in     9s =   62.7/s Avg:   141 Min:     3 Max:  2369 Err:     0 (0.00%)"));
//        parsePojo("summary =    560 in     9s =   62.7/s Avg:   141 Min:     3 Max:  2369 Err:     0 (0.00%)");
//        System.out.println(convertSec("3600/hour"));
//        System.out.println(time_convertSec("1hour      1min 9s"));
        summaryPojo a = parsePojo("summary =    560 in     9s =   62.7/min Avg:   141 Min:     3 Max:  2369 Err:     0 (0.00%)");
        System.out.println(a.getThroughput());
    }
   
}
