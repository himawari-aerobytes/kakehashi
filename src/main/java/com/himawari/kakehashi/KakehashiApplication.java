package com.himawari.kakehashi;

import com.himawari.kakehashi.exception.ApplicationRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@Slf4j
public class KakehashiApplication {

    public static void main(String[] args) throws Exception {
        try {
            log.info("システムを起動を開始します");
            SpringApplication.run(KakehashiApplication.class, args);
            log.info("システムを開始しました");
        } catch (Exception e) {
            log.error("システムは異常終了しました", e);
            throw new ApplicationRuntimeException(e, KakehashiApplication.class.getName());
        }

    }

}
