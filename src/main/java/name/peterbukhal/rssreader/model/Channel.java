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

package name.peterbukhal.rssreader.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Peter Bukhal
 *
 */
public class Channel {
	
	/**
	 * The name of the channel. It's how people refer to your service. If you
	 * have an HTML website that contains the same information as your RSS file,
	 * the title of your channel should be the same as the title of your
	 * website.
	 */
	private String title;

	/**
	 * The URL to the HTML website corresponding to the channel.
	 */
	private String link;

	/**
	 * Phrase or sentence describing the channel.
	 */
	private String description;

	/**
	 * The language the channel is written in. This allows aggregators to group
	 * all Italian language sites, for example, on a single page. A list of
	 * allowable values for this element, as provided by Netscape, is <a
	 * href="http://cyber.law.harvard.edu/rss/languages.html">here</a>. You may
	 * also use <a
	 * href="http://www.w3.org/TR/REC-html40/struct/dirlang.html#langcodes">
	 * values defined</a> by the W3C.
	 */
	private String language;

	/**
	 * Copyright notice for content in the channel.
	 */
	private String copyright;

	/**
	 * Email address for person responsible for editorial content.
	 */
	private String managingEditor;

	/**
	 * Email address for person responsible for technical issues relating to
	 * channel.
	 */
	private String webMaster;

	/**
	 * The publication date for the content in the channel. For example, the New
	 * York Times publishes on a daily basis, the publication date flips once
	 * every 24 hours. That's when the pubDate of the channel changes. All
	 * date-times in RSS conform to the Date and Time Specification of <a
	 * href="http://asg.web.cmu.edu/rfc/rfc822.html">RFC 822</a>, with the
	 * exception that the year may be expressed with two characters or four
	 * characters (four preferred).
	 */
	private Date pubDate;

	/**
	 * The last time the content of the channel changed.
	 */
	private Date lastBuildDate;

	/**
	 * Specify one or more categories that the channel belongs to. Follows the
	 * same rules as the <item>-level <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltcategorygtSubelementOfLtitemgt"
	 * >category</a> element. More <a
	 * href="http://cyber.law.harvard.edu/rss/rss.html#syndic8">info</a>.
	 * 
	 * @see ChannelCategory
	 */
	private List<ChannelCategory> categories = new ArrayList<ChannelCategory>();

	/**
	 * A string indicating the program used to generate the channel.
	 */
	private String generator;

	/**
	 * A URL that points to the documentation for the format used in the RSS
	 * file. It's probably a pointer to this page. It's for people who might
	 * stumble across an RSS file on a Web server 25 years from now and wonder
	 * what it is.
	 */
	private String docs;

	/**
	 * Allows processes to register with a cloud to be notified of updates to
	 * the channel, implementing a lightweight publish-subscribe protocol for
	 * RSS feeds. More info <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltcloudgtSubelementOfLtchannelgt"
	 * >here</a>.
	 * 
	 * @see ChannelCloud
	 */
	private ChannelCloud cloud;

	/**
	 * ttl stands for time to live. It's a number of minutes that indicates how
	 * long a channel can be cached before refreshing from the source. More info
	 * <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltttlgtSubelementOfLtchannelgt"
	 * >here</a>.
	 */
	private Integer ttl;

	/**
	 * Specifies a GIF, JPEG or PNG image that can be displayed with the
	 * channel. More info <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltimagegtSubelementOfLtchannelgt"
	 * >here</a>.
	 * 
	 * @see ChannelImage
	 */
	private ChannelImage image;

	/**
	 * The <a href="http://www.w3.org/PICS/">PICS</a> rating for the channel.
	 */
	private String rating;

	/**
	 * Specifies a text input box that can be displayed with the channel. More
	 * info <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#lttextinputgtSubelementOfLtchannelgt"
	 * >here</a>.
	 * 
	 * @see TextInput
	 */
	private ChannelTextInput textInput;

	/**
	 * A hint for aggregators telling them which hours they can skip. More info
	 * <a href="http://cyber.law.harvard.edu/rss/skipHoursDays.html#skiphours">
	 * here</a>.
	 */
	private Integer skipHours;

	/**
	 * A hint for aggregators telling them which days they can skip. More info
	 * <a href="http://cyber.law.harvard.edu/rss/skipHoursDays.html#skipdays">
	 * here</a>.
	 */
	private Integer skipDays;

	/**
	 * A channel may contain any number of <item>s. An item may represent a
	 * "story" -- much like a story in a newspaper or magazine; if so its
	 * description is a synopsis of the story, and the link points to the full
	 * story. An item may also be complete in itself, if so, the description
	 * contains the text (entity-encoded HTML is allowed; see <a
	 * href="http://cyber.law.harvard.edu/rss/encodingDescriptions.html"
	 * >examples</a>), and the link and title may be omitted. All elements of an
	 * item are optional, however at least one of title or description must be
	 * present.
	 * 
	 * @see ChannelItem
	 */
	private List<ChannelItem> items = new ArrayList<ChannelItem>();

	public Channel() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getManagingEditor() {
		return managingEditor;
	}

	public void setManagingEditor(String managingEditor) {
		this.managingEditor = managingEditor;
	}

	public String getWebMaster() {
		return webMaster;
	}

	public void setWebMaster(String webMaster) {
		this.webMaster = webMaster;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getLastBuildDate() {
		return lastBuildDate;
	}

	public void setLastBuildDate(Date lastBuildDate) {
		this.lastBuildDate = lastBuildDate;
	}

	public List<ChannelCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ChannelCategory> categories) {
		this.categories = categories;
	}

	public String getGenerator() {
		return generator;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public String getDocs() {
		return docs;
	}

	public void setDocs(String docs) {
		this.docs = docs;
	}

	public ChannelCloud getCloud() {
		return cloud;
	}

	public void setCloud(ChannelCloud cloud) {
		this.cloud = cloud;
	}

	public Integer getTtl() {
		return ttl;
	}

	public void setTtl(Integer ttl) {
		this.ttl = ttl;
	}

	public ChannelImage getImage() {
		return image;
	}

	public void setImage(ChannelImage image) {
		this.image = image;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public ChannelTextInput getTextInput() {
		return textInput;
	}

	public void setTextInput(ChannelTextInput textInput) {
		this.textInput = textInput;
	}

	public Integer getSkipHours() {
		return skipHours;
	}

	public void setSkipHours(Integer skipHours) {
		this.skipHours = skipHours;
	}

	public Integer getSkipDays() {
		return skipDays;
	}

	public void setSkipDays(Integer skipDays) {
		this.skipDays = skipDays;
	}

	public List<ChannelItem> getItems() {
		return items;
	}

	public void setItems(List<ChannelItem> items) {
		this.items = items;
	}

}
