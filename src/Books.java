import java.sql.*;
import java.util.Scanner;

public class Books {

    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert book selected");
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the category:");
                    String category = scanner.next();
                    System.out.println("enter the author:");
                    String author = scanner.next();
                    System.out.println("enter the charge:");
                    int charge = scanner.nextInt();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "INSERT INTO `books`(`name`, `category`, `author`, `charge`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, name);
                        stmt.setString(2, category);
                        stmt.setString(3, author);
                        stmt.setInt(4, charge);
                        stmt.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.println("view book selected");
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "");
                        String sql = "SELECT `name`, `category`, `author`, `charge` FROM `books`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()) {
                            String getName = rs.getString("name");
                            String getCategory = rs.getString("category");
                            String getAuthor = rs.getString("author");
                            String getCharge = rs.getString("charge");
                            System.out.println("name="+getName);
                            System.out.println("category="+getCategory);
                            System.out.println("author="+getAuthor);
                            System.out.println("charge="+getCharge+"\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.println("search book selected");
                    break;
                case 4:
                    System.out.println("delete book selected");
                    break;
                case 5:
                    System.out.println("update book selected");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }
        }
    }
}