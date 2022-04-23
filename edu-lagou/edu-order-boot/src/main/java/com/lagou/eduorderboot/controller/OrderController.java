package com.lagou.eduorderboot.controller;

import com.lagou.eduorderboot.entity.PayOrder;
import com.lagou.eduorderboot.entity.PayOrderRecord;
import com.lagou.eduorderboot.entity.SmsVo;
import com.lagou.eduorderboot.entity.UserCourseOrder;
import com.lagou.eduorderboot.service.OrderService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("saveOrder")
    public String saveOrder(String orderNo,String user_id , String course_id,String activity_course_id,String source_type,Double price) {
        // 保存支付订单
        orderService.saveOrder(orderNo, user_id, course_id, activity_course_id, source_type);
        // 保存订单的记录日志
        PayOrderRecord record = new PayOrderRecord();
        record.setOrder_no(orderNo);
        record.setType("CREATE");
        record.setFrom_status("0");
        record.setTo_status("1");
        record.setPaid_amount(price);
        record.setCreated_by(user_id);
        record.setCreated_at(new Date());
        System.out.println("创建订单记录 = " + orderNo);
        orderService.saveOrderRecord(record);

        return orderNo;
    }

    @GetMapping("updateOrder")
    public Integer updateOrder(String orderNo , Integer status,String user_id,String course_id,String course_name,Double price,String phone) {
        System.out.println("订单编号 = " + orderNo);
        System.out.println("状态编码 = " + status);
        Integer integer = orderService.updateOrder(orderNo, status);
        System.out.println("订单更新 = " + integer);

        if(integer == 1){
            // 记录订单支付的详情
            PayOrder po = new PayOrder();
            po.setOrder_no(orderNo);
            po.setUser_id(user_id);
            po.setProduct_id(course_id);
            po.setProduct_name(course_name);
            po.setAmount(price);
            po.setCount(1);
            po.setCurrency("cny");
            po.setChannel("weChat");
            po.setStatus(2);
            po.setOrder_type(1);
            po.setSource(3);
            po.setClient_ip("192.168.1.1"); // 自行解决：获取客户端ip
            po.setCreated_time(new Date());
            po.setUpdated_time(new Date());

            orderService.saveOrderInfo(po);

            // 记录支付操作的日志
            PayOrderRecord record = new PayOrderRecord();
            record.setOrder_no(orderNo);
            record.setType("PAY");
            record.setFrom_status("1");
            record.setTo_status("2");
            record.setPaid_amount(price);
            record.setCreated_by(user_id);
            record.setCreated_at(new Date());
            System.out.println("创建订单记录 = " + orderNo);

            orderService.saveOrderRecord(record);

            // 发送短信成功的通知(消息的生产者)
            SmsVo smsVo = new SmsVo();
            smsVo.setPhone(phone);// 手机号码
            smsVo.setCourseName(course_name);
            rabbitTemplate.convertAndSend(queue,smsVo);
        }
        return integer;
    }

    @GetMapping("deleteOrder")
    public Integer deleteOrder(String orderno ) {
        Integer integer = orderService.deleteOrder(orderno);
        return integer;
    }


    @GetMapping("getOKOrderCourseIds")
    public List<Object> getOKOrderCourseIds(@RequestParam Integer userid){
        System.out.println("获取"+userid +"的购买的课程编号！");
        List<UserCourseOrder> list = orderService.getOKOrderCourseIds(userid);
        List<Object> list2 = new ArrayList<>();
        for(UserCourseOrder order : list){
            list2.add(order.getCourseId());
        }
        System.out.println("已购成功的课程id：" + list2);
        return list2;
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @GetMapping("sendMQ")
    public void sendMQ() {
        String mq = "你好，mq";
        rabbitTemplate.convertAndSend(queue, mq);
    }

}
