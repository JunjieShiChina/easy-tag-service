package com.github.easytag.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 字段
 */
@Data
@Entity
@Table(name = "et_re_sql", indexes = {@Index(name="idx_data_source_id", columnList = "data_source_id")})
@org.hibernate.annotations.Table(appliesTo = "et_re_sql",comment="sql定义表")
public class EtReSql {
    @Id
    @Column(name = "id", columnDefinition="int(20) COMMENT 'id'")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_re_sql_item_sequence")
    @SequenceGenerator(name = "et_re_sql_item_sequence", sequenceName = "et_re_sql_item_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition="varchar(60) COMMENT '名称'")
    private String name;
    @Column(name = "exe_sql", nullable = false, columnDefinition="text COMMENT '需要执行的sql'")
    private String exeSql;
    @Column(name = "data_source_id", nullable = false, columnDefinition="int(20) COMMENT 'data_source_id'")
    private Long dataSourceId;
    @Column(name = "deleted", nullable = false, columnDefinition="tinyint(2) COMMENT '是否已删除'")
    private Boolean deleted;
    @Column(name = "create_time", nullable = false, columnDefinition="timestamp COMMENT '创建时间'")
    private Date createTime;
    @Column(name = "created_by", nullable = false, columnDefinition="varchar(20) COMMENT '创建者'")
    private String createdBy;
    @Column(name = "update_time", nullable = false, columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'")
    private Date updateTime;
    @Column(name = "updated_by", nullable = false, columnDefinition="varchar(20) COMMENT '更新者'")
    private String updatedBy;
}
