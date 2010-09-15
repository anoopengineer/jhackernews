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
package com.dailygyan.hackernews;

import java.util.List;

/**
 * The Class representing one HN page listing news items
 */
public class Page {

    /** The next id. Used to paginate to next pages */
    String nextId;

    /** List of news objects representing all news items in a page */
    List<News> items;

    /** The version. No idea what this does */
    String version;

    /**
     * Gets the news list in this particular page. Naming convention deviated
     * from Javabeans naming convention to have a better API.
     * 
     * @return the news
     */
    public List<News> getNews() {
        return items;
    }

    /**
     * Gets the next id.
     * 
     * @return the nextId
     */
    public String getNextId() {
        return nextId;
    }

    /**
     * Gets the version.
     * 
     * @return the version
     */
    public String getVersion() {
        return version;
    }
}
