import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(generateRandomInt(1, 5));
        }
    }

    public static int generateRandomInt(int st, int ed) {
        Random random = new Random();
        return random.nextInt(ed - st + 1) + st;
    }
}

