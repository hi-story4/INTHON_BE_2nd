package com.ai.be.domains.user.controller;


import com.ai.be.constant.response.ApiResponse;
import com.ai.be.domains.user.dto.UserReq;
import com.ai.be.domains.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<ApiResponse<String>> authUser(@ModelAttribute UserReq req){
        String userId = userService.isUserAuth(req);
        //교차 검증
        return ApiResponse.createSuccessWithOk(userId);
    }
}
