package com.list.todolist;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class SMS {

    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC094faa1b8edda9e300224ef60ae8e47a";
    public static final String AUTH_TOKEN = "9266229c7ef57aee437643a5f7d0087b";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber("+1-901-619-9413"),
                new PhoneNumber("+1-901-245-5785"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

        System.out.println(message.getSid());
    }




}
