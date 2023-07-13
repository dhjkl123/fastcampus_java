package ioc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder implements IEncoder {
    @Override
    public String Encoder(String msg) {
        try {
            return URLEncoder.encode(msg,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;

        }
    }
}
