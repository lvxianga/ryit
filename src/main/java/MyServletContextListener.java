package main.java;

import main.java.cast.SafeCast;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashMap;
import java.util.List;

public class MyServletContextListener implements ServletContextListener {
    public static SafeCast sc = new SafeCast();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read("..\\resources\\myfactory.xml");
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for(Element i : list) {
                String clazzName = i.attributeValue("clazz");
                Class c = Class.forName("main.java.entity.MyJdbc");
                sc.put(c, c.newInstance());
            }

            Class c = Class.forName("main.java.entity.MyJdbc");
            sc.put(c,c.newInstance());
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
