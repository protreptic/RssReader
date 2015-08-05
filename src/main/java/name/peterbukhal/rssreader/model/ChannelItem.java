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
public class ChannelItem {

	/**
	 * The title of the item.
	 */
	private String title;

	/**
	 * The URL of the item.
	 */
	private String link;

	/**
	 * The item synopsis.
	 */
	private String description;

	/**
	 * It's the email address of the author of the item. For newspapers and
	 * magazines syndicating via RSS, the author is the person who wrote the
	 * article that the <item> describes. For collaborative weblogs, the author
	 * of the item might be different from the managing editor or webmaster. For
	 * a weblog authored by a single individual it would make sense to omit the
	 * <author> element. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltauthorgtSubelementOfLtitemgt"
	 * >More</a>.
	 */
	private String author;

	/**
	 * Includes the item in one or more categories. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltcategorygtSubelementOfLtitemgt"
	 * >More</a>.
	 * 
	 * @see ItemCategory
	 */
	private List<ItemCategory> categories = new ArrayList<ItemCategory>();

	/**
	 * If present, it is the url of the comments page for the item. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltcommentsgtSubelementOfLtitemgt"
	 * >More</a>.
	 */
	private String comments;

	/**
	 * Describes a media object that is attached to the item. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltenclosuregtSubelementOfLtitemgt"
	 * >More</a>.
	 * 
	 * @see ItemEnclosure
	 */
	private ItemEnclosure enclosure;

	/**
	 * A string that uniquely identifies the item. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltguidgtSubelementOfLtitemgt"
	 * >More</a>.
	 * 
	 * @see ItemGuid
	 */
	private ItemGuid guid;
	
	/**
	 * Indicates when the item was published. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltpubdategtSubelementOfLtitemgt"
	 * >More</a>.
	 */
	private Date pubDate;

	/**
	 * The RSS channel that the item came from. <a href=
	 * "http://cyber.law.harvard.edu/rss/rss.html#ltsourcegtSubelementOfLtitemgt"
	 * >More</a>.
	 * 
	 * @see ItemSource
	 */
	private ItemSource source;

	public ChannelItem() {
		
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<ItemCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<ItemCategory> categories) {
		this.categories = categories;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public ItemEnclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(ItemEnclosure enclosure) {
		this.enclosure = enclosure;
	}

	public ItemGuid getGuid() {
		return guid;
	}

	public void setGuid(ItemGuid guid) {
		this.guid = guid;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public ItemSource getSource() {
		return source;
	}

	public void setSource(ItemSource source) {
		this.source = source;
	}

}
