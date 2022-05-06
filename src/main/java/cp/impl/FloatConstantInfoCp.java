package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class FloatConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 4;
    public static final Integer BYTES = 4;

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
        float f = ByteBuffer.wrap(bytes).asFloatBuffer().get();

        strings.add(MessageFormat.format("#{0} = Float            {1}", INDEX.getAndIncrement(), f));
    }

}
