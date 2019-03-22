package org.f.study.spring.common.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * description
 *
 * @author f
 * @date 2019/3/19 15:48
 **/
@Data
public abstract class BaseModel implements Serializable {


    /**
     * PK
     */
    @Id
    private String id;


    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime ;

    /**
     * 创建时间
     */
    @Column(name = "update_time")
    private String updateTime ;

    /**
     * 1 表示删除，0 表示未删除
     */
    @Column(name = "is_deleted")
    private String isDeleted ;


}
