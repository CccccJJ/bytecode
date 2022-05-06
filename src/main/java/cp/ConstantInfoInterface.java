package cp;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

public interface ConstantInfoInterface {

    AtomicInteger INDEX = new AtomicInteger(1);

    void read(InputStream inputStream) throws Exception;

    void collection();

}
