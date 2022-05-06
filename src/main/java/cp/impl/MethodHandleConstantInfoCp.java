package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class MethodHandleConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 12;
    public static final Integer REFERENCE_KIND = 1;
    public static final Integer REFERENCE_INDEX = 2;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // bytes
        byte[] bytes = new byte[REFERENCE_KIND];
        inputStream.read(bytes);
        int index1 = ByteBuffer.wrap(bytes).get();
        bytes = new byte[REFERENCE_INDEX];
        inputStream.read(bytes);
        int index2 = ByteBuffer.wrap(bytes).getShort();
        strings.add(MessageFormat.format("#{0} = MethodHandle            #{1}.#{2}", INDEX.getAndIncrement(), index1, index2));

    }

}
