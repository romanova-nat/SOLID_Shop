import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new Product("English ale", 580, "England", ExpirationDate.YAN, 2023));
        products.put(2, new Product("Beer", 250, "Russia", ExpirationDate.JUL, 2022));
        products.put(3, new Product("Chardonnay", 1450, "France", ExpirationDate.AUG, 2025));
        products.put(4, new Product("Merlot", 1320, "Italy", ExpirationDate.FAB, 2024));
        products.put(5, new Product("Krasnodar wine", 550, "Russia", ExpirationDate.DEC, 2022));

        while (true) {
            System.out.println("Выберите пункт отвечающий вашим запросам и нажмите \"enter\"  \n" +
                    "1. Вывести список возможных товаров для покупки в винном магазине \n" +
                    "2. Вывести товары российского производителя  \n" +
                    "3. Выбрать товары к покупке  \n" +
                    "4. Показать товары с ограниченным сроком годности \n" +
                    "5. Установить рейтинг товара");

            System.out.println();

            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    new BayProducts().printList(products);
                    break;
                case 2:
                    new BayProducts().russianProduct(products);
                    break;
                case 3:
                    new BayProducts().cheque(products);
                    break;
                case 4:
                    new BayProducts().shortExpirationDate(products);
                    break;
                case 5:
                    new BayProducts().ratingProduct(products);
                    break;
                default:
                    System.out.println("Нет такой опции");
            }
        }
    }
}