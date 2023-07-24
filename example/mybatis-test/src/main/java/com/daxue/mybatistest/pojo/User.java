package com.daxue.mybatistest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author daxue0929
 * @date 2023/7/24
 */

@Data
@TableName(value = "user")
public class User {
    public Integer id;
    public String username;
}
