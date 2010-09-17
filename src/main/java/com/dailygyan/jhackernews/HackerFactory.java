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
package com.dailygyan.jhackernews;

import com.dailygyan.jhackernews.comment.HackerComments;
import com.dailygyan.jhackernews.comment.impl.HackerCommentsImpl;
import com.dailygyan.jhackernews.news.HackerNews;
import com.dailygyan.jhackernews.news.impl.HackerNewsImpl;
import com.dailygyan.jhackernews.user.HackerUser;
import com.dailygyan.jhackernews.user.impl.HackerUserImpl;

/**
 * A factory for creating Hacker objects. Get started by calling the
 * getHackerNews() method
 */
public class HackerFactory {

    /**
     * The singleton instance of {@link HackerNews}. Will be returned on call to
     * getHackerNews()
     */
    private static final HackerNews HACKER_NEWS_INSTANCE = new HackerNewsImpl();

    /**
     * The singleton instance of {@link HackerComments}. Will be returned on
     * call to getHackerComments()
     */
    private static final HackerComments HACKER_COMMENTS_INSTANCE = new HackerCommentsImpl();

    /**
     * The singleton instance of {@link HackerUser}. Will be returned on
     * call to getHackerUser()
     */
    private static final HackerUser HACKER_USER_INSTANCE = new HackerUserImpl();

    /**
     * Gets the hacker news.
     * 
     * @return the hacker news
     */
    public static HackerNews getHackerNews() {
        return HACKER_NEWS_INSTANCE;
    }

    /**
     * Gets the hacker comments.
     * 
     * @return the hacker comments
     */
    public static HackerComments getHackerComments() {

        return HACKER_COMMENTS_INSTANCE;
    }

    /**
     * Gets the hacker user.
     * 
     * @return the hacker user
     */
    public static HackerUser getHackerUser() {

        return HACKER_USER_INSTANCE;
    }
}
