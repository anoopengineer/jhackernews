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

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // lists the first two pages of HN
        HackerNews hn = HackerFactory.getHackerNews();
        Page page = hn.getNews();
        String id = page.getNextId();
        System.out.println("First page contents:");
        for (News news : page.getNews()) {
            System.out.println(news);
        }

        System.out.println("Second page contents:");
        page = hn.getNews(id);
        for (News news : page.getNews()) {
            System.out.println(news);
        }
    }
}
