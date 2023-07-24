package com.daxue.mybatistest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daxue.mybatistest.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author daxue0929
 * @date 2023/7/24
 */

@Repository
@Mapper
public interface UserMapper  extends BaseMapper<User> {
    User selectById(Integer id);
}
