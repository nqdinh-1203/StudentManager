import java.io.IOException;

public class Menu {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void updateMenu() throws IOException
    {
        ClearConsole();
        System.out.println("==========UPDATE MENU=========");
        System.out.println("1. Update ID");
        System.out.println("2. Update Name");
        System.out.println("3. Update Score");
        System.out.println("4. Update Address");
        System.out.println("5. Update Image");
        System.out.println("6. Update Note");
        System.out.println("0. Exit");
        System.out.print("Input your choice: ");
    }
    static void showListMenu() throws IOException
    {
        ClearConsole();
        System.out.println("==========SHOW LIST MENU=========");
        System.out.println("1. Increase IDs");
        System.out.println("2. Decrease IDs");
        System.out.println("3. Increase Scores");
        System.out.println("4. Decrease Scores");
        System.out.println("5. Normal");
        System.out.println("0. Exit");
        System.out.print("Input your choice: ");
    }
    static void mainMenu() throws IOException
    {
        ClearConsole();
        System.out.println("=============MENU=============");
        System.out.println("1. Add new Student");
        System.out.println("2. Update Student information");
        System.out.println("3. Delete Student");
        System.out.println("4. Show Student List");
        System.out.println("5. Import CSV file");
        System.out.println("6. Export CSV file");
        System.out.println("0. Exit");
        System.out.print("Input your choice: ");
    }
}