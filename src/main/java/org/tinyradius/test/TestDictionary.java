/**
 * $Id: TestDictionary.java,v 1.1 2005/09/06 16:38:41 wuttke Exp $
 * Created on 06.09.2005
 * @author mw
 * @version $Revision: 1.1 $
 */
package main.java.org.tinyradius.test;

import java.io.FileInputStream;
import java.io.InputStream;

import main.java.org.tinyradius.attribute.IpAttribute;
import main.java.org.tinyradius.dictionary.Dictionary;
import main.java.org.tinyradius.dictionary.DictionaryParser;
import main.java.org.tinyradius.packet.AccessRequest;

/**
 * Shows how to use TinyRadius with a custom dictionary
 * loaded from a dictionary file.
 * Requires a file "test.dictionary" in the current directory.
 */
public class TestDictionary {

	public static void main(String[] args) 
	throws Exception {
		InputStream source = new FileInputStream("test.dictionary");
		Dictionary dictionary = DictionaryParser.parseDictionary(source);
		AccessRequest ar = new AccessRequest("UserName", "UserPassword");
		ar.setDictionary(dictionary);
		ar.addAttribute("WISPr-Location-ID", "LocationID");
		ar.addAttribute(new IpAttribute(8, 1234567));
		System.out.println(ar);
	}
	
}
