package redisMessage;

import java.util.Date;

import redis.clients.jedis.Jedis;

public class Publish {
    private Jedis jedis =null;
    
    private void init(){
        jedis=new Jedis("127.0.0.1");
    }
    
    public void publish(){
        jedis.publish("channel1", "haha");
    }
    public static void main(String[] args) {
        Publish pu=new Publish();
        pu.init();
        pu.publish();
        
    }
}
