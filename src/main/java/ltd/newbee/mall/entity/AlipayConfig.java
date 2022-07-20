package ltd.newbee.mall.entity;
import lombok.Data;

import java.io.FileWriter;
import java.io.IOException;

@Data
public class AlipayConfig {
    //因为是在沙箱环境下进行测试，所以下面的信息填的值都是沙箱应用里面的值
    // 商户appid 测试环境用的都是沙箱应用里面的值，正式环境换成你自己申请的,比如我申请的(我的第一个支付中心)里面对应的值
    public static String APPID = "2021001140667888";
    // 私钥 pkcs8格式的 因为公钥我用的是自己申请的那个(我的第一个支付中心)里面的那个公钥，所以私钥填的也是我的第一个中心里面对应公钥生成的私钥
    //公钥类似于一把锁，私钥类似于钥匙，一个公钥对应一个私钥，1对1关系
    public static String RSA_PRIVATE_KEY ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDNSfvgWlAhd8uaVaIZ98Ez7Ox85cBmszfl85+9G7COZFNaS33UxYbO200uascADfnz3qfuWF0hrhMgwv7Zp62rP59+mXzVOp9xNrVCELgkEUTDY3V6lP6z1VDop4wIq//nP39QCVKGQdJHSSE4lB6VhUHGlM1ctENKTdmi33Og7BsDGo5p0nWOmmp9BQn0FZAAhZW2LcFy7Ff1cZzfe6vOiUa9UkJJFFa2G++BxZE7fP/CDS5hjx7e39UVDWtwF9BcLpdBHDzQZ+y7trl00w7T3aahC8QnemDcxV/ntNYQz9OJi8TKCNusmtJhD+i+KUqwjMHnTwxilHS1zCRtla6BAgMBAAECggEAIZbAWoYMZF14d8kZG8yY1Qkn7Iue/m7Gb557/XIhYjryFG0TqpOjKgdhyn14D/85bXh525qjqlYUFSEyl6RC2ykuzIUKkszjt59u6t9XcbdNm/aTCzqDriLx+Q8o72ZNGaYfC5Zq5UKxyC4j/GDn3CkQiRBhxZBNDkRMnsSW47ZS1Tjo0csmzGXj8HVIFiSIf8JiQ9Lv5Hbg6NbwzE00K3mIZJD+SENNSxZwZtPK61q7dnZ0L2jSDuLm7ir7LRrRpuEKzRuzWmd53lUyUtkFFtGVKXMi0wchOhkKm/z+/Nod+4bm+gdc+7neI63kgwQxKAjYVbDWZqR25sHgKA4ajQKBgQDyrS7JbHt3MWLF1bZnRt086qquOZt6sValWML7ojHLIsEqi6dpN3lkRe+lvytrBhsQuPHUvJuEWKlGD/okICfGghU1ZyeKfMJZHpdIDOSTBXzxoqMAU7CKGN4ewRHs98C61G/KMslqKEg8Dwyq439QqTazwcTNClPDbLk3rAieHwKBgQDYj1Hsy2Vycyo3zdWbBuAqrwhuZKUYhtYl+j9i08QNleV6bAemQktKVSd0M53bEuSfuMXp8QmgyUahVFa8795/OSwhgfHSGbV4WrQ7wp7RX8caSj/i4iNDuGngLKNdXhNyDVmb+unOsdRwzSdPf8h1pHNKv+20OFAHzJnESprfXwKBgHsfBlfHJDTq53P745kuSNy5KnNOYuWyx4UILZTBS4YGUf6l7//f10TafqWXAg5AgMbRLlCCiFxzJx6WyJA/iC6cnOoFNfh7J5dTf+lcMTOuWx+1JgHqc+z8hOURi2iwoiWn1je94JZtbYibEhA5b8SatVgp/RESJkFGDgqCy7R9AoGAe5xTBvaSUWGrF29GHdcu3S5LgbexBO7yDXtp8t8taRPGiLphI2Vz1FoGyy0rTYDbPtAZKA+Nj1lUF4IsgGvqdHQN3JJvlZ1XF/uuJO5R+PDSlQ8MqFSsDFuXE35nQUQRlWhJXd861eBrgneXmKk3ou7bYC9tXxFFnS4MFx7+h8ECgYBBu1k8A+K7HdNW2FSwDkGXQyimVrfaDYt4uyJ23bPNEGAIeZHwOlvgSfxh1AoXbzSXg9qI83JM23rce0R2uQGTlOkUxWprrOL91gyqabQepFoiQ6sPLjcedtCB+io5uu83tiQtTqt4YQXn3BIS2MDEgy95ZQ0vYOvIF9v+VkEncw==";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //这里我没填，因为我主要目的是学习怎么支付，所以notify_url和return_url就没管，这2个并不影响支付过程
    public static String notify_url = "http://localhost:8080/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8080/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
    // 请求网关地址 填写沙箱应用里面的 这是正式环境的请求网址https://openapi.alipay.com/gateway.do,下方是沙箱环境的
    public static String URL = "https://openapi.alipay.com/gateway.do";
    //	public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥 这里我填的是沙箱应用里面RSA2(SHA256)密钥(推荐)这个生成的支付宝的公钥,正式环境是接口加签方式里面的支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiXATYWUi4bXj5w0ZaRjNMlYHFkM10G1VstfwYmsgl2u9PcTk6L5QvVqGUrL/NBYpHTLn2Yj7HicKWQVGgO+Cq76tJ5Y/hinpXPzGygT2vPam8JGh0l7sHDjJGWMRd1Uk6ogNsNo3P2Cnf4KTq3s8BhZU0FB4ckkfjbiUcIiMBVnpoyYNp/u5JACX3VnmXzhFMgJuWR4ELzBU9azumoCoDHgy+zu8yNypKYKVuM6XxPalAm7bI4DVjOeQAHIq99dr5nvWMA4j/O/yIAu+XaQ1C1a+5UPph68vJuc4PwAb055AuXu82gDPTfHec2cFDw2ehmc39qTD3XTJdcrkpTEsRQIDAQAB";
    // 日志记录目录 日志生成位置,E盘下必须要有先有这个文件夹，不然会报错
    public static String log_path = "D://today/";
    // RSA2
    public static String SIGNTYPE = "RSA2";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord
     *            要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_"
                    + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

