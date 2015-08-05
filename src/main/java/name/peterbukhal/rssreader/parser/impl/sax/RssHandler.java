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

package name.peterbukhal.rssreader.parser.impl.sax;

import name.peterbukhal.rssreader.model.Channel;
import name.peterbukhal.rssreader.parser.RssParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class RssHandler extends DefaultHandler {
	
	private String temp;
	private Channel channel = new Channel();
	
	public Channel getChannel() {
		return channel;
	}
	
	@Override
	public void startDocument() throws SAXException {
		
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		temp = localName;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (temp.equalsIgnoreCase(RssParser.TAG_TITLE)) { 
			channel.setTitle(new String(ch, start, length));
		} else if (temp.equalsIgnoreCase(RssParser.TAG_DESCRIPTION)) {
			
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
	}
	
	@Override
	public void endDocument() throws SAXException {
		
	}
	
}
