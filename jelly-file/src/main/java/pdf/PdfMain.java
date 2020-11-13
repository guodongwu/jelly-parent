package pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;


/**
 * @author RYX
 *
 *
 * * <PRE>// creation of the document with a certain size and certain margins
 *  * <STRONG>
 *  * </STRONG> try {
 *  *   // creation of the different writers
 *  *   HtmlWriter.getInstance(<STRONG>document </STRONG>, System.out);
 *  *   PdfWriter.getInstance(<STRONG>document </STRONG>, new FileOutputStream("text.pdf"));
 *  *   // we add some meta information to the document
 *  *   <STRONG>document.addAuthor("Bruno Lowagie"); </STRONG>
 *  *   <STRONG>document.addSubject("This is the result of a Test."); </STRONG>
 *  *   // we open the document for writing
 *  *   <STRONG>document.open(); </STRONG>
 *  *   <STRONG>document.add(new Paragraph("Hello world"));</STRONG>
 *  *  } catch(DocumentException de) {
 *  *   System.err.println(de.getMessage());
 *  *  }
 *  *  <STRONG>document.close();</STRONG>
 *  * </PRE>
 */
public class PdfMain {
    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("D:\\1.pdf"));
        document.open();
        document.addAuthor("ryx");
        document.addSubject("this is a test");
        document.add(new Paragraph("hello"));
        document.addCreator("ryx");
        document.addCreationDate();
        document.addTitle("biubiu...");
        Image img=Image.getInstance(new URL("http://www.eclipse.org/xtend/images/java8_logo.png"));
        img.setAbsolutePosition(10f,10f);
        img.scaleAbsolute(100,100);

        document.add(img);
        PdfPTable table=new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);
        for (int i=0;i<3;i++){
            PdfPCell cell=new PdfPCell(new Paragraph("cell"+i));
            cell.setBorderColor(BaseColor.BLACK);
            cell.setPaddingLeft(5f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
        document.add(table);
        List order = new List(List.ORDERED);
        order.add(new ListItem("item 1"));
        order.add(new ListItem("item 3"));
        order.add(new ListItem("item 2"));
        order.add(new ListItem("item 4"));
        document.add(order);
        order = new List(List.UNORDERED);
        order.add(new ListItem("atem 1"));
        order.add(new ListItem("ctem 3"));
        order.add(new ListItem("dtem 2"));
        order.add(new ListItem("etem 4"));
        document.add(order);
        order=new RomanList();
        order.add(new ListItem("item 1"));
        order.add(new ListItem("item 3"));
        order.add(new ListItem("item 2"));
        order.add(new ListItem("item 4"));
        document.add(order);
        order=new GreekList();
        order.add(new ListItem("item 1"));
        order.add(new ListItem("item 3"));
        order.add(new ListItem("item 2"));
        order.add(new ListItem("item 4"));
        document.add(order);
        order=new ZapfDingbatsList(10);
        order.add(new ListItem("item 1"));
        order.add(new ListItem("item 3"));
        order.add(new ListItem("item 2"));
        order.add(new ListItem("item 4"));
        document.add(order);


        document.close();
        writer.close();

    }
}
