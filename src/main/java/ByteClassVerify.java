import cp.AbstractConstantInfo;
import cp.impl.*;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public class ByteClassVerify {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("/Users/cc/projects/bytecode/src/main/java/ByteCodeDemo.class")) {
//        try (FileInputStream fileInputStream = new FileInputStream("/Users/cc/projects/bytecode/src/main/java/AbstractConstantInfo.class")) {

            // magic number 0xcafebabe(CafeBabe)
            int[] magicNumber = new int[]{0xca, 0xfe, 0xba, 0xbe};
            for (int i : magicNumber) {
                if (i != fileInputStream.read()) {
                    System.out.println("Magic Number verify is not passed");
                    return;
                }
            }
            System.out.println("Magic Number verify is passed");

            // version number
            byte[] minorVersion = new byte[2];
            fileInputStream.read(minorVersion);

            byte[] majorVersion = new byte[2];
            fileInputStream.read(majorVersion);
            System.out.println(MessageFormat.format("minor: {0} {1}, major: {2} {3}", minorVersion[0], minorVersion[1], majorVersion[0], majorVersion[1]));

            // constant pool count
            byte[] constantPoolCount = new byte[2];
            fileInputStream.read(constantPoolCount);
            System.out.println(MessageFormat.format("constant pool count: {0} {1}", constantPoolCount[0], constantPoolCount[1]));
            final int constantCount = ByteBuffer.wrap(constantPoolCount).asShortBuffer().get();

            // constant pool data area
            for (int i = 0; i < constantCount - 1; i++) {
                int tag = fileInputStream.read();
                MAP.get(tag).read(fileInputStream);
            }

            MAP.forEach((k, v) -> {
                v.collection();
            });

            // access flag
            byte[] accessFlag = new byte[2];
            fileInputStream.read(accessFlag);
            short aShort = ByteBuffer.wrap(accessFlag).getShort();
            ACCESS_FLAG_MAP.forEach((k, v) -> {
                if ((aShort & k) > 0) {
                    System.out.println(MessageFormat.format("access flag: {0} ", v));
                }
            });

            // class name index
            byte[] classNameIndexByte = new byte[2];
            fileInputStream.read(classNameIndexByte);
            short classNameIndex = ByteBuffer.wrap(classNameIndexByte).getShort();
            System.out.println(MessageFormat.format("class name index: {0}", classNameIndex));

            // super class index
            byte[] superClassNameIndexByte = new byte[2];
            fileInputStream.read(superClassNameIndexByte);
            short superClassNameIndex = ByteBuffer.wrap(superClassNameIndexByte).getShort();
            System.out.println(MessageFormat.format("super class index: {0}", superClassNameIndex));

            // interface count
            byte[] interfaceCountByte = new byte[2];
            fileInputStream.read(interfaceCountByte);
            short interfaceCount = ByteBuffer.wrap(interfaceCountByte).getShort();
            System.out.println(MessageFormat.format("interface count: {0}", interfaceCount));

            // interface index
            for (int i = 0; i < interfaceCount; i++) {
                byte[] interfaceIndexByte = new byte[2];
                fileInputStream.read(interfaceIndexByte);
                short interfaceIndex = ByteBuffer.wrap(interfaceIndexByte).getShort();
                System.out.println(MessageFormat.format("interface {0} index {1}", i, interfaceIndex));
            }

            // fields count
            byte[] fieldsCountByte = new byte[2];
            fileInputStream.read(fieldsCountByte);
            short fieldsCount = ByteBuffer.wrap(fieldsCountByte).getShort();
            System.out.println(MessageFormat.format("fields count: {0}", fieldsCount));

            for (int i = 0; i < fieldsCount; i++) {
                byte[] fieldAccessFlagByte = new byte[2];
                fileInputStream.read(fieldAccessFlagByte);
                short fieldAccessFlag = ByteBuffer.wrap(fieldAccessFlagByte).getShort();
                String fieldAccessFlagStr = ACCESS_FLAG_MAP.get(fieldAccessFlag);

                byte[] fieldNameIndexByte = new byte[2];
                fileInputStream.read(fieldNameIndexByte);
                short fieldNameIndex = ByteBuffer.wrap(fieldNameIndexByte).getShort();

                byte[] fieldFlagIndexByte = new byte[2];
                fileInputStream.read(fieldFlagIndexByte);
                short fieldFlagIndex = ByteBuffer.wrap(fieldFlagIndexByte).getShort();

                byte[] fieldAttributeCountByte = new byte[2];
                fileInputStream.read(fieldAttributeCountByte);
                short fieldAttributeCount = ByteBuffer.wrap(fieldAttributeCountByte).getShort();

                System.out.println(MessageFormat.format("field access flag {0}, field name index #{1}, field flag index #{2}, field attribute count {3}",
                        fieldAccessFlagStr, fieldNameIndex, fieldFlagIndex, fieldAttributeCount));

                // field attribute
                for (int x = 0; x < fieldAttributeCount; x++) {
                    byte[] fieldAttributeIndexByte = new byte[2];
                    fileInputStream.read(fieldAttributeIndexByte);
                    short fieldAttributeIndex = ByteBuffer.wrap(fieldAttributeIndexByte).getShort();

                    System.out.println(MessageFormat.format("   field attribute #{0}", fieldAttributeIndex));
                }
            }

            // method count




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<Short, String> ACCESS_FLAG_MAP = new HashMap<Short, String>() {{
        put((short) 0x0001, "ACC_PUBLIC");
        put((short) 0x0002, "ACC_PRIVATE");
        put((short) 0x0004, "ACC_PROTECTED");
        put((short) 0x0008, "ACC_STATIC");
        put((short) 0x0010, "ACC_FINAL");
        put((short) 0x0020, "ACC_SUPER");
        put((short) 0x0040, "ACC_VOLATILE");
        put((short) 0x0080, "ACC_TRANSTENT");
        put((short) 0x1000, "ACC_SYNCHETIC");
        put((short) 0x4000, "ACC_ENUM");
    }};

    public static Map<Integer, AbstractConstantInfo> MAP = new HashMap<Integer, AbstractConstantInfo>() {{
        put(1, new Utf8ConstantInfoCp());
        put(3, new IntegerConstantInfoCp());
        put(4, new FloatConstantInfoCp());
        put(5, new LongConstantInfoCp());
        put(6, new DoubleConstantInfoCp());
        put(7, new ClassConstantInfoCp());
        put(8, new StringConstantInfoCp());
        put(9, new FieldRefConstantInfoCp());
        put(10, new MethodRefConstantInfoCp());
        put(11, new InterfaceMethodRefConstantInfoCp());
        put(12, new NameAndTypeConstantInfoCp());
        put(15, new MethodHandleConstantInfoCp());
        put(16, new MethodTypeConstantInfoCp());
        put(18, new InvokeDynamicConstantInfoCp());
    }};
}
