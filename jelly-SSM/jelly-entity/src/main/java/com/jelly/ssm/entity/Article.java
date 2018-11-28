package com.jelly.ssm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public class Article implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer articleId;

    private String articleTitle;

    private String articleShortTitle;

    private String articleCategory;

    private String columnCategory;

    private Integer articleOrder;

    private String articleKeywords;

    private String articleSummary;

    private String articleAuthor;

    private String articleSource;

    private Boolean commentEnabled;

    private LocalDateTime commentStart;

    private LocalDateTime commentEnd;

    private String articleLogo;

    private String articleContent;

        /**
     * 字典 对应
     */
         private String articleStatus;

    private LocalDateTime articleAddtime;

    private LocalDateTime articleSubtime;

    private Integer articleTimes;


    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleShortTitle() {
        return articleShortTitle;
    }

    public void setArticleShortTitle(String articleShortTitle) {
        this.articleShortTitle = articleShortTitle;
    }

    public String getArticleCategory() {
        return articleCategory;
    }

    public void setArticleCategory(String articleCategory) {
        this.articleCategory = articleCategory;
    }

    public String getColumnCategory() {
        return columnCategory;
    }

    public void setColumnCategory(String columnCategory) {
        this.columnCategory = columnCategory;
    }

    public Integer getArticleOrder() {
        return articleOrder;
    }

    public void setArticleOrder(Integer articleOrder) {
        this.articleOrder = articleOrder;
    }

    public String getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    public String getArticleSummary() {
        return articleSummary;
    }

    public void setArticleSummary(String articleSummary) {
        this.articleSummary = articleSummary;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleSource() {
        return articleSource;
    }

    public void setArticleSource(String articleSource) {
        this.articleSource = articleSource;
    }

    public Boolean getCommentEnabled() {
        return commentEnabled;
    }

    public void setCommentEnabled(Boolean commentEnabled) {
        this.commentEnabled = commentEnabled;
    }

    public LocalDateTime getCommentStart() {
        return commentStart;
    }

    public void setCommentStart(LocalDateTime commentStart) {
        this.commentStart = commentStart;
    }

    public LocalDateTime getCommentEnd() {
        return commentEnd;
    }

    public void setCommentEnd(LocalDateTime commentEnd) {
        this.commentEnd = commentEnd;
    }

    public String getArticleLogo() {
        return articleLogo;
    }

    public void setArticleLogo(String articleLogo) {
        this.articleLogo = articleLogo;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public LocalDateTime getArticleAddtime() {
        return articleAddtime;
    }

    public void setArticleAddtime(LocalDateTime articleAddtime) {
        this.articleAddtime = articleAddtime;
    }

    public LocalDateTime getArticleSubtime() {
        return articleSubtime;
    }

    public void setArticleSubtime(LocalDateTime articleSubtime) {
        this.articleSubtime = articleSubtime;
    }

    public Integer getArticleTimes() {
        return articleTimes;
    }

    public void setArticleTimes(Integer articleTimes) {
        this.articleTimes = articleTimes;
    }

    @Override
    public String toString() {
        return "Article{" +
        "articleId=" + articleId +
        ", articleTitle=" + articleTitle +
        ", articleShortTitle=" + articleShortTitle +
        ", articleCategory=" + articleCategory +
        ", columnCategory=" + columnCategory +
        ", articleOrder=" + articleOrder +
        ", articleKeywords=" + articleKeywords +
        ", articleSummary=" + articleSummary +
        ", articleAuthor=" + articleAuthor +
        ", articleSource=" + articleSource +
        ", commentEnabled=" + commentEnabled +
        ", commentStart=" + commentStart +
        ", commentEnd=" + commentEnd +
        ", articleLogo=" + articleLogo +
        ", articleContent=" + articleContent +
        ", articleStatus=" + articleStatus +
        ", articleAddtime=" + articleAddtime +
        ", articleSubtime=" + articleSubtime +
        ", articleTimes=" + articleTimes +
        "}";
    }
}
