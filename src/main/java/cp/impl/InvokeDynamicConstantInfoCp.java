package cp.impl;

import cp.AbstractConstantInfo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;

public class InvokeDynamicConstantInfoCp extends AbstractConstantInfo {

    public static final Integer TAG = 18;
    public static final Integer BOOTSTRAP_METHOD_ATTR_INDEX = 2;
    public static final Integer NAME_AND_TYPE_INDEX = 2;

    @Override
    public void read(InputStream inputStream) throws IOException {
        // tag
//        int tag = inputStream.read();
//        if (!TAG.equals(tag)) {
//            return;
//        }

        // bytes
        byte[] bytes = new byte[BOOTSTRAP_METHOD_ATTR_INDEX];
        inputStream.read(bytes);
        int index1 = ByteBuffer.wrap(bytes).getShort();

        bytes = new byte[NAME_AND_TYPE_INDEX];
        inputStream.read(bytes);
        int index2 = ByteBuffer.wrap(bytes).getShort();

        strings.add(MessageFormat.format("#{0} = MethodType            #{1}.#{2}", INDEX.getAndIncrement(), index1, index2));
    }

}
