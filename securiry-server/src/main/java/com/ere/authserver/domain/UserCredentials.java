package com.ere.authserver.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCredentials {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

}
