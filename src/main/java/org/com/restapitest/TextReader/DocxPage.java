package org.com.restapitest.TextReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxPage {

	@SuppressWarnings("resource")
	public String getDocxText(File file) throws InvalidFormatException, IOException {
        FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
		XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
		String fileData = extractor.getText();
		System.out.println(fileData.toString());
		return fileData;
	}

	public String getOtherText(File file) throws FileNotFoundException {
		 FileInputStream fis = new FileInputStream(file.getAbsolutePath());
		return null;
		 }
}
