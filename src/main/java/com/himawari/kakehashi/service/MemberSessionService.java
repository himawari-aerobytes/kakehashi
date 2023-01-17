package com.himawari.kakehashi.service;

import com.himawari.kakehashi.domain.*;
import com.himawari.kakehashi.mapper.MemberMapper;
import com.himawari.kakehashi.mapper.MemberSessionAdditionalMapper;
import com.himawari.kakehashi.mapper.MemberSessionMapper;
import com.himawari.kakehashi.serializable.MemberSessionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.himawari.kakehashi.service.common.SystemConstants.*;

@Service
@Slf4j
public class MemberSessionService {

    @Autowired
    private MemberSessionAdditionalMapper memberSessionAdditionalMapper;
    @Autowired
    private MemberSessionMapper memberSessionMapper;

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberSessionAdditional> getAllMemberSession(LoginUserAdditional user) {
        final String role = user.getRole();
        if (LEVEL_ADMIN.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionAll();
        } else if (LEVEL_ZONE.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionZone(user.getZoneId());
        } else if (LEVEL_WARD.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionWard(user.getZoneId(), user.getWardId());
        } else if (LEVEL_HEADQUARTER.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionHeadquarter(user.getZoneId(), user.getWardId(), user.getHeadquarterId());
        } else {
            throw new BadCredentialsException("認証情報が間違っています");
        }

    }

    public List<MemberSessionAdditional> getMemberSessionByMemberId(LoginUserAdditional user, int memberId) {
        final String role = user.getRole();
        if (LEVEL_ADMIN.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionAllByMemberId(memberId);
        } else if (LEVEL_ZONE.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionZoneByMemberId(user.getZoneId(), memberId);
        } else if (LEVEL_WARD.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionWardByMemberId(user.getZoneId(), user.getWardId(), memberId);
        } else if (LEVEL_HEADQUARTER.equals(role)) {
            return memberSessionAdditionalMapper.selectMemberSessionHeadquarterByMemberId(user.getZoneId(), user.getWardId(), user.getHeadquarterId(), memberId);
        } else {
            throw new BadCredentialsException("認証情報が間違っています");
        }
    }

    @Transactional
    public int create(LoginUserAdditional user, MemberSessionEntity entity) {
        final MemberSession memberSession = MemberSession
                .builder()
                .memberId(entity.getMemberId())
                .admMemberId(entity.getAdmMemberId())
                .type(entity.getType())
                .note(entity.getNote())
                .createdat(new Date())
                .createdby(user.getName())
                .updatedat(new Date())
                .updatedby(user.getName())
                .build();

        return memberSessionMapper.insertSelective(memberSession);

    }

    @Transactional
    public int delete(LoginUserAdditional user, int memberId) {
        final MemberSessionExample example = new MemberSessionExample();
        final String userRole = user.getRole();
        final Member member = getMember(memberId).get();


        if (LEVEL_ADMIN.equals(userRole)
                || (LEVEL_ZONE.equals(userRole) && member.getZoneId() == user.getZoneId())
                || (LEVEL_WARD.equals(userRole) && member.getWardId() == user.getWardId())
                || (LEVEL_HEADQUARTER.equals(userRole) && member.getHeadquarterId() == user.getHeadquarterId())) {

            example
                    .createCriteria()
                    .andIdEqualTo(memberId);

            log.debug("Delete MemberSession" + user.getMemberName() + example);
            return memberSessionMapper.deleteByExample(example);

        } else {
            log.debug("1件も削除されませんでした");
            return 0;
        }


    }

    private Optional<Member> getMember(int memberId) {
        final MemberExample example = new MemberExample();
        example
                .createCriteria()
                .andIdEqualTo(memberId);

        return memberMapper
                .selectByExample(example)
                .stream()
                .findFirst();


    }


}
