package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class MethodTypeConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 16;
    public static final Integer DESCRIPTOR_INDEX = 2;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // bytes
        byte[] bytes = new byte[DESCRIPTOR_INDEX];
        inputStream.read(bytes);
        int index = ByteBuffer.wrap(bytes).getShort();

        strings.add(MessageFormat.format("#{0} = MethodType            #{1}", INDEX.getAndIncrement(), index));
    }

}
