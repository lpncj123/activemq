package cn.lp.designpattern23.bridgingmodepattern;

public class Windows extends OperatingSystemVersion {
    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}
