package za.co.rettakid.gains.persistence.listener;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;
import za.co.rettakid.gains.common.dto.UserDto;
import za.co.rettakid.gains.persistence.entity.RevisionInfoEntity;

import java.util.Date;

/**
 * Created by LWAZI8 on 15/12/2015.
 */
public class CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object obj) {
        UserDto userDto = (UserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RevisionInfoEntity revisionInfoEntity = (RevisionInfoEntity)obj;
        revisionInfoEntity.setUserId(userDto.getUserId());
        revisionInfoEntity.setDateChanged(new Date());
    }

}
