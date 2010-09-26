/*
 * Copyright (C) 2010 Anoop Engineer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dailygyan.jhackernews.news;

/**
 * The Class that represents a news item. The page element will contain a list
 * of News objects
 */
public class News {

    /** The title of the news. */
    String title;

    /** The url of the news page. */
    String url;

    /** The id. */
    Long id;

    /** The comment count. */
    int commentCount;

    /** The points. */
    int points;

    /** Time as a human readable string when the news was posted */
    String postedAgo;

    /** The username. */
    String postedBy;
    
    

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }



    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }



    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }



    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }



    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }



    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }



    /**
     * @return the commentCount
     */
    public int getCommentCount() {
        return commentCount;
    }



    /**
     * @param commentCount the commentCount to set
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }



    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }



    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }



    /**
     * @return the postedAgo
     */
    public String getPostedAgo() {
        return postedAgo;
    }



    /**
     * @param postedAgo the postedAgo to set
     */
    public void setPostedAgo(String postedAgo) {
        this.postedAgo = postedAgo;
    }



    /**
     * @return the postedBy
     */
    public String getPostedBy() {
        return postedBy;
    }



    /**
     * @param postedBy the postedBy to set
     */
    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }



    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("title = ");
        builder.append(title);
        builder.append('\n');

        builder.append("url = ");
        builder.append(url);
        builder.append('\n');

        builder.append("id = ");
        builder.append(id);
        builder.append('\n');

        builder.append("commentCount = ");
        builder.append(commentCount);
        builder.append('\n');

        builder.append("points = ");
        builder.append(points);
        builder.append('\n');

        builder.append("postedAgo = ");
        builder.append(postedAgo);
        builder.append('\n');

        builder.append("postedBy = ");
        builder.append(postedBy);
        builder.append('\n');

        return builder.toString();
    }

}
