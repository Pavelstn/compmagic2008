package logic;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XmlTest {
  public static void main(String[] args){
    TransformerFactory tFactory = TransformerFactory.newInstance();
    System.out.println("вошли");
    try {
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      dbf.setNamespaceAware(true);
      Document d = dbf.newDocumentBuilder().parse(new File("xsltest.xsl"));
      StreamSource source = new StreamSource(new File("xmltest.xml"));
      DOMSource xsl_ds = new DOMSource(d.getFirstChild());
      System.out.println(xsl_ds.getNode().getAttributes().getNamedItem("version"));
      Transformer transformer = tFactory.newTransformer(xsl_ds);
      StreamResult result = new StreamResult(System.out);
      transformer.transform(source, result);
    } catch (Exception e) {
       e.printStackTrace();
    }
    //System.exit(0);
  }
}