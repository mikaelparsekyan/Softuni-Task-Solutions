import java.util.Scanner;

public class AwesomeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numToClassify = scanner.nextInt();
        int favouriteNumber = scanner.nextInt();
        String text = "";
        switch (getConditions(numToClassify,favouriteNumber)){
            case 0:
                text = "boring";
                break;
            case 1:
                text = "awesome";
                break;
            case 2:
                text = "super awesome";
                break;
            case 3:
                text = "super special awesome";
                break;
        }
        System.out.println(text);
    }
    private static int getConditions(int n, int i){
        int res = 0;
        if(n % 2 != 0){
            res++;
        }
        if(n < 0){
            res++;
        }
        if(n % i ==0){
            res++;
        }
        return res;
    }
}
