package com.lagou.eduorderboot.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderRever {
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void process(String msg) {
        System.out.println("得到通知，开始发送：" + msg);
    }
}
