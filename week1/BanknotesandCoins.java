import java.util.Scanner;

public class BanknotesandCoins {
    private static long notes;
    private static int coins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = scanner.nextDouble();

        notes = (long) input;
        coins = (int) (input * 100 % 100);

        long hundred = calculateNotes(100);
        long fifty = calculateNotes(50);
        long twenty = calculateNotes(20);
        long ten = calculateNotes(10);
        long five = calculateNotes(5);
        long two = calculateNotes(2);
        long one = calculateNotes(1);

        int fiftyCent = calculateCoins(50);
        int twentyFiveCent = calculateCoins(25);
        int tenCent = calculateCoins(10);
        int fiveCent = calculateCoins(5);
        int oneCent = calculateCoins(1);

        System.out.println("NOTAS:\n" +
                hundred + " nota(s) de R$ 100.00\n" +
                fifty + " nota(s) de R$ 50.00\n" +
                twenty + " nota(s) de R$ 20.00\n" +
                ten + " nota(s) de R$ 10.00\n" +
                five + " nota(s) de R$ 5.00\n" +
                two + " nota(s) de R$ 2.00\n" +
                "MOEDAS:\n" +
                one + " moeda(s) de R$ 1.00\n" +
                fiftyCent + " moeda(s) de R$ 0.50\n" +
                twentyFiveCent + " moeda(s) de R$ 0.25\n" +
                tenCent + " moeda(s) de R$ 0.10\n" +
                fiveCent + " moeda(s) de R$ 0.05\n" +
                oneCent + " moeda(s) de R$ 0.01");
    }

    private static long calculateNotes(int banknote){
        long count = 0;
        if(notes >= banknote) {
            count = notes / banknote;
            notes %= banknote;
        }
        return count;
    }
    private static int calculateCoins(int coin){
        int count = 0;
        if(coins >= coin) {
            count = coins / coin;
            coins %= coin;
        }
        return count;
    }
}
