package net.dalistudio.entities.cms;

// Generated 2016-1-25 10:16:23 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.wangdali.common.source.entity.MyColumn;

/**
 * CmsContentFiles generated by hbm2java
 */
@Entity
@Table(name = "cms_content_file")
public class CmsContentFile implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @MyColumn(title = "ID")
    private Long id;
    @MyColumn(title = "内容", condition = true)
    private long contentId;
    @MyColumn(title = "上传用户", condition = true)
    private long userId;
    @MyColumn(title = "文件路径")
    private String filePath;
    @MyColumn(title = "是否图片", condition = true)
    private boolean image;
    @MyColumn(title = "大小", order = true)
    private int size;
    @MyColumn(title = "点击", order = true)
    private int clicks;
    @MyColumn(title = "排序")
    private int sort;
    @MyColumn(title = "描述")
    private String description;

    public CmsContentFile() {
    }

    public CmsContentFile(long contentId, long userId, String filePath, boolean image, int size, int clicks, int sort) {
        this.contentId = contentId;
        this.userId = userId;
        this.filePath = filePath;
        this.image = image;
        this.size = size;
        this.clicks = clicks;
        this.sort = sort;
    }

    public CmsContentFile(long contentId, long userId, String filePath, boolean image, int size, int clicks, int sort,
            String description) {
        this.contentId = contentId;
        this.userId = userId;
        this.filePath = filePath;
        this.image = image;
        this.size = size;
        this.clicks = clicks;
        this.sort = sort;
        this.description = description;
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

    @Column(name = "content_id", nullable = false)
    public long getContentId() {
        return this.contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "file_path", nullable = false)
    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Column(name = "image", nullable = false)
    public boolean isImage() {
        return this.image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    @Column(name = "size", nullable = false)
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Column(name = "clicks", nullable = false)
    public int getClicks() {
        return this.clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    @Column(name = "sort", nullable = false)
    public int getSort() {
        return this.sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}