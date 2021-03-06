package net.dalistudio.entities.sys;

// Generated 2016-3-2 13:36:22 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.wangdali.common.source.entity.MyColumn;

/**
 * SysExtendField generated by hbm2java
 */
@Entity
@Table(name = "sys_extend_field")
public class SysExtendField implements java.io.Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "ID")
    private Integer id;
    @MyColumn(title = "扩展ID", condition = true)
    private int extendId;
    @MyColumn(title = "必填")
    private boolean required;
    @MyColumn(title = "名称")
    private String name;
    @MyColumn(title = "描述")
    private String description;
    @MyColumn(title = "字段")
    private String code;
    @MyColumn(title = "表单类型")
    private String inputType;
    @MyColumn(title = "默认值")
    private String defaultValue;

    public SysExtendField() {
    }

    public SysExtendField(int extendId, boolean required, String name, String code, String inputType) {
        this.extendId = extendId;
        this.required = required;
        this.name = name;
        this.code = code;
        this.inputType = inputType;
    }

    public SysExtendField(int extendId, boolean required, String name, String description, String code, String inputType,
            String defaultValue) {
        this.extendId = extendId;
        this.required = required;
        this.name = name;
        this.description = description;
        this.code = code;
        this.inputType = inputType;
        this.defaultValue = defaultValue;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "extend_id", nullable = false)
    public int getExtendId() {
        return this.extendId;
    }

    public void setExtendId(int extendId) {
        this.extendId = extendId;
    }

    @Column(name = "required", nullable = false)
    public boolean isRequired() {
        return this.required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    @Column(name = "name", nullable = false, length = 20)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", length = 100)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "code", nullable = false, length = 20)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "input_type", nullable = false, length = 20)
    public String getInputType() {
        return this.inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    @Column(name = "default_value", length = 50)
    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

}
