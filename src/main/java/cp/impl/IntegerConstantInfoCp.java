package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class IntegerConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 3;
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
        int integer = ByteBuffer.wrap(bytes).asIntBuffer().get();

        strings.add(MessageFormat.format("#{0} = Integer            {1}", INDEX.getAndIncrement(), integer));
    }

}
