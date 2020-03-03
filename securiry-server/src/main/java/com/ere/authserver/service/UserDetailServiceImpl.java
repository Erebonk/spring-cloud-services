package com.ere.authserver.service;

import com.ere.authserver.domain.CompanyUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Custom user detail service
 *
 * @author ilya
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<CompanyUser> companyUserList = Arrays.asList(
                new CompanyUser(1, "usernl", bCryptPasswordEncoder.encode("usernl"), "USERNL"),
                new CompanyUser(2, "usernr", bCryptPasswordEncoder.encode("usernr"), "USERNR"),
                new CompanyUser(3, "admin", bCryptPasswordEncoder.encode("admin"), "ADMIN")
        );

        var userOpt = companyUserList.stream()
                .filter(companyUser -> companyUser.getUsername().equals(username))
                .map(companyUser -> {
                    var grantedAuthorities = AuthorityUtils
                            .commaSeparatedStringToAuthorityList("ROLE_" + companyUser.getRole());
                    return new User(companyUser.getUsername(), companyUser.getPassword(), grantedAuthorities);
                })
                .findFirst();
        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found."));
    }
}
