package com.ere.service.account.repository;

import com.ere.service.account.domain.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Account repository
 *
 * @author ilya
 * @version 1.0
 */
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {}
