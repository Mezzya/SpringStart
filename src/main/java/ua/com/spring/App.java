package ua.com.spring;


import org.springframework.beans.factory.xml.XmlBeanDefinitionStoreException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by User on 13.12.2016.
 */
public class App {
    private Client client;
    private EventLogger eventLogger;

    public App() {
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }


    public static void main(String[] args) {

        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("spring.xml");

        App app = applicationContext.getBean("app", App.class);


        Event eventOne = applicationContext.getBean("event", Event.class);

        app.logEvent("Hello 1", eventOne);

        Event eventTwo = applicationContext.getBean("event", Event.class);

        app.logEvent("Hello Two", eventTwo);


    }

    private void logEvent(String msg, Event event){
        String message = msg.replaceAll(client.getId(), client.getFullName());

        event.setMsg(message);

        eventLogger.logEvent(event);
    }



}
