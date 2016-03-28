# JMeter的自动化压测工具

Jmeter是一个优秀的基于java开发的测试工具，主要用来测试web应用的性能。

具体可以参考：
http://www.i3geek.com/archives/1147

## 用法

1. 利用JMeter录制测试脚本，并设定参数
2. 生成测试脚本jmx
3. 在java程序中修改线程数，并引用脚本
4. 自动化运行，并收集结果（如时间、吞吐量等）

## 作用

通过自动化脚本，可以方便的画出web应用的并发数与吞吐率的函数关系，制定应用的性能曲线

## 源码说明

	jmeter.jmx
		|-pojo	
		|	|-summaryPojo.java
		|		jmeter中汇聚报告的pojo
		|-util
		|	|-execLinux.java
		|	|	linux环境下，脚本的运行辅助类
		|	|-parseReport.java
		|	|	解析抓取的Report成pojo的辅助类
		|	|-parseXML.java
		|		解析返回结果的XML的辅助类
		|-jmeter.java
			主类，测试运行类