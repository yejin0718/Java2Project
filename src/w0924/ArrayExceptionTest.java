package w0924;
//RunTime(Unchecked) Exception
//ArrayIndexOutOfBoundsException
//ArithmeticException
public class ArrayExceptionTest {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};

        try {
            arr[0] = arr[2] / 0;
            arr[3] = 40;

            for(int i=0; i<arr.length; i++){
                System.out.print(arr[i] + "\t");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열의 인덱스 번호가 범위를 벗어난 것 같습니다.");
        } catch (ArithmeticException e) {
            System.out.println("나누는 수는 0일 수 없습니다.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("프로그램이 종료됩니다.");
        }

    }
}
