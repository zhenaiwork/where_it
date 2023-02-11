package work.zhenai.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class readLine {
    static String readAppointedLineNumber(File sourceFile, int lineNumber) throws IOException {
        FileReader in = new FileReader(sourceFile);
        LineNumberReader reader = new LineNumberReader(in);
        String s = "";
        if (lineNumber <= 0 || lineNumber > getTotalLines(sourceFile)) {
            String nm = "你看你妈呢！！";
            return nm;
        }
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
            if((lines - lineNumber) == 0) {
                return s;
            }
        }
        reader.close();
        in.close();
        return s;
    }
    // 文件内容的总行数。
    static int getTotalLines(File file) throws IOException {
        FileReader in = new FileReader(file);
        LineNumberReader reader = new LineNumberReader(in);
        String s = reader.readLine();
        int lines = 0;
        while (s != null) {
            lines++;
            s = reader.readLine();
        }
        reader.close();
        in.close();
        return lines;
    }

    /**
     * 读取文件指定行。
     */
    public static void main(String[] args) throws IOException {
        // 指定读取的行号w
        int lineNumber = 2;
        // 读取文件
        File sourceFile = new File("D:/java/test.txt");
        // 读取指定的行
        readAppointedLineNumber(sourceFile, lineNumber);
        // 获取文件的内容的总行数
        System.out.println(getTotalLines(sourceFile));
    }
}
