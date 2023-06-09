package cn.lp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2023-04-25  17:25
 * @Description: TODO
 * @Version: 1.0
 */
public class GenerateLargeFile {
    private static final long GB = 1024L * 1024L * 1024L;

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\idea\\a.txt");
        long fileSize = GB; // 1GB
        int bufferSize = 1024 * 1024; // 1MB
        byte[] buffer = new byte[bufferSize];

        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
            for (long i = 0; i < fileSize; i += bufferSize) {
                bos.write(buffer);
            }
        }
    }
}
