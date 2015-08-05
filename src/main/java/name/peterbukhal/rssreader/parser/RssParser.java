/*******************************************************************************
 * Copyright 2015 Peter Bukhal
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package name.peterbukhal.rssreader.parser;

import name.peterbukhal.rssreader.model.Channel;

public interface RssParser {
	
	public static final String TAG_SOURCE = "source";
	public static final String TAG_GUID = "guid";
	public static final String TAG_ENCLOSURE = "enclosure";
	public static final String TAG_COMMENTS = "comments";
	public static final String TAG_AUTHOR = "author";
	public static final String TAG_CLOUD = "cloud";
	public static final String TAG_IMAGE = "image";
	public static final String TAG_REGISTER_PROCEDURE = "registerProcedure";
	public static final String TAG_PATH = "path";
	public static final String TAG_PORT = "port";
	public static final String TAG_TTL = "ttl";
	public static final String TAG_DOMAIN = "domain";
	public static final String TAG_DOCS = "docs";
	public static final String TAG_PUB_DATE = "pubDate";
	public static final String TAG_WEB_MASTER = "webMaster";
	public static final String TAG_MANAGING_EDITOR = "managingEditor";
	public static final String TAG_COPYRIGHT = "copyright";
	public static final String TAG_TEXT_INPUT = "textInput";
	public static final String TAG_LASTBUILDDATE = "lastBuildDate";
	public static final String TAG_CATEGORY = "category";
	public static final String TAG_LANGUAGE = "language";
	public static final String TAG_GENERATOR = "generator";
	public static final String TAG_PROTOCOL = "protocol";
	public static final String TAG_HEIGHT = "height";
	public static final String TAG_DESCRIPTION = "description";
	public static final String TAG_WIDTH = "width";
	public static final String TAG_SKIP_DAYS = "skipDays";
	public static final String TAG_SKIP_HOURS = "skipHours";
	public static final String TAG_RATING = "rating";
	public static final String TAG_CHANNEL = "channel";
	public static final String TAG_ITEM = "item";
	public static final String TAG_URL = "url";
	public static final String TAG_TITLE = "title";
	public static final String TAG_LINK = "link";

	public Channel parseChannel(String uri);
	
}
