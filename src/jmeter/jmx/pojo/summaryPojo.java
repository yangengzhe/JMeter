package jmeter.jmx.pojo;

public class summaryPojo {
    private int requests;//请求个数
    private long times;//时间，second
    private double throughput;//吞吐率，request/sec
    private int avg;//ms
    private int min;//ms
    private int max;//ms
    private float error;//percent
    
    public int getRequests() {
        return requests;
    }
    
    public void setRequests(int requests) {
        this.requests = requests;
    }
    
    public long getTimes() {
        return times;
    }
    
    public void setTimes(long times) {
        this.times = times;
    }
    
    public double getThroughput() {
        return throughput;
    }
    
    public void setThroughput(double throughput) {
        this.throughput = throughput;
    }
    
    public int getAvg() {
        return avg;
    }
    
    public void setAvg(int avg) {
        this.avg = avg;
    }
    
    public int getMin() {
        return min;
    }
    
    public void setMin(int min) {
        this.min = min;
    }
    
    public int getMax() {
        return max;
    }
    
    public void setMax(int max) {
        this.max = max;
    }
    
    public float getError() {
        return error;
    }
    
    public void setError(float error) {
        this.error = error;
    }
}
