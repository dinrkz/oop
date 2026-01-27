import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/oop_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2008";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }




    public void saveUniversity(University uni) {
        String sql = "INSERT INTO universities (name, location, education_direction, creation_year, course) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, uni.getName());
            pstmt.setString(2, uni.getLocation());
            pstmt.setString(3, uni.getEducationdirect());
            pstmt.setInt(4, uni.getYear());
            pstmt.setString(5, uni.getCourse());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving university: " + e.getMessage());
        }
    }
    public void saveProfessor(Professor prof) {
        String sql = "INSERT INTO professors (name, age, department, experience, knowledge, personal_qualities,city) VALUES (?, ?,?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, prof.getName());
            pstmt.setInt(2, prof.getAge());
            pstmt.setString(3, prof.getDep());
            pstmt.setInt(4, prof.getExperience());
            pstmt.setString(5, prof.getKnowledge());
            pstmt.setString(6, prof.getPersonalqual());
            pstmt.setString(7,prof.getCity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving professor: " + e.getMessage());
        }
    }








    public void deleteUniversity(String name) {
        String sql = "DELETE FROM universities WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            int deleted = pstmt.executeUpdate();
            if (deleted > 0) System.out.println("University deleted from DB.");
        } catch (SQLException e) {
            System.out.println("Error deleting university: " + e.getMessage());
        }
    }
    public void deleteProfessor(int id) {
        String sql = "DELETE FROM professors WHERE id = ?";
        try(Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql)) {
            pstmt.setInt(1,id);
            int deleted=pstmt.executeUpdate();
            if (deleted > 0) System.out.println("Professor deleted from DB.");
            else System.out.println("Professor not deleted from DB.");
        }catch (SQLException e) {
            System.out.println("Error deleting Professor: " + e.getMessage());
        }

    }




    public void updateUniversityLocation(int id, String location) {
        String sql = "UPDATE universities SET location = ? WHERE id = ?";
        try (Connection conn= getConnection();
             PreparedStatement ps= conn.prepareStatement(sql)){

            ps.setInt(2,id);
            ps.setString(1,location);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.out.println("Error saving university: " + e.getMessage());
        }
    }
    public void updateProfessorExperience(String name, int newExp) {
        String sql = "UPDATE professors SET experience = ? WHERE name = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newExp);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving Professor: " + e.getMessage());
        }
    }
    public void updateProfCity(String name,String city){
        String sql="UPDATE professors SET city = ? WHERE name = ?";
        try(Connection conn=getConnection();
        PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,city);
            ps.setString(2,name);
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error saving Professor: " + e.getMessage());
        }
    }










    public void UniversitiessortedbyYear(){
        String sql = "SELECT * FROM universities ORDER BY creation_year ASC";
        try(Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)) {
            System.out.println("Universities sorted by year");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        "| Name: " + rs.getString("name") +
                        "| Year: " + rs.getInt("creation_year"));
            }
        } catch(SQLException e){
                System.out.println("Error: " + e.getMessage());
        }
    }
    public void ProfessorssortedbyYear(){
        String sql = "SELECT * FROM professors ORDER BY experience ASC";
        try(Connection conn=getConnection();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql)){
            System.out.println("Professors sorted by year");
            while(rs.next()){
                System.out.println("ID"+ rs.getInt("id")+
                        "|Name "+rs.getString("name")+
                        "|Experience "+rs.getString("experience"));
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

