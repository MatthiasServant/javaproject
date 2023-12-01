package com.javaproject.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN("admin"),
    USER("admin:update")

    ;

    @Getter
    private final String permission;
}
