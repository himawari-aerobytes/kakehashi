package com.himawari.kakehashi.controller;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import com.himawari.kakehashi.domain.MemberSessionAdditional;
import com.himawari.kakehashi.serializable.MemberSessionEntity;
import com.himawari.kakehashi.service.MemberSessionService;
import com.himawari.kakehashi.service.common.UserCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MemberSessionController {

    @Autowired
    private MemberSessionService memberSessionService;

    @Autowired
    private UserCommonService userCommonService;

    @GetMapping("/session")
    @ResponseBody
    public List<MemberSessionAdditional> getAll(@AuthenticationPrincipal OidcUser oidcUser) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        final List<MemberSessionAdditional> memberSessionAdditionalList = memberSessionService.getAllMemberSession(user);

        if (memberSessionAdditionalList == null || memberSessionAdditionalList.isEmpty()) {
            return new ArrayList<>();
        }

        return memberSessionAdditionalList;

    }

    @GetMapping("/member/{id:[0-9]+}/session/")
    @ResponseBody
    public List<MemberSessionAdditional> get(@AuthenticationPrincipal OidcUser oidcUser, @PathVariable("id") int id) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        final List<MemberSessionAdditional> memberSessionAdditionalList = memberSessionService
                .getMemberSessionByMemberId(user, id);
        if (memberSessionAdditionalList == null || memberSessionAdditionalList.isEmpty()) {
            return new ArrayList<>();
        }

        return memberSessionAdditionalList;
    }

    @PostMapping("/session/")
    @ResponseBody
    public List<MemberSessionEntity> create(@AuthenticationPrincipal OidcUser oidcUser, @RequestBody MemberSessionEntity memberSessionEntity) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        memberSessionService.create(user, memberSessionEntity);

        return new ArrayList<>();


    }

    /*TODO 未実装*/
    @PutMapping("/member/{id:[0-9]+}/session/{sessionId:[0-9]+}")
    @ResponseBody
    public List<MemberSessionAdditional> update(@AuthenticationPrincipal OidcUser oidcUser, @RequestBody MemberSessionEntity memberSession) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());

        return new ArrayList<>();

    }

    @DeleteMapping("/session/{sessionId:[0-9]+}")
    @ResponseBody
    public List<MemberSessionAdditional> delete(@AuthenticationPrincipal OidcUser oidcUser, @PathParam("sessionId") String id) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        memberSessionService.delete(user, Integer.parseInt(id));

        return new ArrayList<>();

    }

}
