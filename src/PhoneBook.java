import java.util.Scanner;

public class PhoneBook {
    Contact[] contacts = new Contact[50];
    Scanner scanner = new Scanner(System.in);

    public void start() {
        block1:
        while (true) {
            System.out.println("1 добавить контакт");//проверять что имя или номер не пустая строка
            System.out.println("2 списк контактов");
            System.out.println("3 поиск контакта по имени"); //ввоим имя и выводим его номер
            System.out.println("4 удалить контакт");//по минеи назодим контакт и в эту ячейку присваиваем null
            System.out.println("5 очистить список контактов ");
            System.out.println("0 выйти");
            String x = scanner.nextLine();
            switch (x) {
                case "1" -> {
                    createContact();
                }
                case "2" -> {
                    printListContact();

                }
                case "3" -> {
                    searchContact();
                }
                case "4" -> {
                    deleteContact();
                }
                case "5" -> {
                    deleteList();
                }
                case "0" -> {
                    break block1;
                }
            }
        }
    }

    public void printListContact() {
        for (Contact contact : contacts) {
            if (contact != null) {
                contact.infoContact();
            }
        }
    }


    public void createContact() {
        block2:
        {
            System.out.println("Введите номер контакта");
            String name = scanner.nextLine();

            while ((name.isEmpty())) {
                System.out.println("Вы ничего не ввели");
                break block2;
            }

            System.out.println("Введите имя контакта");
            String nomerContact = scanner.nextLine();
            while (nomerContact.isEmpty()) {
                System.out.println("Вы ничего не ввели");
                break block2;
            }
            Contact contact = new Contact(name, nomerContact);
            boolean b = addContact(contact);

            if (b) System.out.println("Контакт добавлен");
            else System.out.println("Нет места");
        }
    }

    public boolean addContact(Contact contact) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                contacts[i] = contact;
                return true;
            }
        }
        return false;
    }

    public void searchContact() {
        block3:
        {
            System.out.println("Введите имя для поиска");
            String name = scanner.nextLine();
            for (Contact contact : contacts) {
                if (name.equalsIgnoreCase(contact.nameContact)) {
                    System.out.println(contact.nameContact + " " + contact.nomerPhon);
                    break block3;
                }
            }
        }
    }

    public void deleteContact() {

        System.out.println("Введите имя для удаления контакта");
        String name = scanner.nextLine();
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null) {
                if (name.equalsIgnoreCase(contacts[i].nameContact)) {
                    contacts[i] = null;
                }
            }
        }
    }


    public void deleteList() {
        contacts = new Contact[contacts.length];
        // Arrays.fill(contacts, null);
    }
}
