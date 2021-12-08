package main.java;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;

public class MyServletContextListener implements ServletContextListener {

    public static void main(String[] args) {

    }

    public static HashMap<String,Object> hashMap = new HashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {

            document = reader.read("C:\\Users\\86185\\IdeaProjects\\Ryit_ Management\\src\\main\\resources\\myfactory.xml");
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for(Element i : list){
                String clazzName = i.attributeValue("clazz");
                Object obj = Class.forName(clazzName).newInstance();
                hashMap.put(i.attributeValue("name"),obj);
            }
            //
            Object jdbc = Class.forName("main.java.entity.MyJdbc").newInstance();
            hashMap.put("jdbc",jdbc);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
