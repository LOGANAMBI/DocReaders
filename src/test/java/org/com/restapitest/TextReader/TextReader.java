package org.com.restapitest.TextReader;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class TextReader {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Balaji\\OneDrive\\CVs\\Charity Camacho.docx");
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
			List<XWPFParagraph> paragraphList = xdoc.getParagraphs();
			List<IBodyElement> documentList = xdoc.getBodyElements();
		

			for (IBodyElement document : documentList) {
				System.out.println(document.getPart().getRelationParts());	
			}
			for (XWPFParagraph paragraph : paragraphList) {
//                System.out.print(documentList.);
				System.out.println(paragraph.getText());
//       		System.out.print(paragraph.getRuns().size());
//				System.out.println(paragraph.getStyle());
//
//				// Returns numbering format for this paragraph, eg bullet or lowerLetter.
//			System.out.println(paragraph.getNumFmt());
//				System.out.println(paragraph.getAlignment());
//
 //     		System.out.println(paragraph.isWordWrapped());

				System.out.println("********************************************************************");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
