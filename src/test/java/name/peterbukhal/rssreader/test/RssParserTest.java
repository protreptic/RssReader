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

package name.peterbukhal.rssreader.test;

import name.peterbukhal.rssreader.model.Channel;
import name.peterbukhal.rssreader.parser.RssParser;
import name.peterbukhal.rssreader.parser.impl.dom.DomRssParser;
import name.peterbukhal.rssreader.parser.impl.sax.SaxRssParser;
import name.peterbukhal.rssreader.parser.impl.stax.StaXRssParser;

import org.junit.Assert;
import org.junit.Test;

public class RssParserTest {
	
	public static final String RSS_TEST_FEED = "./rss_test_feed.xml";
	
	private RssParser rssParser;
	private Channel channel;
	
	@Test
	public void testSaxRssParser() {
		rssParser = new SaxRssParser();
		
		channel = rssParser.parseChannel(RSS_TEST_FEED);
		
		Assert.assertNotNull(channel); 
	} 
	
	@Test
	public void testStaXRssParser() {
		rssParser = new StaXRssParser();
		
		Channel channel = rssParser.parseChannel(RSS_TEST_FEED);
		
		Assert.assertNotNull(channel);
	}
	
	@Test
	public void testDomRssParser() {
		rssParser = new DomRssParser();
		
		Channel channel = rssParser.parseChannel(RSS_TEST_FEED);
		
		Assert.assertNotNull(channel);
	}
	
	@Test
	public void testChannel() {
		Assert.assertNotNull(channel);
		Assert.assertNotNull(channel.getTitle());
	}
	
}
