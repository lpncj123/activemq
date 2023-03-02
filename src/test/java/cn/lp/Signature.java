package cn.lp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Signature {
//    private static final int WIDTH = 300; // 签章宽度
    private static final int HEIGHT = 200; // 签章高度
    private static final String TEXT = "刘鹏"; // 签章文本
    private static final int CHAR_SPACING = 30; // 固定字符间距
    public static void main(String[] args) {
        int chineseCharCount = 0;
        for (int i = 0; i < TEXT.length(); i++) {
            // 判断当前字符是否是汉字
            if (TEXT.charAt(i) >= 0x4E00 && TEXT.charAt(i) <= 0x9FA5) {
                chineseCharCount++;
            }
        }
        System.out.println(chineseCharCount);
        int WIDTH = 300;
        if(chineseCharCount>2){
            WIDTH += (chineseCharCount-1)*50;
        }
        System.out.println(WIDTH);
        // 创建一个透明的 BufferedImage，作为签章的背景
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setComposite(AlphaComposite.Clear);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);
        g2d.setComposite(AlphaComposite.SrcOver);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制红色边框
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(10));
        g2d.drawRect(0, 0, WIDTH - 1, HEIGHT - 1);
        g2d.drawRect(1, 1, WIDTH - 3, HEIGHT - 3);





        g2d.setFont(new Font("宋体", Font.BOLD, 80));
        g2d.setColor(Color.RED);
        String[] chars = TEXT.split("");
        int[] charWidths = new int[chars.length];
        int totalWidth = 0;
        for (int i = 0; i < chars.length; i++) {
            charWidths[i] = g2d.getFontMetrics().charWidth(chars[i].charAt(0));
            totalWidth += charWidths[i];
        }
        int charSpacing = totalWidth / (5 * chars.length - 1); // 字符间隔为字符宽度的一半
        int x = (WIDTH - totalWidth - (chars.length - 1) * charSpacing) / 2; // 计算文本的起始 x 坐标
        int y = HEIGHT / 2 + g2d.getFontMetrics().getAscent() / 2; // 计算文本的 y 坐标
        for (int i = 0; i < chars.length; i++) {
            g2d.drawString(chars[i], x, y);
            x += charWidths[i] + charSpacing;
        }
        g2d.dispose();

        // 输出签章
        try {
            ImageIO.write(image, "png", new File("contract_seal.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
