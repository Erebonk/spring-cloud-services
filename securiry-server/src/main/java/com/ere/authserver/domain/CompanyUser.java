package com.ere.authserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Simple user
 *
 * @author ilya
 * @version 1.0
 */
@Data
@AllArgsConstructor
public class CompanyUser {

    private Integer id;

    private String username;

    private String password;

    private String role;

}
