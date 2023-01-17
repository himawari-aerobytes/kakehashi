package com.himawari.kakehashi.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationRuntimeException extends RuntimeException {
    private final String error = "処理を実行しましたがエラーが発生しました。";

    public ApplicationRuntimeException(Exception e, String className) {
        super("問題が発生しました", e);
        log.error(className + error, e.getMessage());
    }
}
