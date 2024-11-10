//package com.ai.be.domains.openAI;
//
//import com.ai.be.constant.response.ApiResponse;
//import com.ai.be.domains.openAI.dto.OpenAiChatResp;
//import com.ai.be.domains.openAI.service.OpenAIService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping(value = "/api/v1/ai")
//@RequiredArgsConstructor
//public class AIController {
//    private final OpenAIService openAIService;
//    @GetMapping
//    public ResponseEntity<ApiResponse<OpenAiChatResp>> postAI(
//    ){
//       OpenAiChatResp resp = openAIService.getOpenAIChat("오늘 하루 코딩하느라 너무 힘들었어. 뭐 먹고 살지");
//       return ApiResponse.createSuccessWithOk(resp);
//    }
//
//    @GetMapping("/test")
//    public ResponseEntity<ApiResponse<String>> getAITEST(){
//        openAIService.getEmbedding("창업을 하고싶어.");
//        return ApiResponse.createSuccessWithOk("success");
//    }
//}

//TEST 용 API