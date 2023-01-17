package com.himawari.kakehashi.service;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import com.himawari.kakehashi.domain.TimeLineAdditional;
import com.himawari.kakehashi.domain.Timeline;
import com.himawari.kakehashi.domain.TimelineExample;
import com.himawari.kakehashi.mapper.TimelineAdditionalMapper;
import com.himawari.kakehashi.mapper.TimelineMapper;
import com.himawari.kakehashi.serializable.TimeLineEntity;
import com.himawari.kakehashi.service.common.MessageSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import static com.himawari.kakehashi.service.common.SystemConstants.*;

@Service
@Slf4j
public class TimeLineService {
    @Autowired
    private TimelineMapper timelineMapper;
    @Autowired
    private MessageSourceService messageSourceService;
    @Autowired
    private TimelineAdditionalMapper timelineAdditionalMapper;

    public List<TimeLineAdditional> get(LoginUserAdditional user) throws BadCredentialsException {
        log.debug("Get Timeline " + user.getName());
        if (LEVEL_ADMIN.equals(user.getRole())) {
            return timelineAdditionalMapper.selectTimeLineAll();
        } else if (LEVEL_ZONE.equals(user.getRole())) {
            return timelineAdditionalMapper.selectTimeLineZone(user.getZoneId());
        } else if (LEVEL_WARD.equals(user.getRole())) {
            return timelineAdditionalMapper.selectTimeLineWard(user.getZoneId(), user.getWardId());
        } else if (LEVEL_HEADQUARTER.equals(user.getRole())) {
            return timelineAdditionalMapper.selectTimeLineHeadquarter(user.getZoneId(), user.getWardId(), user.getHeadquarterId());
        } else {
            throw new BadCredentialsException(messageSourceService.getMessage(ERROR_001, user.toString()));
        }

    }

    @Transactional
    public int create(LoginUserAdditional user, TimeLineEntity timeline) {
        final Timeline newTimeLine = Timeline
                .builder()
                .memberId(user.getMemberId())
                .zoneId(user.getZoneId())
                .wardId(user.getWardId())
                .headquarterId(user.getHeadquarterId())
                .branchId(user.getBranchId())
                .districtId(user.getDistrictId())
                .comment(timeline.getComment())
                .updatedat(new Date())
                .createdat(new Date())
                .updatedby(user.getName())
                .createdby(user.getName())
                .build();
        log.debug("Create Timeline " + user.getName() + timeline);
        return timelineMapper.insertSelective(newTimeLine);
    }

    @Transactional
    public int delete(LoginUserAdditional user, int timelineId) throws BadCredentialsException {
        final TimelineExample example = new TimelineExample();
        final String userRole = user.getRole();

        if (LEVEL_ADMIN.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(timelineId);


        } else if (LEVEL_ZONE.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(timelineId)
                    .andZoneIdEqualTo(user.getZoneId());

        } else if (LEVEL_WARD.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(timelineId)
                    .andZoneIdEqualTo(user.getZoneId())
                    .andWardIdEqualTo(user.getWardId());

        } else if (LEVEL_HEADQUARTER.equals(userRole)) {
            example
                    .createCriteria()
                    .andIdEqualTo(timelineId)
                    .andZoneIdEqualTo(user.getZoneId())
                    .andWardIdEqualTo(user.getWardId())
                    .andHeadquarterIdEqualTo(user.getHeadquarterId());

        } else {
            throw new BadCredentialsException(messageSourceService.getMessage(ERROR_001, user.toString()));
        }
        log.debug("Delete Timeline " + user.getName() + example);
        return timelineMapper.deleteByExample(example);


    }

    @Transactional
    public int update(LoginUserAdditional user, TimeLineEntity timeline) {
        final Timeline newTimeline = Timeline
                .builder()
                .id(timeline.getId())
                .comment(timeline.getComment())
                .updatedat(new Date())
                .updatedby(user.getName())
                .build();

        // 自分の作成したものを更新可能
        if (!LEVEL_ADMIN.equals(user.getRole())) {
            newTimeline.setMemberId(user.getMemberId());
            newTimeline.setZoneId(user.getZoneId());
            newTimeline.setWardId(user.getWardId());
            newTimeline.setHeadquarterId(user.getHeadquarterId());
            newTimeline.setBranchId(user.getBranchId());
            newTimeline.setDistrictId(user.getDistrictId());
        }

        log.debug("Update Timeline " + user.getName() + timeline);
        return timelineAdditionalMapper.updateByKeySelective(newTimeline);

    }


}


