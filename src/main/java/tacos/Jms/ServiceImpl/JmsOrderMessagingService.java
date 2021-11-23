//package tacos.service.serviceImpl;
//
//import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//import tacos.model.Order;
//import tacos.RabbitMq.OrderMessagingService;
//
//import javax.jms.Destination;
//
///**
// * jms发送异步消息
// */
//@Service
//public class JmsOrderMessagingService implements OrderMessagingService {
//
//    @Autowired
//    private JmsTemplate jms;
//
//    @Autowired
//    private Destination orderQueue;
//
//    @Override
//    public void sendOrder(Order order) {
//        jms.send(orderQueue, session -> session.createObjectMessage("order"));
//    }
//
//    @Bean
//    public Destination orderQueue() {
//        return new ActiveMQQueue("tacocloud.order.queue");
//    }
//}
