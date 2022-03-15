import java.io.*;
import java.util.*;


public class Main
{
    static void pause_console(Scanner s)
    {
        System.out.print("\nPress Enter To Continue...");
        s.nextLine();
    }

    static boolean existedFile(String file_name)
    {
        File f = new File(file_name);

        if(f.exists() && !f.isDirectory()) {
            return true;
        }
        System.out.println("\nERROR: File does not existed!");
        return false;
    }

    public static void main(String[] args) throws IOException
    {
        // Init
        Scanner in = new Scanner(System.in);

        String file_name = "";
        List li = new List();
        int choice = -1;

        while (true)
        {
            while (choice < 0 || choice > 6)
            {
                Menu.mainMenu();
                choice = in.nextInt();
                in.nextLine();
            }
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> {
                    if (file_name == "") {
                        System.out.println("\nError: Have not read CSV file yet!\nPlease Import CSV file!");
                        pause_console(in);
                        break;
                    }
                    Options.option01(li, file_name, in);
                    pause_console(in);
                }
                case 2 -> {
                    if (file_name == "") {
                        System.out.println("\nError: Have not read CSV file yet!\nPlease Import CSV file!");
                        pause_console(in);
                        break;
                    }
                    Options.option02(li, file_name, in);
                    pause_console(in);
                }
                case 3 -> {
                    if (file_name == "") {
                        System.out.println("\nError: Have not read CSV file yet!\nPlease Import CSV file!");
                        pause_console(in);
                        break;
                    }
                    Options.option03(li, file_name, in);
                    pause_console(in);
                }
                case 4 -> {
                    Options.option04(li, in);
                    pause_console(in);
                }
                case 5 -> {
                    file_name = Options.option05(in);
                    if (existedFile(file_name)) {
                        li.read(file_name);
                    }
                    pause_console(in);
                }
                case 6 -> {
                    Options.option06(li, in);
                    pause_console(in);
                }
                default -> {
                }
            }
            choice = -1;
        }
        in.close();
    }
}