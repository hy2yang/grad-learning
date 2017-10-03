package assignment4;

class Test4 {
    public static void main(String args[]){
    Course c1=new Course("soccer");
    Student[] s=new Student[12];
    
    for (int i=0;i<12;i++) {
        String tname=Long.toHexString(Double.doubleToLongBits(Math.random()));
        int tid=(int)Math.random()*100;
        s[i]=new Student(tname,tid);
        c1.registerStudent(s[i]);
        }
    
    }
    

}
