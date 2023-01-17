package com.himawari.kakehashi.service;

import com.himawari.kakehashi.domain.*;
import com.himawari.kakehashi.exception.HttpStatus404Exception;
import com.himawari.kakehashi.mapper.LoginUserMapper;
import com.himawari.kakehashi.mapper.MemberAdditionalMapper;
import com.himawari.kakehashi.mapper.MemberMapper;
import com.himawari.kakehashi.mapper.RoleMapper;
import com.himawari.kakehashi.serializable.MemberEntity;
import com.himawari.kakehashi.service.common.AWSCognitoService;
import com.himawari.kakehashi.util.GenUUID;
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
public class MemberService {
    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberAdditionalMapper memberAdditionalMapper;

    @Autowired
    private AWSCognitoService awsCognitoService;

    @Autowired
    private LoginUserMapper loginUserMapper;

    @Autowired
    private RoleMapper roleMapper;


    public List<MemberAdditional> getAllMember(LoginUserAdditional user) {
        final String role = user.getRole();
        log.info(awsCognitoService.getUserInfo(user.getEmail()).toString());


        if (LEVEL_ADMIN.equals(role)) {
            return memberAdditionalMapper.selectMemberAll();
        } else if (LEVEL_ZONE.equals(role)) {
            return memberAdditionalMapper.selectMemberZone(user.getZoneId());
        } else if (LEVEL_WARD.equals(role)) {
            return memberAdditionalMapper.selectMemberWard(user.getZoneId(), user.getWardId());
        } else if (LEVEL_HEADQUARTER.equals(role)) {
            return memberAdditionalMapper.selectMemberHeadquarter(user.getZoneId(), user.getWardId(), user.getHeadquarterId());
        } else {
            throw new BadCredentialsException("認証情報が間違っています");
        }
    }

    public MemberAdditional getMember(LoginUserAdditional user, int memberId) {
        final String role = user.getRole();
        final MemberExample example = new MemberExample();

        Optional<MemberAdditional> target = null;
        if (LEVEL_ADMIN.equals(role)) {
            target = memberAdditionalMapper
                    .selectMemberAllById(memberId)
                    .stream()
                    .findFirst();
        } else if (LEVEL_ZONE.equals(role)) {
            target = memberAdditionalMapper
                    .selectMemberZoneById(user.getZoneId(), memberId)
                    .stream()
                    .findFirst();
        } else if (LEVEL_WARD.equals(role)) {
            target = memberAdditionalMapper
                    .selectMemberWardById(user.getZoneId(), user.getWardId(), memberId)
                    .stream()
                    .findFirst();

        } else if (LEVEL_HEADQUARTER.equals(role)) {
            target = memberAdditionalMapper
                    .selectMemberHeadquarterById(user.getZoneId(), user.getWardId(), user.getHeadquarterId(), memberId)
                    .stream()
                    .findFirst();

        }

        if (target.isEmpty()) {
            log.debug("指定されたユーザーがいません" + example);
            throw new HttpStatus404Exception();
        }

        return target.get();


    }

    @Transactional
    public int delete(LoginUserAdditional user, int memberId) {
        final MemberExample example = new MemberExample();
        final String userRole = user.getRole();
        if (LEVEL_ADMIN.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(memberId);

        } else if (LEVEL_ZONE.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(memberId)
                    .andZoneIdEqualTo(user.getZoneId());
        } else if (LEVEL_WARD.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(memberId)
                    .andZoneIdEqualTo(user.getZoneId())
                    .andWardIdEqualTo(user.getWardId());
        } else if (LEVEL_HEADQUARTER.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(memberId)
                    .andZoneIdEqualTo(user.getZoneId())
                    .andWardIdEqualTo(user.getWardId())
                    .andHeadquarterIdEqualTo(user.getHeadquarterId());
        } else {
            log.debug("1件も削除されませんでした");
            return 0;
        }

        return memberMapper.deleteByExample(example);

    }

