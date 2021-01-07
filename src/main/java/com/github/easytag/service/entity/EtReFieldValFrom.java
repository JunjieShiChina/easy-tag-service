package com.github.easytag.service.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 字段
 */
@Data
@Entity
@Table(name = "et_re_field_val_from", indexes = {@Index(name="idx_sql_id", columnList = "sql_id")})
@org.hibernate.annotations.Table(appliesTo = "et_re_field_val_from",comment="字段来源表")
public class EtReFieldValFrom {
    @Id
    @Column(name = "id", columnDefinition="int(20) COMMENT 'id'")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "et_re_field_val_from_item_sequence")
    @SequenceGenerator(name = "et_re_field_val_from_item_sequence", sequenceName = "et_re_field_val_from_item_sequence", allocationSize = 1)
    private Long id;
    @Column(name = "from_type", nullable = false, columnDefinition="int(2) COMMENT '来源类型'")
    private Integer fromType;
    @Column(name = "fix_val", nullable = true, columnDefinition="varchar(255) COMMENT '固定值'")
    private String fixVal;
    @Column(name = "sql_id", nullable = true, columnDefinition="int(20) COMMENT 'sql_id'")
    private Long sqlId;
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
