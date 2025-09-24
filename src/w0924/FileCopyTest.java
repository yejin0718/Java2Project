package w0924;

import java.io.*;

public class FileCopyTest {
    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("D:/FileTest/MyData1.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("D:/FileTest/CopyFile.txt");;
            String line = null;

            while ((line = br.readLine())!=null){
                fw.write(line + "\n");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾지 못했습니다.");
        } catch (IOException e) {
            throw new RuntimeException("한 줄을 읽어올 수 없습니다.");
        }

        try {
            br.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("복사가 완료되었습니다.");

    }
}
