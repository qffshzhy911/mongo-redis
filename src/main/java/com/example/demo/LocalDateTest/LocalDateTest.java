package com.example.demo.LocalDateTest;

import java.time.*;

import com.example.demo.Redis.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocalDateTest {

    /**
     * LocalDate  没有时区的日期  线程安全  不可修改
     * 注 ：  这是一个日期   而不是一个时间！！！！     JAVA.UTIL.DATA  中  “ 2078-11-13”  代表的是 0点0分0秒的瞬间！！
     *
     *  ZoneId    时区ID   确认  Instant  LocalDatetime 转化规则
     *  Clock  当前时刻  有时区
     *
     * @param args
     */

    public static void main(String[] args) {


    }

    @Test
    public void eqs(){


        LocalDate today=LocalDate.now();
        System.err.println("today!!"+today);

        LocalDate oneDat=LocalDate.of(2018,11,13);
        System.err.println("oneday: "+oneDat);

        //LocalDate重写了equals方法来进行日期的比较
        System.err.println("是否相等： "+ oneDat.equals(today));
    }

    @Test
    public void mouseDay(){
        //获得月日
        MonthDay monthDay=MonthDay.of(1,1);
        System.err.println(monthDay);



    }

    /**
     * 获得时区
     */
    @Test
    public  void geZoneId(){
        ZoneId zoneId= ZoneId.systemDefault();
        System.err.println("默认时区 ：" +zoneId);

        ZoneId shanghaiZoneId = ZoneId.of("Asia/Shanghai");
        System.err.println("上海时区"+ shanghaiZoneId);

    }


    @Test
    public void dayTime(){
        //很多时候需要对时间进行操作，比如加一个小时来计算之后的时间，java8提供了更方便的方法 如plusHours，
        // 这些方法返回的是一个新的LocalTime实例的引用，因为LocalTime是不可变的
        LocalTime localTime= LocalTime.now();
        System.err.println(localTime);

        LocalTime plusHours = localTime.plusHours(2);
        System.err.println("!!"+plusHours);

    }

    @Test
    public  void dayWhat(){
        LocalDateTime localDate1=LocalDateTime.of(2018,11,13,0,0,0);
        LocalDateTime localDate2=LocalDateTime.of(2018,11,14,0,0,0);

        System.err.println("是这年的第  "+localDate1.getDayOfYear()+"天");
        System.err.println("经过了 "+(localDate2.getDayOfYear()-localDate1.getDayOfYear())+"天 ");

        LocalDateTime localDate = localDate1.plusDays(2);
        System.err.println("2天后是 "+localDate);


        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
        System.err.println("开始时间： "+today_start   +"结束时间为  " +today_end);
    }



}
