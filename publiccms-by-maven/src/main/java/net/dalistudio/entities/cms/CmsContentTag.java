package net.dalistudio.entities.cms;

// Generated 2016-1-19 11:28:06 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.wangdali.common.source.entity.MyColumn;

/**
 * CmsContentTag generated by hbm2java
 */
@Entity
@Table(name = "cms_content_tag")
public class CmsContentTag implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "ID")
    private Long id;
    @MyColumn(title = "标签")
    private long tagId;
    @MyColumn(title = "内容")
    private long contentId;

    public CmsContentTag() {
    }

    public CmsContentTag(long tagId, long contentId) {
        this.tagId = tagId;
        this.contentId = contentId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "tag_id", nullable = false)
    public long getTagId() {
        return this.tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    @Column(name = "content_id", nullable = false)
    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

}
