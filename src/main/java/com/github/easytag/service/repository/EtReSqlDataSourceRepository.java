package com.github.easytag.service.repository;

import com.github.easytag.service.entity.EtReSqlDataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtReSqlDataSourceRepository extends JpaRepository<EtReSqlDataSource, Long> {
    EtReSqlDataSource getFirstByIdAndDeletedFalse(Long id);
}
