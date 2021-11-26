package tacos.config;

import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import tacos.model.Order;

/**
 * 使用集成转换器将传入的Email转换为taco订单
 */
@Component
public class EmailToOrderTransformer {

    public AbstractIntegrationMessageBuilder<Order> doTransform(Message mailMessage) throws Exception {
        Order tacoOrder = processPayload(mailMessage);
        return MessageBuilder.withPayload(tacoOrder);
    }

    /**
     * mock
     *
     * @param mailMessage
     * @return
     */
    private Order processPayload(Message mailMessage) {
        return new Order();
    }
}
