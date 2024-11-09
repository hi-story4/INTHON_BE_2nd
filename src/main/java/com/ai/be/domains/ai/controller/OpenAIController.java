package com.ai.be.domains.ai.controller;

import com.ai.be.constant.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/ai")
@Controller
@RequiredArgsConstructor
public class OpenAIController {


    @GetMapping()
    public ResponseEntity<ApiResponse<String>> getApiResponse(){

        return ApiResponse.createSuccessWithOk("index");
    }
}

