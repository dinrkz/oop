public class University {
    private String name;
    private String location;
    private String course;
    private String  educationdirect;
    private int year;
    public University(String name, String location, String educationdirect, int year, String course){
        this.name=name;
        this.location=location;
        this.educationdirect=educationdirect;
        this.year=year;
        this.course=course;
    }

    public String getName() {
        return name;
    }
    public int getYear(){
        return year;
    }

    public String getLocation() {
        return location;
    }

    public String getEducationdirect() {
        return educationdirect;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setYear(int year){
        this.year = year;
    }

    public void setEducationdirect(String educationdirect) {
        this.educationdirect = educationdirect;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    public void showInfo(){
        System.out.println("University:"+name+", created in "+year+". Location: "+location+". Education direct its a "+educationdirect+". Teached:"+course+" courses.");
    }
}
