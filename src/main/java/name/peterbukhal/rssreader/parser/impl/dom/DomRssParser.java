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

package name.peterbukhal.rssreader.parser.impl.dom;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import name.peterbukhal.rssreader.model.Channel;
import name.peterbukhal.rssreader.model.ChannelCategory;
import name.peterbukhal.rssreader.model.ChannelCloud;
import name.peterbukhal.rssreader.model.ChannelImage;
import name.peterbukhal.rssreader.model.ChannelItem;
import name.peterbukhal.rssreader.model.ItemCategory;
import name.peterbukhal.rssreader.model.ItemEnclosure;
import name.peterbukhal.rssreader.model.ItemGuid;
import name.peterbukhal.rssreader.model.ItemSource;
import name.peterbukhal.rssreader.parser.RssParser;

public class DomRssParser implements RssParser {

	@Override
	public Channel parseChannel(String uri) {
		Channel channel = new Channel();
		
		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document dom = builder.parse(uri);
			Element root = dom.getDocumentElement();
			NodeList channels = root.getElementsByTagName(TAG_CHANNEL);
			for (int i = 0; i < channels.getLength(); i++) {
				Node channelNode = channels.item(i);
				
				NodeList itemNodes = channelNode.getChildNodes();
				for (int j = 0; j < itemNodes.getLength(); j++) {
					if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_TITLE)) {  
						channel.setTitle(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_LINK)) {
						channel.setLink(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_DESCRIPTION)) {
						channel.setDescription(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_LANGUAGE)) {
						channel.setLanguage(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_COPYRIGHT)) {
						channel.setCopyright(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_MANAGING_EDITOR)) {
						channel.setManagingEditor(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_WEB_MASTER)) {
						channel.setWebMaster(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_PUB_DATE)) {
						channel.setPubDate(parseRfc822DateString(itemNodes.item(j).getFirstChild().getNodeValue()));  
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_LASTBUILDDATE)) {
						channel.setLastBuildDate(parseRfc822DateString(itemNodes.item(j).getFirstChild().getNodeValue())); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_CATEGORY)) {
						ChannelCategory channelCategory = new ChannelCategory();
						channelCategory.setName(itemNodes.item(j).getFirstChild().getNodeValue());
						
						channel.getCategories().add(channelCategory);
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_GENERATOR)) {
						channel.setGenerator(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_DOCS)) {
						channel.setDocs(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_CLOUD)) {
						ChannelCloud cloud = new ChannelCloud();
						
						NamedNodeMap cloudAttrs = itemNodes.item(j).getAttributes();
						for (int k = 0; k < cloudAttrs.getLength(); k++) {
							if (cloudAttrs.item(k).getNodeName().equalsIgnoreCase(TAG_DOMAIN)) {  
								cloud.setDomain(cloudAttrs.item(k).getFirstChild().getNodeValue()); 
							} else if (cloudAttrs.item(k).getNodeName().equalsIgnoreCase(TAG_PORT)) {
								cloud.setPort(Integer.valueOf(cloudAttrs.item(k).getFirstChild().getNodeValue())); 
							} else if (cloudAttrs.item(k).getNodeName().equalsIgnoreCase(TAG_PATH)) {
								cloud.setPath(cloudAttrs.item(k).getFirstChild().getNodeValue()); 
							} else if (cloudAttrs.item(k).getNodeName().equalsIgnoreCase(TAG_REGISTER_PROCEDURE)) {
								cloud.setRegisterProcedure(cloudAttrs.item(k).getFirstChild().getNodeValue()); 
							} else if (cloudAttrs.item(k).getNodeName().equalsIgnoreCase(TAG_PROTOCOL)) {
								cloud.setProtocol(cloudAttrs.item(k).getFirstChild().getNodeValue()); 
							}
						}
						
						channel.setCloud(cloud); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_TTL)) {
						channel.setTtl(Integer.valueOf(itemNodes.item(j).getFirstChild().getNodeValue())); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_IMAGE)) {
						ChannelImage image = new ChannelImage();
						
						NodeList imageNodes = itemNodes.item(j).getChildNodes();
						
						for (int k = 0; k < imageNodes.getLength(); k++) {
							if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_URL)) {  
								image.setUrl(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_TITLE)) {
								image.setTitle(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_LINK)) {
								image.setLink(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_WIDTH)) {
								image.setWidth(Integer.valueOf(imageNodes.item(k).getFirstChild().getNodeValue())); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_HEIGHT)) {
								image.setHeight(Integer.valueOf(imageNodes.item(k).getFirstChild().getNodeValue())); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_DESCRIPTION)) {
								image.setDescription(imageNodes.item(k).getFirstChild().getNodeValue()); 
							}
						}
						
						channel.setImage(image); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_RATING)) {
						channel.setRating(itemNodes.item(j).getFirstChild().getNodeValue()); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_TEXT_INPUT)) {
						
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_SKIP_HOURS)) {
						channel.setSkipHours(Integer.valueOf(itemNodes.item(j).getFirstChild().getNodeValue())); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_SKIP_DAYS)) {
						channel.setSkipDays(Integer.valueOf(itemNodes.item(j).getFirstChild().getNodeValue())); 
					} else if (itemNodes.item(j).getNodeName().equalsIgnoreCase(TAG_ITEM)) {
						ChannelItem channelItem = new ChannelItem();
						
						NodeList imageNodes = itemNodes.item(j).getChildNodes();
						
						for (int k = 0; k < imageNodes.getLength(); k++) {
							if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_TITLE)) {
								channelItem.setTitle(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_LINK)) {
								channelItem.setLink(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_DESCRIPTION)) {
								channelItem.setDescription(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_AUTHOR)) {
								channelItem.setAuthor(imageNodes.item(k).getFirstChild().getNodeValue()); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_CATEGORY)) {
								ItemCategory itemCategory = new ItemCategory();
								itemCategory.setName(imageNodes.item(k).getFirstChild().getNodeValue()); 
								
								channelItem.getCategories().add(itemCategory);
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_COMMENTS)) {
								channelItem.setComments(imageNodes.item(k).getFirstChild().getNodeValue());
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_ENCLOSURE)) {
								ItemEnclosure itemEnclosure = new ItemEnclosure();
								
								channelItem.setEnclosure(itemEnclosure); 
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_GUID)) {
								ItemGuid itemGuid = new ItemGuid();
								
								channelItem.setGuid(itemGuid);
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_PUB_DATE)) {
								//channelItem.setPubDate(parseRfc822DateString(imageNodes.item(j).getFirstChild().getNodeValue()));  
							} else if (imageNodes.item(k).getNodeName().equalsIgnoreCase(TAG_SOURCE)) {
								ItemSource itemSource = new ItemSource();
								
								channelItem.setSource(itemSource);
 							}
						}
						
						channel.getItems().add(channelItem);
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) { 
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return channel;
	}
		
		public static Date parseRfc822DateString(String dateString) {
			Date date = null;
			
			try {
				date = new Date(new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US).parse(dateString).getTime()); 
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return date;
		}
	
}
