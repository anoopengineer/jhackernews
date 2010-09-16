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
package com.dailygyan.jhackernews.news.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.dailygyan.jhackernews.news.HackerNews;
import com.dailygyan.jhackernews.news.Page;
import com.google.gson.Gson;

/**
 * The Class HackerNewsImpl.
 */
public class HackerNewsImpl implements HackerNews {

    /** The gson. */
    private Gson gson;

    /**
     * Instantiates a new hacker news impl.
     */
    public HackerNewsImpl() {
        gson = new Gson();
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getAskHN()
     */
    public Page getAskHN() {
        return fetchPage("http://api.ihackernews.com/ask");
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getAskHN(java.lang.String)
     */
    public Page getAskHN(String id) {
        return fetchPage("http://api.ihackernews.com/ask/" + id);
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNewNews()
     */
    public Page getNewNews() {
        return fetchPage("http://api.ihackernews.com/new");
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNewNews(java.lang.String)
     */
    public Page getNewNews(String id) {
        return fetchPage("http://api.ihackernews.com/new/" + id);
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNews()
     */
    public Page getNews() {
        return fetchPage("http://api.ihackernews.com/page");
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNews(java.lang.String)
     */
    public Page getNews(String id) {
        return fetchPage("http://api.ihackernews.com/page/" + id);
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNewsSubmittedBy(java.lang.String)
     */
    public Page getNewsSubmittedBy(String userName) {
        return fetchPage("http://api.ihackernews.com/by/" + userName);
    }

    /* (non-Javadoc)
     * @see com.dailygyan.hackernews.HackerNews#getNewsSubmittedBy(java.lang.String, java.lang.String)
     */
    public Page getNewsSubmittedBy(String userName, String id) {
        return fetchPage("http://api.ihackernews.com/by/" + userName + "/" + id);
    }

    /**
     * Fetch page.
     * 
     * @param urlString the url string
     * @return the page
     */
    private Page fetchPage(String urlString) {
        URL url = null;
        Page page = null;
        try {
            url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn
                    .getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String inputLine = null;

            while ((inputLine = in.readLine()) != null) {
                buffer.append(inputLine);
            }
            in.close();
            page = gson.fromJson(buffer.toString(), Page.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return page;
    }

}
