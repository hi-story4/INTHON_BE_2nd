package com.ai.be.constant.response;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum CustomResponseStatus {

    //    1000
    SUCCESS(HttpStatus.OK.value(), "1000", "요청에 성공하였습니다."),

    //    2000
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "2000", "잘못된 API 인증 입니다."),
    //4000
    NULL_TOKEN(HttpStatus.NO_CONTENT.value(), "4000", "인증 Key 값이 공백입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4001", "해당 유저를 찾을 수 없습니다."),
    REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4002", "해당 리뷰를 찾을 수 없습니다."),
    RECEIPT_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "4003", "해당 영수증을 찾을 수 없습니다."),

    //    6000
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6000", "내부 서버 오류입니다."),
    RECEIPT_OCR_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(),"6001", "영수증 OCR 인식에 실패했습니다."),
    MAPPING_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6002", "객체 매핑에 실패했습니다"),
    SAVED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "6003", "데이터 저장에 실패했습니다."),

    //    7000
    INVALID_ERROR(HttpStatus.BAD_REQUEST.value(), "7000", "유효하지 않은 데이터입니다."),
    REDUNDANT_RECEIPT(HttpStatus.BAD_REQUEST.value(), "7001", "이미 등록된 영수증입니다."),
    STORE_MATCH_ERROR(HttpStatus.BAD_REQUEST.value(), "7002", "해당 가게의 영수증이 아닙니다."),
    INVALID_RECEIPT(HttpStatus.BAD_REQUEST.value(), "7003", "유효한 영수증이 아닙니다."),
    INVALID_REVIEW(HttpStatus.BAD_REQUEST.value(), "7004", "해당 리뷰를 수정할 수 없습니다."),
    NO_MULITIPART_ERROR(HttpStatus.BAD_REQUEST.value(), "7005", "사진 데이터가 없습니다. ");



    private final int httpStatusCode;
    private final String code;
    private final String message;

    CustomResponseStatus(int httpStatusCode, String code, String message) {
        this.httpStatusCode = httpStatusCode;
        this.code = code;
        this.message = message;
    }

}
