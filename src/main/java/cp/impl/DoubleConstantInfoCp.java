package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class DoubleConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 6;
    public static final Integer BYTES = 8;

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
        double f = ByteBuffer.wrap(bytes).asDoubleBuffer().get();

        strings.add(MessageFormat.format("#{0} = Double            {1}", INDEX.getAndIncrement(), f));
    }

}
