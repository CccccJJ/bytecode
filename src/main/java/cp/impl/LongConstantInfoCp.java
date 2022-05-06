package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class LongConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 5;
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
        long l = ByteBuffer.wrap(bytes).asLongBuffer().get();

        strings.add(MessageFormat.format("#{0} = Long            {1}", INDEX.getAndIncrement(), l));
    }

}
