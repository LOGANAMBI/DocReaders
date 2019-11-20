package org.com.restapitest.TextReader;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;

public class DocxReader
{

	@SuppressWarnings("resource")
	@Test
	public static void main(String[] args) 
    {
            try {
                File file = new File("C:\\Users\\Balaji\\OneDrive\\CVs\\Charity Camacho.docx");
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());

                XWPFDocument document = new XWPFDocument(fis);

                List<XWPFParagraph> paragraphs = document.getParagraphs();


                for (XWPFParagraph para : paragraphs) {
                    System.out.println(para.getText());
                    //System.out.println(para.get);
                }
                    fis.close();
                }
             catch (Exception e) {
                e.printStackTrace();
            }
    }
        }
