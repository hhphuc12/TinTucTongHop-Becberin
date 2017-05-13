package com.phuc.tintuctonghop;

import android.util.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MyHelper {
    public Document getDocument(String xml)
    {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db = factory.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            is.setEncoding("UTF-8");
            document = db.parse(is);
        }catch(ParserConfigurationException e)
        {
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        catch (SAXException e) {
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        catch(IOException e){
            Log.e("Error: ", e.getMessage(), e);
            return null;
        }
        return document;
    }

    public String getValue(Element item, String name)
    {
        NodeList nodes = item.getElementsByTagName(name);
        return this.getTextNodeValue(nodes.item(0));
    }

    public String getTagString(Element item, String name){
        NodeList nodes = item.getElementsByTagName(name);
        return this.getTextNodeValue(nodes.item(2));
    }

    private final String getTextNodeValue(Node elem) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    public String readDataFromURL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }

    /**convert "31 Mar 2017" to "31/03/2017"*/
    public String convertTime(String s){
        String date = s.substring(0, 2);
        String month = s.substring(3, 6);
        String year = s.substring(7, 11);

        switch (month){
            case "Jan": {
                month = "01";
                break;
            }
            case "Feb": {
                month = "02";
                break;
            }
            case "Mar": {
                month = "03";
                break;
            }
            case "Apr": {
                month = "04";
                break;
            }
            case "May": {
                month = "05";
                break;
            }
            case "Jun": {
                month = "06";
                break;
            }
            case "Jul": {
                month = "07";
                break;
            }
            case "Aug": {
                month = "08";
                break;
            }
            case "Sep": {
                month = "09";
                break;
            }
            case "Oct": {
                month = "10";
                break;
            }
            case "Nov": {
                month = "11";
                break;
            }
            case "Dec": {
                month = "12";
                break;
            }
        }
        return date + "/" + month + "/" + year;
    }
}
