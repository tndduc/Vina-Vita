package com.ductn.VinaVita.components.twilio;

import com.ductn.VinaVita.configs.twilio.TwilioSmsSender;
import com.ductn.VinaVita.dto.SmsRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-twilio-sms-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/10/21
 * Time: 13.04
 */
@Service
public class SmsService {
    private final SmsSender smsSender;

    @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(SmsRequestDTO smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
