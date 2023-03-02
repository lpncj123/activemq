package cn.lp.io.netty.solvetcpsp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.io.netty.solvetcpsp
 * @Author: lp
 * @CreateTime: 2023-03-01  18:02
 * @Description: 自定义协议是指在应用程序之间传输数据时使用的特定格式。它可以定义数据的结构、序列化和反序列化方式、错误处理机制等。自定义协议的一个重要优点是，它可以与特定的应用程序和需求相匹配，因此可以提高通信的效率和可靠性。
 * @Version: 1.0
 */
//协议包

public class MessageProtocol {
    private int len; //关键
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
