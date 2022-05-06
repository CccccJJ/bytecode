package cp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractConstantInfo implements ConstantInfoInterface {

    protected List<String> strings = new ArrayList<>();

    @Override
    public void collection() {
        strings.forEach(System.out::println);
    }

    protected int bytesToIntHighOrder(byte[] bytes) {
        int length = bytes.length;

        int integer = 0;

        for (int i = 0; i < length; i++) {
            integer |= (bytes[i] & 0xFF) << (length - i - 1) * 8;
        }

        return integer;
    }

    protected float bytesToFloatHighOrder(byte[] bytes) {
        int i = bytesToIntHighOrder(bytes);
        return Float.intBitsToFloat(i);
    }

    protected long bytesToLongHighOrder(byte[] bytes) {
        int length = bytes.length;

        long longer = 0;

        for (int i = 0; i < length; i++) {
            longer |= (long) (bytes[i] & 0xFF) << (length - i - 1) * 8;
        }

        return longer;
    }

    protected double bytesToDoubleHighOrder(byte[] bytes) {
        long l = bytesToLongHighOrder(bytes);
        return Double.longBitsToDouble(l);
    }

}
