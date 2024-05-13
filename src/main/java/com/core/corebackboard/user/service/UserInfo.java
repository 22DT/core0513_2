package com.core.corebackboard.user.service;

/*
* service 계층에서만 사용
* */
public record UserInfo(
        String email,
        String password,
        String name
) {


}
