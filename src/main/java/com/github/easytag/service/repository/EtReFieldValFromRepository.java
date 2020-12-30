package com.github.easytag.service.repository;

import com.github.easytag.service.entity.EtReFieldValFrom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtReFieldValFromRepository extends JpaRepository<EtReFieldValFrom, Long> {

    EtReFieldValFrom getFirstByIdAndDeletedFalse(Long id);

}
