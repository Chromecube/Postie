/*
 *
 *      Copyright 2018 Niklas Arndt
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package me.niklas.postie.core;

/**
 * Created by Niklas on 05.06.2018 in postie
 * The version number is automatically inserted at Gradle build.
 */
public class VersionInfo {

    public static final String VERSION;
    private static final String VERSION_RAW = "@VERSION@";

    public static final String BUILD_DATE;
    private static final String BUILD_DATE_RAW = "@DATE@";

    static {
        //noinspection ConstantConditions
        VERSION = VERSION_RAW.startsWith("@") ? "DEVELOPMENT" : VERSION_RAW;
        BUILD_DATE = BUILD_DATE_RAW.startsWith("@") ? "DEBUG_BUILD" : BUILD_DATE_RAW;
    }
}
