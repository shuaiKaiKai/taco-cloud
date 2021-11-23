package tacos.RabbitMq.serviceImpl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tacos.model.Order;

/**
 * Rabbit接受消息
 */
@Component
public class RabbitOrderReceiver {

    private RabbitTemplate rabbit;

    private MessageConverter converter;

    @Autowired
    public RabbitOrderReceiver(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    /**
     * 拉取消息（pull）
     * @return
     */
    public Order receiveOrder() {
        Message message = rabbit.receive("tacocloud.orders", 3000);
        return message != null ? (Order) converter.fromMessage(message) : null;
    }
}
