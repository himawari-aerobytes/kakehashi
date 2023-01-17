package com.himawari.kakehashi.controller;

import com.himawari.kakehashi.domain.LoginUserAdditional;
import com.himawari.kakehashi.domain.TimeLineAdditional;
import com.himawari.kakehashi.domain.Timeline;
import com.himawari.kakehashi.serializable.TimeLineEntity;
import com.himawari.kakehashi.service.TimeLineService;
import com.himawari.kakehashi.service.common.UserCommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class TimeLineController {
    @Autowired
    private TimeLineService timeLineService;
    @Autowired
    private UserCommonService userCommonService;

    @GetMapping("/timeline")
    @ResponseBody
    public List<TimeLineAdditional> getTimeline(@AuthenticationPrincipal OidcUser oidcUser) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(oidcUser.getEmail());
        final List<TimeLineAdditional> timelines = timeLineService.get(user);

        if (timelines == null) {
            return new ArrayList<>();
        }
        return timeLineService.get(user);
    }

    @PostMapping("/timeline")
    @ResponseBody
    public List<TimeLineEntity> createTimeline(@AuthenticationPrincipal UserDetails userDetails, @RequestBody TimeLineEntity timeline) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(userDetails.getUsername());
        timeLineService.create(user, timeline);
        log.debug("タイムライン作成 " + timeline);

        final List<TimeLineEntity> timelineEntities = new ArrayList<>();
        timelineEntities.add(timeline);
        return timelineEntities;
    }

    @DeleteMapping("/timeline/{id:[0-9]+}")
    @ResponseBody
    public List<Timeline> deleteTimeline(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") String timelineId) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(userDetails.getUsername());
        final int convertedId = Integer.parseInt(timelineId);

        timeLineService.delete(user, convertedId);
        return new ArrayList<>();
    }

    @PutMapping("/timeline/{id:[0-9]+}")
    @ResponseBody
    public List<Timeline> updateTimeline(@AuthenticationPrincipal UserDetails userDetails, @PathVariable("id") String timelineId, @RequestBody TimeLineEntity timeline) {
        final LoginUserAdditional user = userCommonService.getUserByLoginUserName(userDetails.getUsername());
        final int convertedId = Integer.parseInt(timelineId);
        timeline.setId(convertedId);
        timeLineService.update(user, timeline);
        return new ArrayList<>();

    }
}
