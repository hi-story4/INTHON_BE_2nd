package com.ai.be.domains.user.service;

import com.ai.be.constant.exception.CustomException;
import com.ai.be.constant.response.CustomResponseStatus;
import com.ai.be.domains.sms.dto.SmsReq;
import com.ai.be.domains.sms.service.SmsService;
import com.ai.be.domains.user.dto.PhoneDto;
import com.ai.be.domains.user.dto.UserReq;
import com.ai.be.domains.user.entity.User;
import com.ai.be.domains.user.mappper.UserMapper;
import com.ai.be.domains.user.repository.UserRepository;
import com.ai.be.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final SmsService smsService;
    private final PasswordUtil passwordUtil;
    private final UserMapper userMapper;

    //전화번호로 User 찾기
    @Transactional(readOnly = true)
    public Optional<User> getUserByPhone(String phone){
        //NULL일수있다. !!!
        Optional<User> user = userRepository.findByPhone(phone);

        return user;
        //return can be NULL
    }

    //인증

    @Transactional(readOnly = true)
    public String isUserAuth(UserReq req){
        User user = userRepository.findByPhone(req.phone())
                .orElseThrow(()-> new CustomException(CustomResponseStatus.MEMBER_NOT_FOUND));
        String storedEncryptedPassword = user.getPassword();

        boolean isAuthenticated = passwordUtil.isValidPassword(req.password(), storedEncryptedPassword);
        if(!isAuthenticated)
            throw new CustomException(CustomResponseStatus.UNAUTHORIZED);

        return user.getId();
    }
    @Transactional(readOnly = true)
    public User getUserById(String id){
        return userRepository.findById(id)
                .orElseThrow(()-> new CustomException(CustomResponseStatus.MEMBER_NOT_FOUND));
    }

    //전화번호로 가입
    @Transactional
    public User registUserByPhone(String phone){

        // phone 받아서 해당 번호로 uuid 6자 만들어서 비번으로 저장하고
        String password = passwordUtil.getPassword();
        String sendMessage = "비밀번호는 " + password + "입니다. ";

        // 해당 번호로 문자 발송
        smsService.sendMessage(SmsReq.builder()
                .phone(phone)
                .message(sendMessage)
                .build());

        //암호화
        String encodedPassword = passwordUtil.encodePassword(password);
        //암호화된 Password -> DB에 저장
        User user = userMapper.toEntity(phone, encodedPassword);
        try{
            //return
            return userRepository.save(user);
        } catch (Exception e){
            log.error(e.getMessage(), e);

            throw new CustomException(CustomResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    //Comment 답장 알림
    public void sendCommentMessageByUserId(String postUserId) {
        PhoneDto phoneDto = userRepository.findPhoneOptionalByUserId(postUserId)
                .orElseThrow(() -> new CustomException(CustomResponseStatus.MEMBER_NOT_FOUND));
        String phone = phoneDto.phone();
        //메세지 따로 관리하면 좋은데 keep.

        // post의 유저에게 문자 메세지 전송
        String message = "당신의 조각글에 편지가 도착했습니다\n" + "링크 : ";
        smsService.sendMessage(SmsReq.builder()
                .phone(phone)
                .message(message)
                .build());
    }
}
