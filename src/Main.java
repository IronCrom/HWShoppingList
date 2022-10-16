import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> shoppingList = new ArrayList<>();

        while (true) {
            System.out.println("""
                    Для создания списка покупок, введите номер операции и нажмиет Enter:\s
                    1. Добавить товар в список покупок\s
                    2. Показать список покупок\s
                    3. Удалить товар из списка покупок\s
                    4. Найти товар в списке покупок\s
                    Для завершения работы программы введите End и нажмите Enter""");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int userinfo;
            if ("end".equalsIgnoreCase(input)) {
                printShoppingList(shoppingList);
                break;
            } else userinfo = Integer.parseInt(input);
            switch (userinfo) {
                case 1 -> {
                    System.out.println("Какую покупку хотите добавить?");
                    shoppingList.add(scanner.nextLine());
                    System.out.println("Итого в списке покупок: " + shoppingList.size() + "\n");
                }
                case 2 -> {
                    printShoppingList(shoppingList);
                }
                case 3 -> {
                    printShoppingList(shoppingList);
                    System.out.println("Какую покупку хотите удалить? Введите номер или название:");
                    Scanner scannerDel = new Scanner(System.in);
                    String inputDel = scannerDel.nextLine();
                    try {
                        shoppingList.remove(Integer.parseInt(inputDel) - 1);
                    } catch (NumberFormatException e) {
                        shoppingList.remove(inputDel);
                    }
                    System.out.println("Покупка " + "\"" + inputDel + "\" удалена, список покупок:");
                    printShoppingList(shoppingList);
                }
                case 4 -> {
                    System.out.println("Введите текст для поиска:");
                    Scanner scannerSearch = new Scanner(System.in);
                    String inputSearch = scannerSearch.nextLine().toLowerCase();
                    System.out.println("Найдено:");
                    for (String buy : shoppingList) {
                        if (buy.toLowerCase().contains(inputSearch)) {
                            System.out.println((shoppingList.indexOf(buy) + 1) + "." + buy);
                        }
                    }

                }
                default -> System.out.println("Такой операции нет");
            }

        }
        System.out.println("Программа завершена!");
    }

    public static void printShoppingList(List<String> shoppingList) {
        System.out.println("Ваш список покупок:");
        for (String buy : shoppingList) {
            System.out.println((shoppingList.indexOf(buy) + 1) + "." + buy);
        }
        System.out.println();
    }
}
