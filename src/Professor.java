public class Professor {
    private String name;
    private int age;
    private String dep;
    private int experience;
    private String knowledge;
    private String personalqual;

    public Professor(String name, int age, String dep, int experience, String knowledge,String personalqual){
        this.name=name;
        this.age=age;
        this.dep=dep;
        this.experience=experience;
        this.knowledge=knowledge;
        if(personalqual==null|| personalqual.isEmpty() ){
            this.personalqual="Не указан";
        }else{
            this.personalqual=personalqual;
        }
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public String getDep() {
        return dep;
    }

    public String getPersonalqual() {
        return personalqual;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public void setExperience(int experience) {
        this.experience=experience;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public void setPersonalqual(String personalqual) {
        this.personalqual = personalqual;
    }
    public void showInfo(){
        System.out.println("Professor:"+name+","+age+"years old. Department: "+dep+" work experience: "+experience" years,Study knowledge: "+knowledge+" and Personal Quality: "+personalqual);
    }
}
