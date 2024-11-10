package com.ai.be.domains.user.service;

import com.ai.be.domains.user.dto.UserReq;
import com.ai.be.domains.user.entity.User;

import java.util.Optional;

public interface UserService {

    User getUserById(String userId);
    Optional<User> getUserByPhone(String phone);

    User registUserByPhone(String phone);

    String isUserAuth(UserReq req);

    void sendCommentMessageByUserId(String userId);
}
