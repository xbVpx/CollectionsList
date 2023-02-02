import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t" + "Добро пожаловать!");
        System.out.println();
        System.out.println("Доступные операции: " + "\n" + "1. Добавить товар в корзину. " + "\n" + "2. Показать товар в корзине. " + "\n"
                + "3. Удалить товар из корзины." + "\n" + "4. Найти товар в корзине.");

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> products = new ArrayList<>();

        while (true) {
            System.out.println("Выбрать операцию или выйти end:");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    addProduct(scanner, products);
                    break;
                case 2:
                    showProduct(products);
                    break;
                case 3:
                    removeProduct(scanner, products);
                    break;
                case 4:
                    searchProduct(scanner, products);
                    break;
            }
        }
        scanner.close();
    }

    public static void addProduct(Scanner scanner, ArrayList<String> products) {
        System.out.println("Какую покупку хотите добавить?");
        String input = scanner.nextLine();
        String[] product = input.split(",");
        for (int i = 0; i < product.length; i++) {
            products.add(product[i]);
        }
        System.out.println("Итог в списке покупок: " + products.size());
    }

    public static void showProduct(ArrayList<String> products) {
        System.out.println("список покупок:");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + "." + product);
        }
    }

    public static void removeProduct(Scanner scanner, ArrayList<String> products) {
        final char dm = (char) 34;
        System.out.println("Список покупок");
        for (int i = 0; i < products.size(); i++) {
            String product = products.get(i);
            System.out.println((i + 1) + "." + product);
        }
        System.out.println("Какую хотите удалить? Введите номер или название");
        String input = scanner.nextLine();
        try {
            int num = Integer.parseInt(input);
            System.out.println("Покуака " + dm + (products.get(num - 1)) + dm + "удалена, список покупок:");
            products.remove(num - 1);
        } catch (NumberFormatException exception) {
            products.remove(input);
            System.out.println("Покупка " + dm + input + dm + " удалена, список покупок:");
        } catch (RuntimeException exception) {
            System.out.println("Такого номера нет!");
        } finally {
            System.out.println("Список покупок:");
            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                System.out.println((i + 1) + ". " + product);
            }
        }
    }

    public static void searchProduct(Scanner scan, List<String> products) {
        System.out.println("Введите текст для поиска:");
        String input = scan.nextLine();
        ;
        String queryLower = input.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < products.size(); i++) {
            String itemLower = products.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + "." + products.get(i));
            }
        }
    }
}




