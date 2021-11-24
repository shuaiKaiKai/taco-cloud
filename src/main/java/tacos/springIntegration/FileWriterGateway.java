package tacos.springIntegration;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * 将方法调用转换成消息的消息网关接口
 */
@MessagingGateway(defaultRequestChannel = "textInchannel")  //声明网关消息
public interface FileWriterGateway {

    void writeToFile(@Header(FileHeaders.FILENAME) String fileName, String data);
}