    @Transactional
    public int update(LoginUserAdditional user, MemberEntity member) {
        final Member newMember = Member
                .builder()
                .id(member.getId())
                .memberName(member.getMemberName())
                .address(member.getAddress())
                .grade(member.getGrade())
                .birthday(member.getBirthday())
                .note(member.getNote())
                .mobilePhone(member.getMobilePhone())
                .phone(member.getPhone())
                .canVisit(member.getCanVisit().byteValue())
                .citizenId(member.getCitizenId())
                .positionId(member.getPositionId())
                .examinationId(member.getExaminationId())
                .schoolId(member.getSchoolId())
                .districtId(member.getDistrictId())
                .branchId(member.getBranchId())
                .headquarterId(member.getHeadquarterId())
                .wardId(member.getWardId())
                .zoneId(member.getZoneId())
                .updatedat(new Date())
                .updatedby(user.getName())
                .build();

        if (LEVEL_ADMIN.equals(user.getRole())) {
            return memberMapper.insertSelective(newMember);
        } else if (LEVEL_ZONE.equals(user.getRole())
                && user.getZoneId() == member.getZoneId()) {
            return memberMapper.insertSelective(newMember);
        } else if (LEVEL_WARD.equals(user.getRole())
                && user.getZoneId() == member.getZoneId()
                && user.getWardId() == member.getWardId()) {
            return memberMapper.insertSelective(newMember);
        } else if (LEVEL_HEADQUARTER.equals(user.getRole())
                && user.getZoneId() == member.getZoneId()
                && user.getWardId() == member.getWardId()
                && user.getHeadquarterId() == member.getHeadquarterId()) {
            return memberMapper.insertSelective(newMember);
        } else {
            log.debug("Delete member : 次の情報は更新されませんでした。" + member);
            throw new HttpStatus404Exception();
        }
    }

    @Transactional
    public void createMember(LoginUserAdditional user, MemberEntity member) throws NoSuchFieldException {
        final String uuid = GenUUID.generate();
        final Member newMember = Member
                .builder()
                .uuid(uuid)
                .districtId(member.getDistrictId())
                .branchId(member.getBranchId())
                .headquarterId(member.getHeadquarterId())
                .wardId(member.getWardId())
                .zoneId(member.getZoneId())
                .positionId(member.getPositionId())
                .examinationId(member.getExaminationId())
                .schoolId(member.getSchoolId())
                .phone(member.getPhone())
                .mobilePhone(member.getMobilePhone())
                .memberName(member.getMemberName())
                .note(member.getNote())
                .citizenId(member.getCitizenId())
                .birthday(member.getBirthday())
                .address(member.getAddress())
                .canVisit(member.getCanVisit().byteValue())
                .grade(member.getGrade())
                .createdat(new Date())
                .createdby(user.getName())
                .updatedat(new Date())
                .updatedby(user.getName())
                .build();

        if (LEVEL_ADMIN.equals(user.getRole())) {
            memberMapper.insert(newMember);
        } else if (LEVEL_ZONE.equals(user.getRole()) && user.getZoneId() == member.getZoneId()) {
            memberMapper.insert(newMember);
        } else if (LEVEL_WARD.equals(user.getRole()) && user.getZoneId() == member.getZoneId() && user.getWardId() == member.getWardId()) {
            memberMapper.insert(newMember);
        } else if (LEVEL_HEADQUARTER.equals(user.getRole()) && user.getZoneId() == member.getZoneId() && user.getWardId() == member.getWardId() && user.getHeadquarterId() == member.getHeadquarterId()) {
            memberMapper.insert(newMember);
        } else {
            return;
        }

        if (member.getIsMakeLoginUser().equals("TRUE")) {
            final MemberExample example = new MemberExample();
            example.createCriteria().andUuidEqualTo(uuid);
            Optional<Member> createdMember = memberMapper.selectByExample(example).stream().findFirst();
            if (createdMember.isEmpty()) {
                log.error("DBに作成済みのユーザが存在しませんでした。DBコネクションを確かめてください。");
                throw new NoSuchFieldException();
            }

            final RoleExample roleExample = new RoleExample();
            roleExample
                    .createCriteria()
                    .andRoleNameEqualTo(member.getLevel());

            Optional<Role> role = roleMapper
                    .selectByExample(roleExample)
                    .stream()
                    .findFirst();

            if (role.isEmpty()) {
                log.debug("指定された権限は存在しません");
                throw new NoSuchFieldException();
            }

            if (LEVEL_ADMIN.equals(user.getRole())
                    || LEVEL_ZONE.equals(user.getRole()) && user.getZoneId() == member.getZoneId()
                    || LEVEL_WARD.equals(user.getRole()) && user.getZoneId() == member.getZoneId() && user.getWardId() == member.getWardId()
            ) {
                awsCognitoService.createLoginUser(member.getEmail(), member.getMemberName(), createdMember.get().getId(), role.get().getId());
                loginUserMapper.insert(
                        LoginUser
                                .builder()
                                .isenabled(1)
                                .loginUserName(member.getMemberName())
                                .email(member.getEmail())
                                .memberId(createdMember.get().getId())
                                .roleId(role.get().getId())
                                .updatedat(new Date())
                                .updatedby(user.getName())
                                .createdat(new Date())
                                .createdby(user.getName())
                                .build());

            } else {
                log.error("権限がありません");
            }

        } else {
            log.debug("Cognitoのユーザは作成されません");
        }


    }

}
