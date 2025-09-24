package w0924;

import java.io.*;

//이미지파일은 1byte씩 입력받아서 1byte씩 출력해야한다.
public class ImageFileCopyTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(new File("C:/Users/AI-510-160/Pictures/Screenshots/스크린샷 2025-09-23 155823.png"));
            fos = new FileOutputStream("D:/FileTest/CopyImageFile.jpg");
            int ch;
            while ((ch = fis.read()) != -1) {
                fos.write(ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException("Reading Character Error");
        }

        try {
            fis.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("Closing File IOStream Error");
        }

    }
}
