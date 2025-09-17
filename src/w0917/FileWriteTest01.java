package w0917;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {
    public static void main(String[] args) {
        FileWriter fw = null;
        String line = null;

        try {
            fw = new FileWriter("D:/FileTest/MyData2.txt");
            line = "2025년 09월 17일";
            fw.write(line + "\n");

            line = "자바 기초 수업";
            fw.write(line + "\n");

            line = "배고프다";
            fw.write(line + "\n");

        } catch (IOException e) {
            throw new RuntimeException("FileWriter Generation Error");
        }

        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException("FileWriter Closed Error");
        }
    }
}
