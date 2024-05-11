package com.whatsapp.connector.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface MessageResponse {

    static final String url = "https://gw.cmtelecom.com/v1.0/message";
    static final String productToken = "YOUR_TOKEN";
    static final String from = "YOUR_ORGANIZATION_BUSINESSNUMBER";
    void replyToMessage(String to, String message) throws IOException;
}
