import java.util.*;
//не получается корректно загрузить данные через github, опять съедается код весь(
public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(100);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(100);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Мониторинг доставки");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Тип посылки?");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Хрупкая");
        System.out.println("3 - Скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите описание:");
        String description = scanner.nextLine();

        System.out.println("Введите вес:");
        int weight = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите адрес доставки:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки:");
        int sendDay = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(standardParcel);
                standardBox.addParcel(standardParcel);
                break;
            case 2:
                FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                allParcels.add(fragileParcel);
                fragileBox.addParcel(fragileParcel);
                trackableParcels.add(fragileParcel);
                break;
            case 3:
                System.out.println("Введите срок хранения (дней):");
                int timeToLive = Integer.parseInt(scanner.nextLine());
                PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                allParcels.add(perishableParcel);
                perishableBox.addParcel(perishableParcel);
                break;
            default:
                System.out.println("Неверный тип посылки!");
        }
    }

    private static void sendParcels() {
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость доставки: " + totalCost);
    }

    private static void reportStatus() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Нет посылок с поддержкой трекинга.");
            return;
        }
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable trackable : trackableParcels) {
            trackable.reportStatus(newLocation);
        }
    }

    private static void showBoxContents() {
        System.out.println("Тип коробки?");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Хрупкая");
        System.out.println("3 - Скоропортящаяся");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1:
                printParcels(standardBox.getAllParcels());
                break;
            case 2:
                printParcels(fragileBox.getAllParcels());
                break;
            case 3:
                printParcels(perishableBox.getAllParcels());
                break;
            default:
                System.out.println("Неверный тип коробки!");
        }
    }

    private static void printParcels(List<? extends Parcel> parcels) {
        for (Parcel parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }
}
