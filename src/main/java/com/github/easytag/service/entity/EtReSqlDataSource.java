package com.github.easytag.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 字段
 */
@Data
@Entity
@Table(name = "et_re_sql_data_source")
@org.hibernate.annotations.Table(appliesTo = "et_re_sql_data_source",comment="sql数据源表")
public class EtReSqlDataSource {
    @Id
    @Column(name = "id", columnDefinition="int(20) COMMENT 'id'")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_re_sql_data_source_item_sequence")
    @SequenceGenerator(name = "et_re_sql_data_source_item_sequence", sequenceName = "et_re_sql_data_source_item_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition="varchar(60) COMMENT '名称'")
    private String name;
    @Column(name = "url", nullable = false, columnDefinition="varchar(255) COMMENT 'url'")
    private String url;
    @Column(name = "driver_type", nullable = false, columnDefinition="varchar(255) COMMENT '驱动类型'")
    private String driverType;
    @Column(name = "user_name", nullable = false, columnDefinition="varchar(255) COMMENT 'user_name'")
    private String userName;
    @Column(name = "password", nullable = false, columnDefinition="varchar(255) COMMENT 'password'")
    private String password;
    @Column(name = "deleted", nullable = true, columnDefinition="tinyint(2) COMMENT '是否已删除'")
    private Boolean deleted;
    @Column(name = "create_time", nullable = true, columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime;
    @Column(name = "created_by", nullable = true, columnDefinition="varchar(20) COMMENT '创建者'")
    private String createdBy;
    @Column(name = "update_time", nullable = false, columnDefinition="timestamp DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间'")
    private Date updateTime;
    @Column(name = "updated_by", nullable = false, columnDefinition="varchar(20) COMMENT '更新者'")
    private String updatedBy;
}
