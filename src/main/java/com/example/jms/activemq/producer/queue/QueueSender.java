package com.example.jms.activemq.producer.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * 
 * @description  队列消息生产者，发送消息到队列
 * 
 */
@Component("queueSender")
public class QueueSender {
	
//	@Autowired
//	@Qualifier("jmsQueueTemplate")
//	private JmsTemplate jmsTemplate;//通过@Qualifier修饰符来注入对应的bean
//	
//	/**
//	 * 发送一条消息到指定的队列（目标）
//	 * @param queueName 队列名称
//	 * @param message 消息内容
//	 */
//	public void send(String queueName,final String message){
//			jmsTemplate.send(queueName, new MessageCreator() {
//			@Override
//			public Message createMessage(Session session) throws JMSException {
//				return session.createTextMessage(message);
//			}
//		});
//	}
	
	
	@Autowired  
    private JmsMessagingTemplate jmsTemplate; 
	
	/**
	 * 发送一条消息到指定的队列（目标）
	 * @param queueName 队列名称
	 * @param message 消息内容
	 */
	public void send(Queue queue,final String message){
		try {
			jmsTemplate.convertAndSend(queue.getQueueName(), new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage(message);
				}
			});
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}
}
