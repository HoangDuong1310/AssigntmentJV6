package com.example.finalproject.dao;

import com.example.finalproject.entitys.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDAO extends JpaRepository<AccountEntity, String> {
@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN ('DIRE', 'STAF')")
    List<AccountEntity> getAdministrators();
}
