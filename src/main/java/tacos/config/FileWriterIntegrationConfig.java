package tacos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.io.File;
import java.util.Collection;
import java.util.Collections;

/**
 * 文件流处理
 */
@Configuration
public class FileWriterIntegrationConfig {

    /**
     * 声明转换器
     *
     * @return
     */
    @Bean
    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> upperCaseTransformer() {
        return text -> text.toUpperCase();
    }

    /**
     * 声明文件写入器
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWriter() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("/tmp/sia5/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }

    //--------------------------

    /**
     * 使用Spring Integration的java DSL配置
     *
     * @return
     */
    @Bean
    public IntegrationFlow fileWriterFlow() {
        return IntegrationFlows.from(MessageChannels.direct("TextInchannel"))
                .<String, String>transform(t -> t.toUpperCase()).handle(Files.outboundAdapter(new File("/tmp/sia5/files"))
                        .fileExistsMode(FileExistsMode.APPEND).appendNewLine(true)).get();
    }

    /**
     * 使用Spring Integration的java DSL配置 显示声明出站通道
     *
     * @return
     */
    public IntegrationFlow fileWriterFlow2() {
        return IntegrationFlows.from(MessageChannels.direct("textInChannel"))
                .<String, String>transform(t -> t.toUpperCase()).channel(MessageChannels.direct("fileWriterChannel")).handle(Files.outboundAdapter(new File("/tmp/sia5/files"))
                        .fileExistsMode(FileExistsMode.APPEND).appendNewLine(true)).get();
    }

    //-----------------

    /**
     * 路由器
     *
     * @return
     */
    public AbstractMessageRouter evenOddRouter() {
        return new AbstractMessageRouter() {
            @Override
            protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
                Integer number = (Integer) message.getPayload();
                if (number % 2 ==0) {
                    return Collections.singleton(evenChannel());
                }
                return Collections.singleton(oddChannel());
            }
        };
    }

    @Bean
    public MessageChannel evenChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel oddChannel() {
        return new DirectChannel();
    }
}
