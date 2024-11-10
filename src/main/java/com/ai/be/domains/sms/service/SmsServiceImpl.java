package com.ai.be.domains.sms.service;

import com.ai.be.constant.exception.CustomException;
import com.ai.be.constant.response.CustomResponseStatus;
import com.ai.be.domains.sms.dto.SmsReq;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    private final DefaultMessageService messageService;
    private final String sendPhoneNumber;

    public SmsServiceImpl(
            @Value("${app.sms.sender}") String sendPhoneNumber,
            @Value("${app.sms.api-key}") String apiKey,
            @Value("${app.sms.api-secret}") String apiSecret
    ) {
        this.sendPhoneNumber = sendPhoneNumber;
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey, apiSecret, "https://api.coolsms.co.kr");
    }

    @Override
    public void sendMessage(SmsReq req) {
        try {
            Message message = new Message();
            message.setFrom(sendPhoneNumber);
            log.info("메세지" +req.phone());
            message.setTo(req.phone());
            message.setText(req.message());

            SingleMessageSentResponse response = messageService.sendOne(
                    new SingleMessageSendingRequest(message)
            );
            log.info("SMS sent successfully - Response: {}", response);
        } catch (Exception e) {
            log.error("Failed to send SMS to {}: {}", req.phone(), e.getMessage(), e);
            throw new CustomException(CustomResponseStatus.MESSAGE_SEND_ERROR);
        }
    }
}