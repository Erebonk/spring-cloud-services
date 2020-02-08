package com.ere.service.order.domain.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private LocalDateTime lastModify, createAt;

}
