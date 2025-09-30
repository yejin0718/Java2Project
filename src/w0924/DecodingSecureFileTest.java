package w0924;

import java.io.*;
import java.util.Scanner;

//\n 처리 추가해야됨

public class DecodingSecureFileTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;
        FileReader fr = null;
        FileWriter fw = null;
        String dedoceSecureStr = "";

        try {
            fr = new FileReader("D:/FileTest/secureFile.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("D:/FileTest/DecodingSecureFile.txt");
            String line = "";

            while ((line = br.readLine()) != null) {

                for(int i=0; i<line.length(); i++){
                    int code = (int)line.charAt(i);
                    code -= 100;
                    dedoceSecureStr += (char)code;
                }
                dedoceSecureStr += "\n";

                fw.write(dedoceSecureStr);

                dedoceSecureStr = "";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException("한 줄을 읽어올 수 없습니다.");
        }

        try {
            fw.close();
            fr.close();
            br.close();
            sc.close();

            System.out.println("복호화 완료: D:/FileTest/DecodingSecureFile.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
