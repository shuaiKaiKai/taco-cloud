package tacos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 持有者
 */
@Component
@ConfigurationProperties(prefix = "taco.orders")
@Data
public class ParamsConfig {

    private int pageSize = 20;
}
