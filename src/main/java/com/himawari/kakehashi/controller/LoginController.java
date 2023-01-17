package com.himawari.kakehashi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @GetMapping(value = "/login")
    public String oauth2SuccessPortal(@AuthenticationPrincipal OidcUser oidcUser
            , OAuth2AuthenticationToken oAuth2AuthenticationToken, Model model) {

        return "login";

    }

    @PostMapping(value = "/welcome")
    public String welcome(@AuthenticationPrincipal OidcUser oidcUser
            , OAuth2AuthenticationToken oAuth2AuthenticationToken, Model model) {
        model.addAttribute("name", oAuth2AuthenticationToken.getName());

        return "welcome";
    }

    @GetMapping(value = "/welcome")
    public String welcomeIndex(@AuthenticationPrincipal OidcUser oidcUser
            , OAuth2AuthenticationToken oAuth2AuthenticationToken, Model model) {
        model.addAttribute("name", oAuth2AuthenticationToken.getName());

        return "welcome";
    }


}
