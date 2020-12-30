package com.github.easytag.service.repository;

import com.github.easytag.service.entity.EtReSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtReSqlRepository extends JpaRepository<EtReSql, Long> {

    EtReSql getFirstByIdAndDeletedFalse(Long etReSqlId);

}
