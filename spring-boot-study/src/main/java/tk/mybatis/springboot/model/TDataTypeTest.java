package tk.mybatis.springboot.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_data_type_test")
public class TDataTypeTest {
    /**
     * PK
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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

    /**
     * 获取PK
     *
     * @return id - PK
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置PK
     *
     * @param id PK
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取decimal
     *
     * @return data_type_decimal - decimal
     */
    public BigDecimal getDataTypeDecimal() {
        return dataTypeDecimal;
    }

    /**
     * 设置decimal
     *
     * @param dataTypeDecimal decimal
     */
    public void setDataTypeDecimal(BigDecimal dataTypeDecimal) {
        this.dataTypeDecimal = dataTypeDecimal;
    }

    /**
     * 获取varchar
     *
     * @return data_type_varchar - varchar
     */
    public String getDataTypeVarchar() {
        return dataTypeVarchar;
    }

    /**
     * 设置varchar
     *
     * @param dataTypeVarchar varchar
     */
    public void setDataTypeVarchar(String dataTypeVarchar) {
        this.dataTypeVarchar = dataTypeVarchar;
    }

    /**
     * 获取datetime
     *
     * @return data_type_datetime - datetime
     */
    public Date getDataTypeDatetime() {
        return dataTypeDatetime;
    }

    /**
     * 设置datetime
     *
     * @param dataTypeDatetime datetime
     */
    public void setDataTypeDatetime(Date dataTypeDatetime) {
        this.dataTypeDatetime = dataTypeDatetime;
    }

    /**
     * 获取timestamp
     *
     * @return data_type_timestamp - timestamp
     */
    public Date getDataTypeTimestamp() {
        return dataTypeTimestamp;
    }

    /**
     * 设置timestamp
     *
     * @param dataTypeTimestamp timestamp
     */
    public void setDataTypeTimestamp(Date dataTypeTimestamp) {
        this.dataTypeTimestamp = dataTypeTimestamp;
    }
}