package com.ai.be.constant.response;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomResponseStatus {

    //    1000
    SUCCESS(HttpStatus.OK.value(), "1000", "요청에 성공하였습니다."),

    //    2000
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "2000", "잘못된 비밀번호 입니다."),

    //4000
    NULL_PASSWORD(HttpStatus.NO_CONTENT.value(), "4000", "비밀번호 값이 공백입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4001", "해당 유저를 찾을 수 없습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4002", "해당 글을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4003", "해당 댓글을 찾을 수 없습니다."),

    //    6000
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6000", "내부 서버 오류입니다."),
    POST_SAVED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"6001", "글 저장에 실패했습니다."),
    USER_SAVED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6002", "유저 회원가입에 실패했습니다."),
    MESSAGE_SEND_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"6003", "메세지 전송에 실패했습니다."),
    COMMENT_SAVED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6004", "답변 저장에 실패했습니다."),
    AI_RESPONSE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6005", "AI Chat 답변에 실패했습니다."),
    //    7000
    INVALID_ERROR(HttpStatus.BAD_REQUEST.value(), "7000", "유효하지 않은 데이터입니다.");



    private final int httpStatusCode;
    private final String code;
    private final String message;

    CustomResponseStatus(int httpStatusCode, String code, String message) {
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }

}
