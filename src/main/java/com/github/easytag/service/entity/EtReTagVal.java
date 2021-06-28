package com.github.easytag.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 表达式变量表
 */
@Data
@Entity
@Table(name = "et_re_tag_val", indexes = {@Index(name="idx_tag_id", columnList = "tag_id")})
@org.hibernate.annotations.Table(appliesTo = "et_re_tag_val",comment="表达式变量表")
public class EtReTagVal {
    @Id
    @Column(name = "id", columnDefinition="int(20) COMMENT 'id'")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_re_tag_val_item_sequence")
    @SequenceGenerator(name = "et_re_tag_val_item_sequence", sequenceName = "et_re_tag_val_item_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "tag_id", nullable = false, columnDefinition="int(20) COMMENT '标签id'")
    private Long tagId;
    @Column(name = "val_name", nullable = false, columnDefinition="varchar(60) COMMENT '变量名称'")
    private String valName;
    @Column(name = "val_value", nullable = false, columnDefinition="varchar(60) COMMENT '变量值'")
    private String valValue;
    @Column(name = "val_type", nullable = false, columnDefinition="int(2) COMMENT '变量类型 0:常量 1:字段'")
    private Integer valType;
    @Column(name = "val_data_type", nullable = true, columnDefinition="int(2) COMMENT '变量数据类型'")
    private Integer valDataType;
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
