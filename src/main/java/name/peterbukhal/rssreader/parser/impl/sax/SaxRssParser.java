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

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import name.peterbukhal.rssreader.model.Channel;
import name.peterbukhal.rssreader.parser.RssParser;

public class SaxRssParser implements RssParser {

	@Override
	public Channel parseChannel(String uri) {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	    saxParserFactory.setNamespaceAware(true);
	    
	    RssHandler rssHandler = new RssHandler();
	    
	    try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			
			XMLReader xmlReader = saxParser.getXMLReader();
			
			xmlReader.setContentHandler(rssHandler);
			xmlReader.parse(uri);   
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return rssHandler.getChannel();
	}

}
