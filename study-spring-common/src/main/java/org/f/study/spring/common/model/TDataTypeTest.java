package org.f.study.spring.common.model;

import lombok.Data;
import org.f.study.spring.common.base.BaseModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "t_data_type_test")
public class TDataTypeTest extends BaseModel {


    /**
     * decimal
     */
    @Column(name = "data_type_decimal")
    private BigDecimal dataTypeDecimal;

    /**
     * varchar
     */
    @Column(name = "data_type_varchar")
    private String dataTypeVarchar;

    /**
     * datetime
     */
    @Column(name = "data_type_datetime")
    private Date dataTypeDatetime;

    /**
     * timestamp
     */
    @Column(name = "data_type_timestamp")
    private Date dataTypeTimestamp;



    public TDataTypeTest(){
    }

    public TDataTypeTest(String id){
        this.setId(id);
    }
}