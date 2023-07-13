package ioc;

import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;

    }

    public String Encoder(String msg) {
        return iEncoder.Encoder(msg);
    }
}
