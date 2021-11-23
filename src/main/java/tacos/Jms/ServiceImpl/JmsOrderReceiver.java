//package tacos.Jms.ServiceImpl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//import tacos.model.Order;
//import tacos.Jms.OrderReceiver;
//
//import javax.jms.JMSException;
//
///**
// * Jms接受异步消息
// */
//@Component
//public class JmsOrderReceiver implements OrderReceiver {
//
//    @Autowired
//    private JmsTemplate jms;
//
//    @Override
//    public Order receiverOrder() throws JMSException{
//        return (Order) jms.receiveAndConvert("tacocloud.order.queue");
//
//    }
//}
