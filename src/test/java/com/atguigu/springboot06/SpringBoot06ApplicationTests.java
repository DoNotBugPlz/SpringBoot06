package com.atguigu.springboot06;


import com.atguigu.springboot06.elastic.bean.Book;
import com.atguigu.springboot06.repository.BookRepository;
import com.atguigu.springboot06.user.beans.User;
import com.atguigu.springboot06.user.mapper.UserDao;
import com.atguigu.springboot06.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot06ApplicationTests {
//    @Autowired
//    JestClient jestClient;


    @Autowired
    DataSource dataSource;

    @Autowired
    UserDao userDao;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object, User> userRedisTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void testRedis01() {
        //给Redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg", "hello");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
        stringRedisTemplate.opsForList().leftPush("mylist", "1");
        stringRedisTemplate.opsForList().leftPush("mylist", "2");
        stringRedisTemplate.opsForList().leftPush("mylist", "3");
    }

    @Test
    public void testRedis02() {
        User user = userService.getById(1);
        redisTemplate.opsForValue().set("user", user);
        userRedisTemplate.opsForValue().set("user02", user);
    }

    @Test
    public void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void testMybatisPlus() {
        //basic query test
//        User user = new User();
//        user.setAge(19).setName("猪狗屎").setEmail("zhunwen@183.com");
//        int i = userDao.insert(user);
//        System.out.println("============插入条数为:" + i);
//        user.setAge(100);
//        userDao.updateById(user);

        //EntityWrapper query test
        System.out.println("1111111111111111");
        IPage<User> age = userDao.selectPage(new Page<User>(1, 2), new QueryWrapper<User>()
                .between(true, "age", 1, 17));
//        User user = userService.getById(2);
//        userRedisTemplate.opsForValue().setIfAbsent("user04", user);
//        System.out.println(userService.query().select("id").getSqlSelect());
    }

    /**
     * 单播
     */
    @Test
    public void testRabbitMQ() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", map);
    }

    @Test
    public void testRecevieMessage() {
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void testElasticSearch(){
//        Article article = new Article();
//        article.setId(1).setTitle("好消息").setAuthor("zhangsan").setContent("hello world");
//
//        Index index = new Index.Builder(article).index("atguigu").type("news").build();
//        try {
//            jestClient.execute(index);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Book book = new Book();
        book.setId(1).setBookName("西游记").setAuthor("吴承恩");
        bookRepository.index(book);

    }

    @Test
    public void testElasticSearch02(){
//        String json = "{\n" +
//                "    \"query\" : {\n" +
//                "        \"match\" : {\n" +
//                "            \"content\" : \"hello\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}\n";
//      Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
//        try {
//            SearchResult searchResult = jestClient.execute(search);
//            System.out.println(searchResult.getJsonString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }




}
