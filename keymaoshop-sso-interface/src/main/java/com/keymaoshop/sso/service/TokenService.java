package com.keymaoshop.sso.service;


import com.keymao.common.utils.E3Result;

/**
 * 根据token查询用户信息
 */
public interface TokenService {

	E3Result getUserByToken(String token);
}
