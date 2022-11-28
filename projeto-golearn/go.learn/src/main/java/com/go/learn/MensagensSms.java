package com.go.learn;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MensagensSms {

    public static final String ACCOUNT_SID = "AC159d9f5c00c2cd0321ebb08bfaeecba5";
    public static final String AUTH_TOKEN = "da0903c0993c6ff4114df5e1755b8edf";
    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+55985242579"),
                new com.twilio.type.PhoneNumber("+14246221967"),
                "Testando o sms")
            .create();

        System.out.println(message.getSid());
    }
}
