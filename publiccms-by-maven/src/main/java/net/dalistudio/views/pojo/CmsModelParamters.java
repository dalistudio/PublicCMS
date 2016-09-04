package net.dalistudio.views.pojo;

import java.util.List;

import net.dalistudio.entities.sys.SysExtendField;

public class CmsModelParamters implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    List<SysExtendField> contentExtends;

    public List<SysExtendField> getContentExtends() {
        return contentExtends;
    }

    public void setContentExtends(List<SysExtendField> contentExtends) {
        this.contentExtends = contentExtends;
    }
}
