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
package com.dailygyan.jhackernews.user;

/**
 * The Interface HackerUser.
 */
public interface HackerUser {
    
    /**
     * Gets the user profile.
     * 
     * @param userName the user name
     * @return the user profile
     */
    public User getUserProfile(String userName);

    /**
     * Logs the user in.
     * 
     * @param userName the user name
     * @param password the password
     * @return the authenticationToken
     */
    public String login(String userName, String password);
}
