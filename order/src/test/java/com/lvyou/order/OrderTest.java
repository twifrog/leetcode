package com.lvyou.order;

import com.lvyou.order.constants.FormNoConstants;
import com.lvyou.order.constants.FormNoTypeEnum;
import com.lvyou.order.util.FormNoSerialUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @Author: VernLv
 * @Data: Create in 11:34 2019/8/16
 */

public class OrderTest {


    @Test
    public void testGenarateId(){
        FormNoTypeEnum formNoTypeEnum = FormNoTypeEnum.FK_ORDER;
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //获得单号前缀
        //格式 固定前缀 +时间前缀 示例 ：YF20190101
        String formNoPrefix = FormNoSerialUtil.getFormNoPrefix(formNoTypeEnum);
        //获得缓存key
        String cacheKey = FormNoSerialUtil.getCacheKey(formNoPrefix);
        //获得当日自增数
        Long incrementalSerial = jedis.incr(cacheKey);
        //设置失效时间 7天
        jedis.expire(cacheKey, FormNoConstants.DEFAULT_CACHE_DAYS * 60 * 60 * 24);
        //组合单号并补全流水号
        String serialWithPrefix = FormNoSerialUtil
                .completionSerial(formNoPrefix, incrementalSerial, formNoTypeEnum);
        //补全随机数
        jedis.close();
        System.out.println(FormNoSerialUtil.completionRandom(serialWithPrefix, formNoTypeEnum));

    }

}
