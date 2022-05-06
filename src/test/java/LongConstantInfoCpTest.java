import cp.ConstantInfoInterface;
import cp.impl.LongConstantInfoCp;

import java.io.ByteArrayInputStream;

public class LongConstantInfoCpTest {

    public static void main(String[] args) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{0x05, (byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        ConstantInfoInterface cp = new LongConstantInfoCp();
        cp.read(byteArrayInputStream);
        cp.collection();
        System.out.println(Long.MAX_VALUE);
    }

}
