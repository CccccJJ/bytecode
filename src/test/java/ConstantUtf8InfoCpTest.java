import cp.ConstantInfoInterface;
import cp.impl.Utf8ConstantInfoCp;

import java.io.ByteArrayInputStream;

public class ConstantUtf8InfoCpTest {

    public static void main(String[] args) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{0x01, 0x00, 0x01, 0x61});
        ConstantInfoInterface cp = new Utf8ConstantInfoCp();
        cp.read(byteArrayInputStream);
        cp.collection();
    }

}
