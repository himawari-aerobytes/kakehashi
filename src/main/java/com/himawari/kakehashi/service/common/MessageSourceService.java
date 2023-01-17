package com.himawari.kakehashi.service.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class MessageSourceService {

    private org.springframework.context.MessageSource messageSource;

    public String getMessage(String messageCode, String... additionalMessage) {
        final String message = messageSource.getMessage(messageCode, additionalMessage, Locale.JAPAN);
        log.debug(message);

        return message;
    }

}
