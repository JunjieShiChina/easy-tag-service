package com.github.easytag.service.repository;

import com.github.easytag.service.entity.EtReField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtReFieldRepository extends JpaRepository<EtReField, Long> {

    EtReField getFirstByIdAndDeletedFalse(Long id);

}
