package redisMessage;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subcribe {
    private Jedis jedis = null;
    public void init() {
        jedis = new Jedis("127.0.0.1");
    }
    public void subcribe() {
        
        JedisPubSub jedisPubSub = new jedis_pub_sub_listener();
        //监听管道
        jedis.subscribe(jedisPubSub  , "channel1");
    }
    public static void main(String[] args) {
        Subcribe sub=new Subcribe();
        sub.init();
        sub.subcribe();
    }
}

class jedis_pub_sub_listener extends  JedisPubSub {
    
    @Override
    public void proceed(Client client, String... channels) {
        super.proceed(client, channels);
    }
 
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(message);
        //消息处理函数
        super.onMessage(channel, message);
    }   
}

