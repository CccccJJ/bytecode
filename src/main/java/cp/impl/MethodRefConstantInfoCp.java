package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class MethodRefConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 10;
    public static final Integer BYTES1 = 2;
    public static final Integer BYTES2 = 2;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // bytes
        byte[] bytes = new byte[BYTES1];
        inputStream.read(bytes);
        int index1 = ByteBuffer.wrap(bytes).getShort();
        bytes = new byte[BYTES2];
        inputStream.read(bytes);
        int index2 = ByteBuffer.wrap(bytes).getShort();
        strings.add(MessageFormat.format("#{0} = Methodref            #{1}.#{2}", INDEX.getAndIncrement(), index1, index2));

    }

}
