package com.mszlu.blog.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class LoginUserVo {

    private String id;

    private String account;

    private String nickname;

    private String avatar;

}
