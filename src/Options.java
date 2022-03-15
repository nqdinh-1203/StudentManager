import java.io.IOException;
import java.util.Scanner;

public class Options {
    static void option01(List li, String file_name, Scanner in) throws IOException
    {
        Student s = new Student();
        s.input(in);
        li.insert(s, file_name);
    }

    static void option02(List li, String file_name, Scanner in) throws IOException
    {
        System.out.print("Input ID: ");
        int id = in.nextInt();
        in.nextLine();

        if (!li.find(id)) {
            System.out.println("ID has not been existed!");
            return;
        }

        int choice = -1;

        while (choice < 0 || choice > 6)
        {
            Menu.updateMenu();
            choice = in.nextInt();
            in.nextLine();
        }
        if (choice == 0) {
            return;
        }
        int new_id = 0;
        if (choice == 1) {
            System.out.println("[+] Update ID:");
            System.out.print("New ID: ");
            new_id = in.nextInt();
            in.nextLine();

            if (li.find(new_id)) {
                System.out.println("ID has been existed!");
                return;
            }
        }

        boolean success = li.update(id, new_id, choice, file_name, in);

        if (success) {
            System.out.println("Update Successful!");
        } else {
            System.out.println("ID has not been existed!");
        }
        return;
    }

    static void option03(List li, String file_name, Scanner in) throws IOException
    {
        System.out.print("Input ID: ");
        int id = in.nextInt();
        in.nextLine();

        boolean success = li.delete(id, file_name);

        if (success) {
            System.out.println("Delete Successful!");
        } else {
            System.out.println("ID has not been existed!");
        }
    }

    static void option04(List li, Scanner in) throws IOException
    {
        int choice = -1;

        while (choice < 0 || choice > 5)
        {
            Menu.showListMenu();
            choice = in.nextInt();
            in.nextLine();
        }
        List temp_list = new List();

        switch (choice) {
            case 0:
                return;
            case 1:
                temp_list = new List(li.sortIDsIncrease());
                break;
            case 2:
                temp_list = new List(li.sortIDsDecrease());
                break;
            case 3:
                temp_list = new List(li.sortScoresIncrease());
                break;
            case 4:
                temp_list = new List(li.sortScoresDecrease());
                break;
            case 5:
                li.print();
                return;
            default:
                break;
        }
        temp_list.print();
        if (temp_list.getList().size() == 0) {
            return;
        }

        System.out.print("\nDo you want to export this list to CSV file? (y/n): ");
        String choice1 = in.nextLine();

        if(choice1.equals("y") || choice1.equals("Y"))
        {
            System.out.print("Input file name: ");
            String file_name = in.nextLine();

            temp_list.write("FileCSV/" + file_name);
        }
    }

    static String option05(Scanner in) {
        System.out.print("Input file name to import: ");
        String file_name = in.nextLine();

        return "FileCSV/" + file_name;
    }

    static void option06(List li, Scanner in) throws IOException
    {
        System.out.print("Input file name to export: ");
        String file_name = in.nextLine();

        li.write("FileCSV/" + file_name);
    }
}