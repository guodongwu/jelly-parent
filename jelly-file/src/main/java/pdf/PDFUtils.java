package pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PDFUtils {
    /**
     * 拆分PDF代码, 假如我只想拆分第一页, 那么from和to就是1, 1。
     * 如果需要拆分从第一页到第五页, 那么from和to就是1, 5。
     *
     * @param pdfFile 需要拆分的源文件
     * @param newFile 生成新PDF的路径
     * @param from    从哪一页开始
     * @param end     从哪一页结束
     */
    public static void splitPdf(String pdfFile, String newFile, int from, int end) {
        Document document = null;
        PdfCopy copy = null;
        try {
            PdfReader reader = new PdfReader(pdfFile);
            int n = reader.getNumberOfPages();
            if (end == 0 || end > n) {
                end = n;
            }
            if (from < 0 || from > end || from >= n) {
                from = end;
            }
            List<String> savePaths = new ArrayList<String>();
            String staticPath = pdfFile.substring(0, pdfFile.lastIndexOf("\\") + 1);
            String savePath = staticPath + newFile;
            savePaths.add(savePath);
            document = new Document(reader.getPageSize(1));
            OutputStream os;
            copy = new PdfCopy(document, new FileOutputStream(savePaths.get(0)));
            document.open();
            for (int j = from; j <= end; j++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, j);
                copy.addPage(page);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
    /**
     * 拆分PDF代码, 假如我只想拆分第一页, 那么from和to就是1, 1。
     * 如果需要拆分从第一页到第五页, 那么from和to就是1, 5。
     *
     * @param pdfFile 需要拆分的源文件
     * @param newFile 生成新PDF的路径
     * @param perNum    每几页拆分
     */
    public static void splitPdf(String pdfFile, String newFile, int perNum) {
        Document document = null;
        PdfWriter writer = null;
        try {
            PdfReader reader = new PdfReader(pdfFile);
            int n = reader.getNumberOfPages();
            reader = new PdfReader(pdfFile);
            int sn = n % perNum == 0 ? n / perNum : n / perNum + 1;
            int pageIndex = 1;
            String staticPath = pdfFile.substring(0, pdfFile.lastIndexOf("\\") + 1);
            newFile = newFile.substring(0, newFile.lastIndexOf("."));
            for (int i = 0; i < sn; i++) {
                String newFileName =staticPath+ newFile + "_" + (i + 1) + ".pdf";
                document = new Document();
                writer = PdfWriter.getInstance(document, new FileOutputStream(newFileName));
                document.open();
                PdfContentByte pdfContentByte = writer.getDirectContent();
                for (int j = 0; j < perNum; j++) {
                    document.newPage();
                    pdfContentByte.addTemplate(writer.getImportedPage(reader, pageIndex), 0, 0);
                    pageIndex++;
                    if (pageIndex > n)
                        break;
                }
                writer.flush();
                if (document != null)
                    document.close();
                if (writer != null)
                    writer.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            //这个地方要特别注意资源关闭的顺序
            if (document != null)
                document.close();
            if (writer != null)
                writer.close();
        }

}

    public static boolean mergePdf(String [] pdfFiles,String newFile){
        boolean retValue=false;
        Document document=null;
        try{
            Arrays.sort(pdfFiles);
            document=new Document(new PdfReader(pdfFiles[0]).getPageSize(1));
            OutputStream os;
            PdfCopy copy=new PdfCopy(document, new FileOutputStream(newFile));
            document.open();
            for (int i=0;i< pdfFiles.length;i++){
                PdfReader reader=new PdfReader(pdfFiles[i]);
                int n=reader.getNumberOfPages();
                for (int j=1;j<=n;j++){
                    document.newPage();
                    PdfImportedPage page= copy.getImportedPage(reader,j);
                    copy.addPage(page);
                }
            }
            retValue=true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            document.close();
        }
        return retValue;

    }
    public static void main(String[] args) {
        //splitPdf("D:\\搜狗高速下载\\ZooKeeper入门简介及配置使用.pdf","2.pdf", 1, 5);
        String []files=new String[]{"D:\\搜狗高速下载\\3_1.pdf","D:\\搜狗高速下载\\3_2.pdf",
                "D:\\搜狗高速下载\\3_3.pdf","D:\\搜狗高速下载\\3_4.pdf"};
        mergePdf(files,"D:\\搜狗高速下载\\4.pdf");
    }
}
