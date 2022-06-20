import java.util.*;

public class BayProducts implements BayerImpl, ExpirationDateImpl, RussianProductImpl, RatingImpl {

    @Override
    public void printList(Map<Integer, Product> products) {
        System.out.println("Список возможных товаров для покупки в винном магазине:");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println();
    }

    @Override
    public void cheque(Map<Integer, Product> products) {
        Scanner scanner = new Scanner(System.in);
        Map<Product, Integer> personBuy = new HashMap<>();
        int sumProducts = 0;
        int productNumber; // номер продукта из списка, выбранный покупателем
        int productQuantity = 0; // количество, выбранное покупателем

        while (true) {
            System.out.println("Выберите номер товара и через пробел введите его количество, для завершения - \"end\"");
            String input2 = scanner.nextLine();
            try {
                if (input2.equals("end")) {
                    break;
                } else {
                    String[] parts = input2.split(" ");
                    productNumber = Integer.parseInt(parts[0]);
                    productQuantity = Integer.parseInt(parts[1]);

                    Product choiceProduct = products.get(productNumber);
                    int choiseQuantity = choiceProduct.getPrice() * productQuantity;

                    personBuy.put(choiceProduct, choiseQuantity);
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод");
            }
        }

        System.out.println("Ваша корзина:");

        for (Map.Entry<Product, Integer> entry : personBuy.entrySet()) {
            int allCost = entry.getValue();
            sumProducts += allCost;
            System.out.println("- " + entry.getKey() + " количество: " + productQuantity + " шт., общая стоимость: " + entry.getValue());
        }
        System.out.println("Итого: " + sumProducts + " рублей");
        System.out.println();
    }

    @Override
    public void shortExpirationDate(Map<Integer, Product> products) {
        System.out.println("Внимание, у продуктов короткий срок годности: ");
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getMonth() == ExpirationDate.JUN || entry.getValue().getMonth() == ExpirationDate.JUL) {
                System.out.println("- " + entry.getValue());
            }
        }
        System.out.println();
    }

    @Override
    public void russianProduct(Map<Integer, Product> products) {
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            if (entry.getValue().getMadeIn().equals("Russia")) {
                System.out.println("- " + entry.getValue());
            }
            System.out.println();
        }
    }

    @Override
    public Map<Product, Integer> ratingProduct(Map<Integer, Product> products) {

        Map<Product, Integer> rating = new HashMap<>();

        int sumOfRating = 0; // сумма рейтинга товара
        int numberOfRatings = 0; // количество введенных рейтингов
        Product choiceProduct = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите номер товара и через пробел введите его рейтинг");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            int productNumber = Integer.parseInt(parts[0]);
            int productRating = Integer.parseInt(parts[1]);

            choiceProduct = products.get(productNumber);
            numberOfRatings++;
            sumOfRating = (sumOfRating + productRating) / numberOfRatings;
        } catch (NumberFormatException e) {
            System.out.println("Не корректный ввод");
        }
        rating.put(choiceProduct, sumOfRating);

        System.out.println("Рейтинг товаров:");
        for (Map.Entry<Product, Integer> entry : rating.entrySet()) {
            System.out.println("- " + entry.getKey() + " рейтинг: " + entry.getValue());
        }
        System.out.println();
        return rating;
    }
}
