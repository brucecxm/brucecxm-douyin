package com.bruce.sevenandeight;
import com.example.rabbitmq.RabbitmqApplication;
import com.example.rabbitmq.mq.delayed.DelayedSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelayedTest {
    //七和八都是rabbitmq实习延时队列 一个是利用死信交换机  一个是用插件
//七和八都是rabbitmq实习延时队列 一个是利用死信交换机  一个是用插件
//七和八都是rabbitmq实习延时队列 一个是利用死信交换机  一个是用插件
    @Autowired
    private DelayedSender sender;

    @Test
    public void Test() throws InterruptedException {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        sender.send("Hi Admin.");
        Thread.sleep(5 * 1000); //等待接收程序执行之后，再退出测试
    }
}
