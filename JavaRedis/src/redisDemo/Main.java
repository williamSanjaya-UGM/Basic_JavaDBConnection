package redisDemo;

import redis.clients.jedis.Jedis;

public class Main {
    public static void main(String[] args) {
        try{
            Jedis jedis = new Jedis("localhost");
            System.out.println("Connection successful");
            System.out.println("List push one two: "+jedis.lpush("apple","chocolate"));
            System.out.println("List pop: "+jedis.lpop("apple"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
