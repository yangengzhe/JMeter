package jmeter.jmx.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;


public class parseXML {
    public static void main(String[] args) throws Exception
    {
        String xmlpath = "/Users/yangengzhe/Desktop/云平台/ygz/demo2.jtl";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        org.w3c.dom.Document t_document = db.parse(new File(xmlpath));
        DOMReader domReader = new DOMReader();
        Document document = domReader.read(t_document);
        // 获取根元素
        Element root = document.getRootElement();
        long t=0,ts=0,startTime=Long.MAX_VALUE,endTime=0,requests=0;
        // 迭代输出
        for (Iterator<Element> iter = root.elementIterator(); iter.hasNext();)
        {
            Element e = (Element) iter.next();
            t= Long.parseLong(e.attributeValue("t"));
            ts= Long.parseLong(e.attributeValue("ts"));
            startTime = ts<startTime?ts:startTime;
            endTime = (t+ts) > endTime?(t+ts):endTime;
            requests++;
        }
        float throughput = (endTime-startTime)/1000f;
        throughput = requests/throughput;
        System.out.println("开始时间："+startTime+",结束时间："+endTime+",请求数："+requests+",吞吐量："+throughput);


    }

    
}
