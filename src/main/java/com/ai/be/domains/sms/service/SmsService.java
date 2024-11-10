package com.ai.be.domains.sms.service;

import com.ai.be.domains.sms.dto.SmsReq;

public interface SmsService {

    void sendMessage(SmsReq req);
}
