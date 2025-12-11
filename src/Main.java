import java.util.ArrayList;
import java.util.Scanner;
public class Main{
        public static void main(String[] args) {
                Scanner in=new Scanner(System.in);
                ArrayList<Professor> professors=new ArrayList<>();
                ArrayList<University> universities=new ArrayList<>();
                while(true) {
                        System.out.println("Welcome to University Management System");
                        System.out.println("Write down what service you need.");
                        System.out.println("1-add professor \n" +
                                "2-add university \n" +
                                "3-showing everything \n" +
                                "4-compare object(if you have at least 2 or more data points in one university or professor's field)\n" +
                                "5-quit");
                        System.out.printf("Choose your number:");
                        int a = in.nextInt();
                        in.nextLine();
                        if (a == 1) {
                                System.out.println("1.Name professor");
                                String name=in.nextLine();
                                System.out.println("2.Enter the age");
                                int age=in.nextInt();
                                in.nextLine();
                                System.out.println("3.Enter the department");
                                String dep=in.nextLine();
                                System.out.println("4.Enter the experience years");
                                int exp=in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the knowledge");
                                String knwl=in.nextLine();
                                System.out.println("6.Enter your personal qualities (you can leave it blank)");
                                String prq=in.nextLine();
                                Professor professor=new Professor(name,age,dep,exp,knwl,prq);
                                professors.add(professor);
                                System.out.println("Added Professor!");
                        }else if(a==2){
                                System.out.println("1.Name of University:");
                                String name=in.nextLine();
                                System.out.println("2.Location of University: ");
                                String loc=in.nextLine();
                                System.out.println("3.Enter Education Direction:");
                                String edud=in.nextLine();
                                System.out.println("4.Enter the creation year:");
                                int year=in.nextInt();
                                in.nextLine();
                                System.out.println("5.Enter the course:");
                                String cour=in.nextLine();
                                University university=new University(name,loc,edud,year,cour);
                                universities.add(university);
                                System.out.println("Added the University!");
                        }else if(a==3){
                                for(Professor prof:professors){
                                        prof.showInfo();
                                }
                                for(University univ:universities){
                                        univ.showInfo();
                                }
                        }else if(a==4){
                                if(professors.size()<2 || universities.size()<2){
                                        System.out.println("Not enough data to compare");
                                }else{
                                        int maxexp=0;
                                        Professor maxexpr=null;
                                        int oldyear=0;
                                        University oldest=null;
                                        for(Professor prof:professors){
                                                if(prof.getExperience()>maxexp){
                                                        maxexp=prof.getExperience();
                                                        maxexpr=prof;
                                                }
                                        }
                                        for(University univ: universities){
                                                if(univ.getYear()>oldyear){
                                                        oldyear=univ.getYear();
                                                        oldest=univ;
                                                }
                                        }
                                        System.out.println("Oldest university:"+oldest.getName()+" founded in "+oldyear );
                                        System.out.println("Most experienced professor:"+maxexpr.getName()+" with "+maxexp+" years");
                                }
                        }else if(a==5){
                                System.out.println("Program terminated");
                                break;
                        }
                }

        }
}