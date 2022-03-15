import java.io.*;
import java.util.*;

public class List
{
    private ArrayList<Student> list;

    public List()
    {
        this.list = new ArrayList<>();
    }

    public List(ArrayList<Student> list)
    {
        this.list = list;
    }

    public ArrayList<Student> getList() {
        return list;
    }

    public void read(String file_name) throws IOException
    {
        this.list = new ArrayList<>();
        BufferedReader buffer = new BufferedReader(new FileReader(file_name));

        String line;
        buffer.readLine();
        while (true)
        {
            line = buffer.readLine();
            if(line == null)
            {
                break;
            }
            String[] s = line.split(", ");

            Student student = new Student(Integer.parseInt(s[0]), s[1], Integer.parseInt(s[2]), s[3], s[4], s[5]);

            list.add(student);
        }

        buffer.close();
        System.out.println("\nRead File Success!");
    }

    public void write(String file_name) throws IOException
    {
        BufferedWriter buffer = new BufferedWriter(new FileWriter(file_name));
        buffer.write("ID, Name, Score, Address, Image, Note" + "\n");

        for (Student student : list) {
            buffer.write(student.toString() + "\n");
        }

        buffer.close();
    }

    public void print()
    {
        
        if (list.size() == 0) {
            System.out.println("Have no any data!");
            return;
        }
        
        System.out.println("\n<===========Student List===========>");
        System.out.println("ID, Name, Score, Address, Image, Note");
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }

    // Insert student element to CSV file
    public void insert(Student s, String file_name) throws IOException
    {
        for (Student student : list) {
            if(s.getId() == student.getId())
            {
                System.out.println("Error: ID has been existed!");
                return;
            }
        }
        list.add(s);
        write(file_name);
    }

    // Delete student element from CSV file
    public boolean delete(int id, String file_name) throws IOException
    {
        for (Student student : list) {
            if(student.getId() == id)
            {
                list.remove(student);
                write(file_name);
                return true;
            }
        }
        return false;
    }

    public boolean find(int id)
    {
        for (Student student : list)
        {
            if(student.getId() == id)
                return true;
        }
        return false;
    }

    public boolean update(int id, int new_id, int option, String file_name, Scanner in) throws IOException
    {
        for (Student student : list)
        {
            if(student.getId() == id)
            {
                student.update(option, new_id, in);
                write(file_name);
                return true;
            }
        }
        return false;
    }

    private ArrayList<Student> copyList() {
        return new ArrayList<>(list);
    }

    public ArrayList<Student> sortIDsDecrease()
    {
        ArrayList<Student> copy = copyList();

        Collections.sort(copy, new Comparator<Student>() {
            public int compare(Student s1, Student s2)
            {
                Integer id1 = s1.getId();
                Integer id2 = s2.getId();
                return id2.compareTo(id1);
            }
        });

        return copy;
    }

    public ArrayList<Student> sortIDsIncrease()
    {
        ArrayList<Student> copy = copyList();

        Collections.sort(copy, new Comparator<Student>() {
            public int compare(Student s1, Student s2)
            {
                Integer id1 = s1.getId();
                Integer id2 = s2.getId();
                return id1.compareTo(id2);
            }
        });

        return copy;
    }

    public ArrayList<Student> sortScoresDecrease()
    {
        ArrayList<Student> copy = copyList();

        Collections.sort(copy, new Comparator<Student>() {
            public int compare(Student s1, Student s2)
            {
                Integer sc1 = s1.getScore();
                Integer sc2 = s2.getScore();
                return sc2.compareTo(sc1);
            }
        });

        return copy;
    }

    public ArrayList<Student> sortScoresIncrease()
    {
        ArrayList<Student> copy = copyList();

        Collections.sort(copy, new Comparator<Student>() {
            public int compare(Student s1, Student s2)
            {
                Integer sc1 = s1.getScore();
                Integer sc2 = s2.getScore();
                return sc1.compareTo(sc2);
            }
        });

        return copy;
    }
}

