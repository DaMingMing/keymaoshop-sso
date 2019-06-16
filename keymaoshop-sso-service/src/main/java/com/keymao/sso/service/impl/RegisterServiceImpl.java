package com.keymao.sso.service.impl;

import com.keymao.common.utils.E3Result;
import com.keymao.mapper.TbUserMapper;
import com.keymao.pojo.TbUser;
import com.keymao.pojo.TbUserExample;
import com.keymaoshop.sso.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    protected TbUserMapper userMapper;

    @Override
    public E3Result checkData(String param, int type) {
        //根据不同的type生成不同的查询条件
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        //1：用户名 2：手机号 3：邮箱
        if (type == 1) {
            criteria.andUsernameEqualTo(param);
        } else if (type == 2) {
            criteria.andPhoneEqualTo(param);
        } else if (type == 3) {
            criteria.andEmailEqualTo(param);
        } else {
            return E3Result.build(400, "数据类型错误");
        }
        //执行查询
        List<TbUser> list = userMapper.selectByExample(example);
        //判断结果中是否包含数据
        if (list != null && list.size() > 0) {
            //如果有数据返回false
            return E3Result.ok(false);
        }
        //如果没有数据返回true
        return E3Result.ok(true);
    }

    @Override
    public E3Result register(TbUser user) {
        return null;
    }
}
