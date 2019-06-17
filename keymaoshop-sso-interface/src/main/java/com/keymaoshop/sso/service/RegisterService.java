package com.keymaoshop.sso.service;

import com.keymao.common.utils.E3Result;
import com.keymao.pojo.TbUser;

public interface RegisterService {

    /**
     * 注册校验
     * @param param 要校验的数据
     * @param type 校验的数据类型，1-用户名；2-手机号
     * @return  如果没有数据返回true，否则返回false
     */
    E3Result checkData(String param, int type);

    /**
     * 注册用户
     * @param user
     * @return
     */
    E3Result register(TbUser user);
}
