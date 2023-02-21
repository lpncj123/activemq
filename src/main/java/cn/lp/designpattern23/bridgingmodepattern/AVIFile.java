package cn.lp.designpattern23.bridgingmodepattern;

public class AVIFile implements VideoFile{
    @Override
    public void decode(String fileName) {
        System.out.println("avi视频文件："+ fileName);
    }
}
