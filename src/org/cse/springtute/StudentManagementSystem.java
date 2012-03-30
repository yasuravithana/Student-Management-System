package org.cse.springtute;

public class StudentManagementSystem {

    private StudentRepository repo;

    public StudentRepository getRepo() {
        return repo;
    }

    public void setRepo(StudentRepository repo) {
        this.repo = repo;
    }

    public void listAllStudents() {
        Object[] listofStudents=repo.findAllStudents().toArray();
        for(int i=0;i<listofStudents.length;i++){
            System.out.println(((Student)listofStudents[i]).getRegNumber()+"\t"+((Student)listofStudents[i]).getFirstName()+" "
                    +((Student)listofStudents[i]).getLastName());
        }
            //Get all the students from repository and print them in the screen
    }

    public void registerStudent(Student stu){
        repo.saveStudent(stu);
            //Save the new student using repository
    }
}
