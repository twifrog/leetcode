package com.lvyou.order.service;

import com.lvyou.order.constants.FormNoTypeEnum;

/**
 * @Author: VernLv
 * @Data: Create in 11:32 2019/8/16
 */
public interface FormNoGenerateService {

    String generateFormNo(FormNoTypeEnum formNoTypeEnum);
}
