package org.cse.springtute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleStudentRepository implements StudentRepository {

	private Map<Long, Student> studentsDb = new HashMap<Long, Student>();

    public void setStudentsDb(Map<Long, Student> studentsDb) {
        this.studentsDb = studentsDb;
    }

	@Override
	public void saveStudent(Student stu) {
            studentsDb.put(stu.getRegNumber(), stu);
	}

	@Override
	public void deleteStudent(Student stu) {
            studentsDb.remove(stu.getRegNumber());
	}

	@Override
	public Student findStudent(long regNumber) {
            if(studentsDb.containsKey(regNumber))
                return studentsDb.get(regNumber);
            else
                return null;
	}

	@Override
	public void updateStudent(Student stu) {
            studentsDb.put(stu.getRegNumber(), stu);
	}

	@Override
	public List<Student> findAllStudents() {
            List<Student> list = new ArrayList<Student>();
            if(studentsDb.isEmpty())
		return null;
            else{
                list.addAll(studentsDb.values());
                return list;
            }
	}

}
