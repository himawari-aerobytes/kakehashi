package com.himawari.kakehashi.controller;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import com.himawari.kakehashi.domain.Member;
import com.himawari.kakehashi.domain.MemberAdditional;
import com.himawari.kakehashi.serializable.MemberEntity;
import com.himawari.kakehashi.service.MemberService;
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
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private UserCommonService userCommonService;

    @GetMapping("/member")
    @ResponseBody
    public List<MemberAdditional> get(@AuthenticationPrincipal OidcUser oidcUser) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        final List<MemberAdditional> memberAdditionalList = memberService.getAllMember(user);


        if (memberAdditionalList.isEmpty()) {
            return new ArrayList<>();
        }

        return memberAdditionalList;

    }

    @PostMapping("/member")
    @ResponseBody
    public List<Member> create(@AuthenticationPrincipal OidcUser oidcUser, @RequestBody MemberEntity member) throws NoSuchFieldException {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        log.debug(user.toString());
        memberService.createMember(user, member);

        return new ArrayList<>();

    }

    @PutMapping("/member/{id:[0-9]+}")
    @ResponseBody
    public List<Member> update(@AuthenticationPrincipal OidcUser oidcUser, @PathParam("id") String id, @RequestBody MemberEntity member) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        member.setId(Integer.parseInt(id));
        final int update = memberService.update(user, member);

        log.debug("Member Updated: " + update + "件更新しました");
        log.debug("Member Updated: " + member);
        return new ArrayList<>();

    }

    @DeleteMapping("/member/{id:[0-9]+}")
    @ResponseBody
    public List<Member> delete(@AuthenticationPrincipal OidcUser oidcUser, @PathParam("id") String id) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        memberService.delete(user, Integer.parseInt(id));

        return new ArrayList<>();

    }


}
