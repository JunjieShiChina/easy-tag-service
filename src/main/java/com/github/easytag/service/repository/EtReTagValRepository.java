package com.github.easytag.service.repository;

import com.github.easytag.service.entity.EtReTagVal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtReTagValRepository extends JpaRepository<EtReTagVal, Long> {

    /**
     * 根据标签id查询标签变量
     * @param tagId
     * @return
     */
    List<EtReTagVal> queryByTagIdAndDeletedIsFalse(Long tagId);

}
