package com.ere.service.order.config;

import com.ere.service.order.domain.entity.BaseEntity;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class BeforeSaveListener extends AbstractMongoEventListener<BaseEntity> {

    @Override
    public void onBeforeSave(BeforeSaveEvent<BaseEntity> event) {
        if (event.getSource().getCreateAt() == null)
            event.getSource().setCreateAt(LocalDateTime.now());

        event.getSource().setLastModify(LocalDateTime.now());
        super.onBeforeSave(event);
    }
}
