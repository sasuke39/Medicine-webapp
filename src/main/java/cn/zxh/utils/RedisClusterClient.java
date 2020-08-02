package cn.zxh.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.rmi.runtime.Log;

@Service
public class RedisClusterClient {

    @Resource
    private RedisTemplate<String, String> clusterRedisTemplate;





//    @Resource
//    private StringRedisTemplate redisTemplate;

    //添加数据
    public void put(Object key, Object value) {
        if(null == value) {
            return;
        }

        if(value instanceof String) {
            if(StringUtils.isEmpty(value.toString())) {
                System.out.println("值为空，返回");
                return;
            }
        }

        // TODO Auto-generated method stub
        final String keyf = key + "";
        final Object valuef = value;
        final long liveTime = 86400;
//        System.out.println(clusterRedisTemplate);

        clusterRedisTemplate.execute((RedisCallback<Long>) connection -> {
            byte[] keyb = keyf.getBytes();
            byte[] valueb = toByteArray(valuef);
            connection.set(keyb, valueb);
            if (liveTime > 0) {
                connection.expire(keyb, liveTime);
            }
            return 1L;
        });
    }

    // 获取数据
    public Object get(Object key) {
        final String keyf = (String) key;
        Object object;
        object = clusterRedisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {

                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);

            }
        });

        return object;
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

//    private String getkey(){
//        redisTemplate.s
//    }

    public void putSortedSet(Object key,Double score ,Object member){

        if(null == score) {
            return;
        }
        if(member instanceof String) {
            if(StringUtils.isEmpty(member.toString())) {
                System.out.println("成员为空，返回");
                return;
            }
        }
        final String keyf = key + "";
        final String memberf = member+"";
        final Double scoref = score ;
//        final long liveTime = 86400;

//        clusterRedisTemplate.execute()
        ZSetOperations<String, String> zSet = clusterRedisTemplate.opsForZSet();
        zSet.add(keyf,memberf,scoref);



    }


    public Set<ZSetOperations.TypedTuple<String>> getSortedSet(Object key) {
        final String keyf = (String) key;
//        HashMap<String, String> hashMap = new HashMap<>()
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        ZSetOperations<String, String> zSet = clusterRedisTemplate.opsForZSet();
        Long size = zSet.size(keyf);
        if (size == null || size == 0) {
            System.out.println("null");
//            return hashMap;
        } else {
            if (size >= 10) {
                //                System.out.println(">10:"+withScores);
//                hashMap.putAll(withScores);
                return zSet.reverseRangeWithScores(keyf, 0, 10);
            } else {
                //                System.out.println(withScores);
//                assert withScores != null;
//                for (ZSetOperations.TypedTuple<String> withScore : withScores) {
//                    System.out.println(withScore.getValue()+":"+withScore.getScore());
//                }
                return zSet.reverseRangeWithScores(keyf, 0, -1);
            }
        }
//        return hashMap;
        return set;
    }

    public boolean ifExistMember(Object key,Object member) {
        if (key == null || member == null) {
            return false;
        }
        final String keyf = key + "";
        final String memberf = member + "";
        ZSetOperations<String, String> zSet = clusterRedisTemplate.opsForZSet();
        Long rank = zSet.rank(keyf, memberf);
        if (rank == null) {
            return false;
        }

        return true;

    }

    public void IncrMember(Object key,Object member){
        if (key == null || member == null) {
            return ;
        }
        final String keyf = key + "";
        final String memberf = member + "";
        ZSetOperations<String, String> zSet = clusterRedisTemplate.opsForZSet();
        zSet.incrementScore(keyf,memberf,10.0);

    }

}
