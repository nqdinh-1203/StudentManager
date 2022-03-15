import java.util.Scanner;

public class Student
{
    private int id;
    private String name;
    private int score;
    private String image;
    private String address;
    private String note;

    // Constructors
    public Student()
    {
        this.id = 0;
        this.name = "";
        this.score = 0;
        this.image = "";
        this.address = "";
        this.note = "";
    }

    public Student(int id, String name, int score,String address, String image, String note)
    {
        this.id = id;
        this.name = name;
        this.score = score;
        this.address = address;
        this.image = image;
        this.note = note;
    }
    /*============================================================================*/

    // Getter and Setter
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return this.id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
    public int getScore() {
        return this.score;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return this.note;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }
    /*============================================================================*/

    // All Methods
    public String toString()
    {
        return id + ", " + name + ", " + score + ", " + address + ", " + image + ", " + note;
    }

    public void input(Scanner in)
    {
        System.out.print("Input ID student: ");
        id = in.nextInt();
        in.nextLine();

        System.out.print("Input Name: ");
        name = in.nextLine();

        score = -1;
        while (score < 0 || score > 100) {
            System.out.print("Input Score (0 - 100): ");
            score = in.nextInt();
            in.nextLine();
        }
        System.out.print("Input Address: ");
        address = in.nextLine();

        System.out.print("Input Image: ");
        image = in.nextLine();

        System.out.print("Input Note: ");
        note = in.nextLine();
    }

    public void update(int option, int new_id, Scanner in)
    {
        switch (option) {
            case 1 -> {
                setId(new_id);
            }
            case 2 -> {
                System.out.println("[+] Update Name:");
                System.out.print("New Name: ");
                String new_name = in.nextLine();
                setName(new_name);
            }
            case 3 -> {
                System.out.println("[+] Update Score:");

                int new_score = -1;
                while (new_score < 0 || new_score > 100) {
                    System.out.print("New Score (0 - 100): ");
                    new_score = in.nextInt();
                    in.nextLine();
                }

                setScore(new_score);
            }
            case 4 -> {
                System.out.println("[+] Update Address:");
                System.out.print("New Address: ");
                String new_address = in.nextLine();

                setAddress(new_address);
            }
            case 5 -> {
                System.out.println("[+] Update Image:");
                System.out.print("New Image: ");
                String new_image = in.nextLine();

                setImage(new_image);
            }
            case 6 -> {
                System.out.println("[+] Update Note:");
                System.out.print("New Note: ");
                String new_note = in.nextLine();

                setNote(new_note);
            }
            default -> {
            }
        }
    }
}