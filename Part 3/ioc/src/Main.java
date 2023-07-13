import ioc.Base64Encoder;
import ioc.Encoder;
import ioc.IEncoder;
import ioc.UrlEncoder;

public class Main {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";


        Encoder encoder = new Encoder(new Base64Encoder());
        String result = encoder.Encoder(url);
        System.out.println(result);

        Encoder urlencoder = new Encoder(new UrlEncoder());
        result = urlencoder.Encoder(url);
        System.out.println(result);

    }
}