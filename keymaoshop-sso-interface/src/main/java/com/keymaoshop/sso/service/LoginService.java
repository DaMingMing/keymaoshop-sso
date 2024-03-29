package com.keymaoshop.sso.service;

import com.keymao.common.utils.E3Result;

public interface LoginService {
    //参数：用户名、密码
    //业务逻辑
    /*
     *1、判断用户名密码是否正确
     * 2、如不正确，返回登录失败
     * 3、如正确，生成token
     * 4、把用户信息写入Redis，key:token value:用户信息
     * 5、设置session过期时间
     * 6、把token返回
     */
    //返回值：E3Result，其中包含token信息
    E3Result userLogin(String username,String password);

    /**
     * 根据key删除redis登录信息
     * @param token
     * @return
     */
    E3Result userLogout(String token);
}
