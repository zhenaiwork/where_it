package work.zhenai.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class removeLine {
    public static void remove(String url) throws IOException {
        RandomAccessFile f = new RandomAccessFile(url, "rw");
        long length = f.length() - 1;
        byte b;
        do {
            length -= 1;
            f.seek(length);
            b = f.readByte();
        } while (b != 10);
        f.setLength(length + 1);
        f.close();
    }
}
