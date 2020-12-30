package com.github.easytag.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 字段
 */
@Data
@Entity
@Table(name = "et_re_field", indexes = {@Index(name="idx_val_from_id", columnList = "val_from_id")})
@org.hibernate.annotations.Table(appliesTo = "et_re_field",comment="字段表")
public class EtReField {
    @Id
    @Column(name = "id", columnDefinition="int(20) COMMENT 'id'")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_re_field_item_sequence")
    @SequenceGenerator(name = "et_re_field_item_sequence", sequenceName = "et_re_field_item_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "name", nullable = false, columnDefinition="varchar(60) COMMENT '字段名称'")
    private String name;
    @Column(name = "val_from_id", nullable = false, columnDefinition="int(20) COMMENT 'val_from_id'")
    private Long valFromId;
    @Column(name = "data_type", nullable = false, columnDefinition="int(2) COMMENT '数据类型'")
    private Integer dataType;
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
