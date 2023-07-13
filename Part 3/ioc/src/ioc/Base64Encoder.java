package ioc;

import java.util.Base64;

public class Base64Encoder implements IEncoder {
    @Override
    public String Encoder(String msg) {
        return Base64.getEncoder().encodeToString(msg.getBytes());
    }
}
