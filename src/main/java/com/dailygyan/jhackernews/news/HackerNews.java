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
 * Main class of the library. Exposes all methods of the library.
 */
public interface HackerNews {

    /**
     * Gets the front page news.
     * 
     * @return the news
     */
    public Page getNews();

    /**
     * Gets the news by passing the id of page required.
     * 
     * @param id
     *            the id
     * @return the news
     */
    public Page getNews(String id);

    /**
     * Gets the news submitted by a user
     * 
     * @param userName
     *            the user name
     * @return the news submitted by userName
     */
    public Page getNewsSubmittedBy(String userName);

    /**
     * Gets the news submitted by a user (subsequent pages in the search)
     * 
     * @param userName
     *            the user name
     * @param id
     *            the id
     * @return the news submitted by
     */
    public Page getNewsSubmittedBy(String userName, String id);

    /**
     * Gets the latest news.
     * 
     * @return the new news
     */
    public Page getNewNews();

    /**
     * Gets the latest news (subsequent pages in the search)
     * 
     * @param id
     *            the id
     * @return the new news
     */
    public Page getNewNews(String id);

    /**
     * Gets the Ask HN pages.
     * 
     * @return the ask hn
     */
    public Page getAskHN();

    /**
     * Gets the Ask HN pages (subsequent pages in the search)
     * 
     * @param id
     *            the id
     * @return the ask hn
     */
    public Page getAskHN(String id);
}
