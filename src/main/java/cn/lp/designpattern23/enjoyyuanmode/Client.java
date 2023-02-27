package cn.lp.designpattern23.enjoyyuanmode;

public class Client {
    public static void main(String[] args) {
        BoxFactory instance = BoxFactory.getInstance();
        /**
         * 是因为当您将对象转换为 JSON 字符串时，JSON.toJSONString 方法默认会将对象的所有公共 getter 方法解析为可序列化的字段，并将其转换为 JSON 对象中的键值对。在您的代码中，Shape 类中定义了一个名为 getShape 的公共方法，该方法返回一个字符串 "I"。当您使用 JSON.toJSONString 方法将 Shape 类的实例转换为 JSON 字符串时，该方法会自动调用 getShape 方法，并将该方法返回的字符串作为 JSON 对象中的值，键为 "shape"。
         * 因此，当您打印 Shape 类的实例时，您会看到输出的 JSON 字符串中只有一个键值对，键为 "shape"，值为 "I"。这是因为 Shape 类只有一个公共方法 getShape，而 JSON.toJSONString 方法会将其自动解析为 JSON 字符串中的键值对。
         * 需要注意的是，如果您在 Shape 类中定义了其他公共 getter 方法，它们也会被解析为 JSON 字符串中的字段，并生成相应的键值对。
         */
        AbstractBox i = instance.getBox("I");
        i.display("红色");
    }
}
