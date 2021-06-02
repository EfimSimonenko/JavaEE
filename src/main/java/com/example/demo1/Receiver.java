package com.example.demo1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(name = "Receiver", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/queue/test"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")})
public class Receiver implements MessageListener {

    @Inject
    TimetableBean timetableBean;

    @Override
    public void onMessage(Message message) {
        try {
            LOG.info("Message: " + message.getBody(String.class));
            System.out.println("Message received");
            timetableBean.getList();
            //System.out.println(timetableBean.returnString() + "0_0");
        } catch (JMSException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);
}
