package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.ClassWithUtilsMethods.getRandomIntList;

/**
 * @author annasavasteeva
 * @date 12.05.2026
 */
public class StreamApp {

    public void runApp() {
        System.out.println("----------");
        System.out.println("ЗАДАЧА 1: список чисел");
        runIntegersListProcessing();
        System.out.println("----------");
        System.out.println("----------");
        System.out.println("ЗАДАЧА 2: словарь");
        runMapProcessing();
        System.out.println("----------");
    }

    private void runMapProcessing() {
        List<String> names = getNamesList();
        Map<Integer, String> users = new HashMap<>();
        for (int i = 0; i < names.size(); i++) {
            int id = i + 1;
            users.put(id, names.get(i));
        }
        System.out.printf("Исходный список пользователей: %s%n", users);

        List<Integer> requiredIds = Arrays.asList(1, 2, 5, 8, 9, 13);
        List<String> requiredUsers = users.entrySet().stream()
                .filter(entry -> requiredIds.contains(entry.getKey()))
                .map(Map.Entry::getValue)
                .toList();
        System.out.printf("Найденные по id пользователи: %s%n", requiredUsers);

        List<String> evenNames = requiredUsers.stream().filter(name -> name.length() % 2 != 0).toList();
        System.out.printf("Имена с нечетным количеством букв: %s%n", evenNames);

        List<String> reversedNames = evenNames.stream()
                .map(name -> new StringBuilder(name).reverse().toString())
                .toList();
        System.out.printf("Имена задом наперед: %s%n", reversedNames);
    }

    private List<String> getNamesList() {
        List<String> femaleNames = Arrays.asList("София", "Анна", "Ева", "Василиса", "Мария", "Варвара", "Виктория");
        List<String> maleNames = Arrays.asList("Михаил", "Александр", "Артём", "Матвей", "Тимофей", "Марк", "Лев");
        List<String> result = Stream.concat(femaleNames.stream(), maleNames.stream()).collect(Collectors.toList());
        Collections.shuffle(result);
        return result;
    }

    private void runIntegersListProcessing() {
        System.out.print("Сколько чисел будет в списке? ");
        int listSize = new Scanner(System.in).nextInt();
        List<Integer> intsList = getRandomIntList(listSize);
        System.out.printf("Исходный список: %s%n", intsList);
        for (int i = 0; i < listSize - 2; i+=2) {
            intsList.add(intsList.get(i));
        }
        System.out.printf("Список после дублирования элементов: %s%n", intsList);

        List<Integer> uniqueList = intsList.stream().distinct().toList();
        System.out.printf("Список без дубликатов: %s%n", uniqueList);

        List<Integer> evenIntsList = uniqueList.stream().filter(number -> number % 2 == 0).toList();
        System.out.printf("Список с четными числами: %s%n", evenIntsList);

        int intsSum = evenIntsList.stream().mapToInt(Integer::intValue).sum();
        System.out.printf("Сумма оставшихся в списке элементов: %d%n", intsSum);
    }
}
