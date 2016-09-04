package net.dalistudio.views.pojo;

import java.util.List;

import net.dalistudio.entities.sys.SysExtendField;

public class CmsCategoryTypeParamters implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private List<SysExtendField> categoryExtends;

    public List<SysExtendField> getCategoryExtends() {
        return categoryExtends;
    }

    public void setCategoryExtends(List<SysExtendField> categoryExtends) {
        this.categoryExtends = categoryExtends;
    }
}