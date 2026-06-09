/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package open.dolphin.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author S.Oh@Life Sciences Computing Corporation.
 */
public class OrcaAnalyze {
    /**
     * コンストラクタ
     */
    public OrcaAnalyze() {
        
    }
    
    public void analisisSampleXml(String statement) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document doc;
        
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            doc = builder.parse(new ByteArrayInputStream(statement.getBytes("UTF-8")));
            XPath xpath = XPathFactory.newInstance().newXPath();
            
            Node pNode = (Node) xpath.evaluate("/xmlio2/patientinfores/Patient_Information", doc, XPathConstants.NODE);
            if (pNode != null) {
                Node node;
                // 患者ID
                node = (Node) xpath.evaluate("Patient_ID", pNode, XPathConstants.NODE);
                String pid = (node != null && node.getFirstChild() != null) ? node.getFirstChild().getNodeValue() : null;
                
                // 保険情報
                NodeList insuranceNodes = (NodeList) xpath.evaluate("HealthInsurance_Information/HealthInsurance_Information_child", pNode, XPathConstants.NODESET);
                for (int i = 0; i < insuranceNodes.getLength(); i++) {
                    Node hNode = insuranceNodes.item(i);
                    node = (Node) xpath.evaluate("InsuranceProvider_Class", hNode, XPathConstants.NODE);
                    String insuranceProviderClass = (node != null && node.getFirstChild() != null) ? node.getFirstChild().getNodeValue() : null;
                }
            }
        } catch (SAXException ex) {
            Logger.getLogger(OrcaAnalyze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrcaAnalyze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(OrcaAnalyze.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(OrcaAnalyze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
