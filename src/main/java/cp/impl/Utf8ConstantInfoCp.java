package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class Utf8ConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 1;
    public static final Integer LENGTH = 2;
    public static final Integer BYTES = 1;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // length
        byte[] lengthBytes = new byte[LENGTH * BYTES];
        inputStream.read(lengthBytes);
        int length = ByteBuffer.wrap(lengthBytes).getShort();

        // bytes
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int read = inputStream.read();
            sb.append((char) read);
        }

        strings.add(MessageFormat.format("#{0} = Utf8            {1}", INDEX.getAndIncrement(), sb));
    }


}
