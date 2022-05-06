import cp.ConstantInfoInterface;
import cp.impl.IntegerConstantInfoCp;

import java.io.ByteArrayInputStream;

public class ConstantIntegerInfoCpTest {

    public static void main(String[] args) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{0x03, (byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        ConstantInfoInterface cp = new IntegerConstantInfoCp();
        cp.read(byteArrayInputStream);
        cp.collection();
    }

}
