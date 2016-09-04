package net.dalistudio.entities.cms;

//Generated 2016-1-19 11:28:06 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wangdali.common.source.entity.MyColumn;

/**
 * CmsContentAttribute generated by hbm2java
 */
@Entity
@Table(name = "cms_content_attribute")
public class CmsContentAttribute implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "内容")
    private long contentId;
    @MyColumn(title = "来源")
    private String source;
    @MyColumn(title = "来源地址")
    private String sourceUrl;
    @MyColumn(title = "扩展数据")
    private String data;
    @MyColumn(title = "文本")
    private String text;
    @MyColumn(title = "字数")
    private int wordCount;

    public CmsContentAttribute() {
    }

    public CmsContentAttribute(long contentId, int wordCount) {
        this.contentId = contentId;
        this.wordCount = wordCount;
    }

    public CmsContentAttribute(long contentId, String source, String sourceUrl, String data, String text, int wordCount) {
        this.contentId = contentId;
        this.source = source;
        this.sourceUrl = sourceUrl;
        this.data = data;
        this.text = text;
        this.wordCount = wordCount;
    }

    @Id
    @Column(name = "content_id", unique = true, nullable = false)
    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    @Column(name = "source", length = 50)
    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Column(name = "source_url", length = 2048)
    public String getSourceUrl() {
        return this.sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Column(name = "data")
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "text", length = 65535)
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "word_count", nullable = false)
    public int getWordCount() {
        return this.wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

}
