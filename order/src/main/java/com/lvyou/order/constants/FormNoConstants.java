package com.lvyou.order.constants;

import lombok.Data;

/**
 * @Author: VernLv
 * @Data: Create in 11:24 2019/8/16
 */
@Data
public class FormNoConstants {
    /**
     * 单号流水号缓存Key前缀
     */
    public static final String SERIAL_CACHE_PREFIX = "FORM_NO_CACHE_";

    /**
     * 单号流水号yyMMdd前缀
     */
    public static final String SERIAL_YYMMDD_PREFIX = "yyMMdd";

    /**
     * 单号流水号yyyyMMdd前缀
     */
    public static final String SERIAL_YYYYMMDD_PREFIX = "yyyyMMdd";

    /**
     * 默认缓存天数
     */
    public static final int DEFAULT_CACHE_DAYS = 7;

}
