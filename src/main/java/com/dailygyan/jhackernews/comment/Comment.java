package com.dailygyan.jhackernews.comment;

import java.util.List;

public class Comment {

    String postedBy;

    String postedAgo;

    String comment;

    Long id;

    int points;

    Long parentId;

    Long postId;

    String cachedOn;

    List<Comment> children;

    /**
     * @return the postedBy
     */
    public String getPostedBy() {
        return postedBy;
    }

    /**
     * @return the postedAgo
     */
    public String getPostedAgo() {
        return postedAgo;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return the parentId
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @return the postId
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * @return the cachedOn
     */
    public String getCachedOn() {
        return cachedOn;
    }

    /**
     * @return the children
     */
    public List<Comment> getChildren() {
        return children;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Comment [cachedOn=" + cachedOn + ", children count="
                + children.size() + ", comment=" + comment + ", id=" + id
                + ", parentId=" + parentId + ", points=" + points + ", postId="
                + postId + ", postedAgo=" + postedAgo + ", postedBy="
                + postedBy + "]";
    }
}
