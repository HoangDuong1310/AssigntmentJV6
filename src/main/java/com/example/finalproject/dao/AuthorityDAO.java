package com.example.finalproject.dao;

import com.example.finalproject.entitys.AccountEntity;
import com.example.finalproject.entitys.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {
   @Query("SELECT DISTINCT a FROM Authority a WHERE a.account IN ?1")
    List<Authority> authoritiesOf(List<AccountEntity> accounts);
}
