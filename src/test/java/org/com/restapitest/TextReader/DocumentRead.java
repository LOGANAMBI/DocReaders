package org.com.restapitest.TextReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.POIDocument;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.HeaderStories;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBody;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;

public class DocumentRead {

	@SuppressWarnings("unused")
	@Test
	public void readDocx() throws IOException, XmlException, OpenXML4JException {

		File file = null;
		 /**This is the document that you want to read using Java.**/
	    String fileName = "C:\\Users\\Balaji\\Desktop\\Shaw lindon.docx";

	    /**Method call to read the document (demonstrate some useage of POI)**/
	    readMyDocument(fileName);

	}
	public static void readMyDocument(String fileName){
	    POIFSFileSystem fs = null;
	    try {
	        fs = new POIFSFileSystem(new FileInputStream(fileName));
	        XWPFDocument doc = new XWPFDocument();

	        /** Read the content **/
	        readParagraphs(doc);

	        int pageNumber=1;

	        /** We will try reading the header for page 1**/
	        readHeader(doc, pageNumber);

	        /** Let's try reading the footer for page 1**/
	        readFooter(doc, pageNumber);

	        /** Read the document summary**/
	        readDocumentSummary(doc);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}   

	public static void readParagraphs(XWPFDocument doc) throws Exception{
	    @SuppressWarnings("resource")
		WordExtractor we = new WordExtractor(doc);

	    /**Get the total number of paragraphs**/
	    String[] paragraphs = we.getParagraphText();
	    System.out.println("Total Paragraphs: "+paragraphs.length);

	    for (int i = 0; i < paragraphs.length; i++) {

	        System.out.println("Length of paragraph "+(i +1)+": "+ paragraphs[i].length());
	        System.out.println(paragraphs[i].toString());

	    }

	}

	public static void readHeader(XWPFDocument doc, int pageNumber){
	    HeaderStories headerStore = new HeaderStories( doc);
	    String header = headerStore.getHeader(pageNumber);
	    System.out.println("Header Is: "+header);

	}

	public static void readFooter(XWPFDocument doc, int pageNumber){
	    HeaderStories headerStore = new HeaderStories( doc);
	    String footer = headerStore.getFooter(pageNumber);
	    System.out.println("Footer Is: "+footer);

	}

	public static void readDocumentSummary(XWPFDocument doc) {
	    DocumentSummaryInformation summaryInfo=((POIDocument) doc).getDocumentSummaryInformation();
	    String category = summaryInfo.getCategory();
	    String company = summaryInfo.getCompany();
	    int lineCount=summaryInfo.getLineCount();
	    int sectionCount=summaryInfo.getSectionCount();
	    int slideCount=summaryInfo.getSlideCount();

	    System.out.println("---------------------------");
	    System.out.println("Category: "+category);
	    System.out.println("Company: "+company);
	    System.out.println("Line Count: "+lineCount);
	    System.out.println("Section Count: "+sectionCount);
	    System.out.println("Slide Count: "+slideCount);

	}
}
//     File file = null;
//          XWPFWordExtractor extractor = null;
//        try
//        {
//            file = new File("C:\\Users\\Balaji\\Desktop\\Annesha keen.docx");
//            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
//            extractor = new XWPFWordExtractor(xdoc);
//           
////            HWPFDocument document = new HWPFDocument(fis);
////            extractor = new WordExtractor(document);
//            String fileData = extractor.getText();
//           // for (int i = 0; i < fileData.length(); i++)
//           // {
//                //if (fileData[i] != null)
//               System.out.println(fileData);
//            }
//    
//        catch (Exception exep)
//        {
//            exep.printStackTrace();
//        }
//    }
