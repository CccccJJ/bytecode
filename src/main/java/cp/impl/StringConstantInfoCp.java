package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class StringConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 8;
    public static final Integer BYTES = 2;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // bytes
        byte[] bytes = new byte[BYTES];
        inputStream.read(bytes);
        int index = ByteBuffer.wrap(bytes).getShort();

        strings.add(MessageFormat.format("#{0} = String            #{1}", INDEX.getAndIncrement(), index));
    }

}
