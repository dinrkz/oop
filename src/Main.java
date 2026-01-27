import java.util.ArrayList;
import java.util.Scanner;
public class Main{
        public static void main(String[] args) {
                Scanner in=new Scanner(System.in);
                ArrayList<Entity>entities=new ArrayList<>();
                DatabaseManager dbManager = new DatabaseManager();
                while(true) {
                        System.out.println("Welcome to University Management System");
                        System.out.println("Write down what service you need.");
                        System.out.println("1-add professor \n" +
                                "2-add university \n" +
                                "3-showing everything \n" +
                                "4-sorting tables\n" +
                                "5-delete table from DB \n" +
                                "6-update data(University/Professor)\n" +
                                "7-quit");
                        System.out.print("Choose your number:");
                        int a = in.nextInt();
                        in.nextLine();
                        if (a == 1) {
                                System.out.println("1.Name professor");
                                String name = in.nextLine();
                                System.out.println("2.Enter the age");
                                int age = in.nextInt();
                                in.nextLine();
                                System.out.println("3.Enter the department");
                                String dep = in.nextLine();
                                System.out.println("4.Enter the experience years");
                                int exp = in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the knowledge");
                                String knwl = in.nextLine();
                                System.out.println("6.Enter your personal qualities (you can leave it blank)");
                                String prq = in.nextLine();
                                System.out.println("7.Enter the city");
                                String city=in.nextLine();
                                entities.add(new Professor(name, age, dep, exp, knwl, prq,city));
                                dbManager.saveProfessor(new Professor(name, age, dep, exp, knwl, prq,city));
                                System.out.println("Professor successfully saved!");
                        } else if (a == 2) {
                                System.out.println("1.Name of University:");
                                String name = in.nextLine();
                                System.out.println("2.Location of University: ");
                                String loc = in.nextLine();
                                System.out.println("3.Enter Education Direction:");
                                String edud = in.nextLine();
                                System.out.println("4.Enter the creation year:");
                                int year = in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the course:");
                                String cour = in.nextLine();
                                entities.add(new University(name, loc, edud, year, cour));
                                dbManager.saveUniversity(new University(name, loc, edud, year, cour));
                                System.out.println("University successfully saved!");
                        } else if (a == 3) {
                                System.out.println("What do you need?"+"\n");
                                System.out.println("1-University" +"2.Professors"+"3.Everything");
                                System.out.println("Choose your number:");
                                int s=in.nextInt();
                                in.nextLine();
                                if(s==1){
                                        for(Entity e:entities){
                                                if(e instanceof University) e.showInfo();
                                        }
                                }
                                if(s==2){
                                        for(Entity e:entities){
                                                if(e instanceof Professor) e.showInfo();
                                        }
                                }
                                if(s==3){
                                        for(Entity e:entities){
                                                System.out.println(e.toString());
                                        }
                                }
                        } else if (a == 4) {
                                System.out.println("Choose sorting table:" + "\n");
                                System.out.println("1.University table" + "2.Professors table" + "\n");
                                int i=in.nextInt();
                                in.nextLine();
                                if(i==1) dbManager.UniversitiessortedbyYear();
                                if(i==2) dbManager.ProfessorssortedbyYear();
                        }else if (a == 5) {
                                System.out.println("Select which database you want to delete?\n" +
                                        "1-Professors\n" +
                                        "2-Universities");
                                int i = in.nextInt();
                                in.nextLine();
                                if (i == 1) {
                                        System.out.println("ID Professor:");
                                        int id = in.nextInt();
                                        in.nextLine();
                                        dbManager.deleteProfessor(id);
                                }
                                if (i == 2) {
                                        System.out.println("Name University:");
                                        String name = in.nextLine();
                                        dbManager.deleteUniversity(name);
                                }
                        }else if (a == 6) {
                                System.out.println("What do you want to update?\n" +
                                        "1-Location University\n" +
                                        "2-Experience Professors\n" +
                                        "3-City Professors\n" +
                                        "Choose your number:");
                                int p = in.nextInt();
                                in.nextLine();
                                if (p == 1) {
                                        System.out.println("University id:");
                                        int id = in.nextInt();
                                        in.nextLine();
                                        System.out.println("Update Location University:");
                                        String loc = in.nextLine();
                                        dbManager.updateUniversityLocation(id, loc);
                                }
                                if (p == 2) {
                                        System.out.println("Professor name:");
                                        String name = in.nextLine();
                                        System.out.println("Update Experience Professor(number):");
                                        int exp=in.nextInt();
                                        in.nextLine();
                                        dbManager.updateProfessorExperience(name,exp);
                                }if(p==3){
                                        System.out.println("Professor name:");
                                        String name=in.nextLine();
                                        System.out.println("Update City Professor:");
                                        String city=in.nextLine();
                                        dbManager.updateProfCity(name,city);
                                }

                        }else if (a == 7) {
                                System.out.println("Program terminated");
                                break;
                        }
                }

        }
}