import cp.ConstantInfoInterface;
import cp.impl.FloatConstantInfoCp;

import java.io.ByteArrayInputStream;

public class ConstantFloatInfoCpTest {

    public static void main(String[] args) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{0x04, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        ConstantInfoInterface cp = new FloatConstantInfoCp();
        cp.read(byteArrayInputStream);
        cp.collection();
    }

}
