package cn.lp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2025-05-27  17:07
 * @Description: TODO
 * @Version: 1.0
 */
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HtmlToPdfConverter {

    /**
     * 将 HTML 文件转换为 A4 大小的 PDF 文件
     * @param htmlFilePath 输入 HTML 文件路径
     * @param pdfFilePath 输出 PDF 文件路径
     * @throws IOException 如果文件操作失败
     */
    public static void convertHtmlToPdf(String htmlFilePath, String pdfFilePath, String baseUri) throws IOException {
        // 创建 PDF 输出流
        File pdfFile = new File(pdfFilePath);
        PdfWriter writer = new PdfWriter(pdfFile);
        PdfDocument pdfDoc = new PdfDocument(writer);

        // 设置 ConverterProperties
        ConverterProperties properties = new ConverterProperties();

        // 设置基础 URI 以加载外部资源（如 CSS、图片）
        properties.setBaseUri(baseUri);

        // 配置字体提供者，支持中文等非拉丁字符
        FontProvider fontProvider = new DefaultFontProvider(false, false, true);
        // 添加支持中文的字体（假设使用 Windows 系统字体）
        fontProvider.addFont("C:/Windows/Fonts/simsun.ttc", PdfEncodings.IDENTITY_H);
        properties.setFontProvider(fontProvider);

        // 设置字符编码
        properties.setCharset("UTF-8");

        // 读取 HTML 文件内容
        FileInputStream htmlInputStream = new FileInputStream(htmlFilePath);

        // 将 HTML 转换为 PDF
        HtmlConverter.convertToPdf(htmlInputStream, pdfDoc, properties);

        // 关闭资源
        pdfDoc.close();
        htmlInputStream.close();
        writer.close();
    }

    /**
     * 示例用法
     */
//    public static void main(String[] args) {
//        HtmlToPdfConverter converter = new HtmlToPdfConverter();
//        try {
//            converter.convertHtmlToPdf("C:\\Users\\18012\\Desktop\\最终(1).html", "output.pdf");
//            System.out.println("PDF 创建成功！");
//        } catch (IOException e) {
//            System.err.println("转换失败: " + e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        String htmlFilePath = "C:\\Users\\18012\\Desktop\\最终(1).html"; // 输入 HTML 文件路径
        String pdfFilePath = "output.pdf";  // 输出 PDF 文件路径
        String baseUri = new File(".").getAbsolutePath() + "/"; // HTML 文件所在目录，用于加载外部资源

        try {
            convertHtmlToPdf(htmlFilePath, pdfFilePath, baseUri);
            System.out.println("PDF generated successfully at: " + pdfFilePath);
        } catch (IOException e) {
            System.err.println("Error during conversion: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
