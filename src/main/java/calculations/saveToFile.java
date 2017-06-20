package calculations;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;


/**
 * @author Marcin
 *
 */
public final class saveToFile {

	static Document document;

	public static void saveToTxt(String string, String sciezka) {

		try {
			PrintWriter pWriter = new PrintWriter(new File(sciezka));
			pWriter.write(string);
			pWriter.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loadXMLFromString(String xml, String path) throws Exception {
		String xmlString = xml;
		Document document = null;
		// System.out.println(xmlString);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(new InputSource(new StringReader(xmlString)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		Result output = new StreamResult(new File(path));
		Source input = new DOMSource(document);

		transformer.transform(input, output);

	}

}
