package assignment4;

class Course {
    private String name;
    private int numberOfStudent;
    private Student[] students;
    
    public Course (String n) {
        this.name=n;
        this.numberOfStudent=0;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfStudent() {
        return numberOfStudent;
    }
    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }
    public Student[] getStudents() {
        return students;
    }
    
    public boolean isFull() {
        return (this.numberOfStudent==10);
    }
    
    public void registerStudent (Student student) {
        if (!this.isFull()){
            this.students[numberOfStudent]=student;
            this.numberOfStudent++;
        }
    }

}
