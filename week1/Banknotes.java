import java.util.Scanner;

public class Banknotes {
    static int money;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        money = scanner.nextInt();
        System.out.println(money);

        int hundred = fun(100);
        int fifty = fun(50);
        int twenty = fun(20);
        int ten = fun(10);
        int five = fun(5);
        int two = fun(2);
        int one = fun(1);

        System.out.println(hundred + " nota(s) de R$ 100,00\n" +
                fifty + " nota(s) de R$ 50,00\n" +
                twenty + " nota(s) de R$ 20,00\n" +
                ten + " nota(s) de R$ 10,00\n" +
                five + " nota(s) de R$ 5,00\n" +
                two + " nota(s) de R$ 2,00\n" +
                one + " nota(s) de R$ 1,00");
    }

    private static int fun(int banknote){
        int countOfBanknotes = 0;
        if(money >= banknote) {
            countOfBanknotes = money / banknote;
            money %= banknote;
        }
        return countOfBanknotes;

    }
}
