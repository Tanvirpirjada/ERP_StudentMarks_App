package com.example.erp_App.Erpservice;

import com.example.erp_App.Dto;
import com.example.erp_App.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ErpService {

    private static final List<Student> student=new ArrayList<>();

    static {
        Student s1=new Student(1,"tanvir","male", List.of(76.0,65.0,58.0,80.0,77.0),"Modasa");
        student.add(s1);
        Student s2=new Student(2,"hasnain","Male",List.of(86.0,65.0,87.0,77.0,75.0),"ahemdabad");
        student.add(s2);
        Student s3=new Student(3,"Aniruth","Male",List.of(67.0,88.0,71.0,60.0,65.0),"Bhavnagar");
        student.add(s3);
        Student s4=new Student(4,"Umang","Male",List.of(75.0,54.0,65.0,64.0,82.0),"Mahesana");
        student.add(s4);
        Student s5=new Student(5,"Hetanshi","Female",List.of(96.0,58.0,76.0,81.0,75.0),"Surat");
        student.add(s5);

    }

    public List<Student> Allstudents(){
        return student;
    }

    public Student findByid(Integer id){
        for(Student students: student){
            if(students.getRoll_no()==id){
                return students;
            }
        }
        return null;
    }

    public static List<Dto> PercentageStudents(){
        List<Dto> info=new ArrayList<>();
        for(Student students: student){
            List<Double> marks=students.getMarks(); Double pre=0.0;
            for(Double mark: marks){
                pre+=mark;
            }
            pre*=0.25;

            Dto dto=new Dto(students.getRoll_no(),students.getName(),pre);
            info.add(dto);
        }
        return info;
    }

    public static Student Topper(){
        List<Dto> list=PercentageStudents(); Double number=0.0; Integer id=0;
       for(Dto lists: list){
           if(lists.getPercentage()>number){
               number= lists.getPercentage();
               id= lists.getRollno();
           }
       }
       for(Student topper: student){
           if(topper.getRoll_no()==id){
               return topper;
           }
       }
       return null;

    }

    public Student Dumbest(){
        List<Dto> list=PercentageStudents(); Double number=101.0; Integer id=0;
        for(Dto lists: list){
           if(lists.getPercentage()<number){
               number= lists.getPercentage();
               id= lists.getRollno();
           }
        }
        for(Student topper: student){
            if(topper.getRoll_no()==id){
                return topper;
            }
        }
        return null;
    }

    public void Addstudent(Student newstudent){
        student.add(newstudent);
    }

    public void UpdateStudent(Integer id,Student newstudent){
        Student oldstudent=findByid(id);

        oldstudent.setRoll_no(newstudent.getRoll_no());
        oldstudent.setName(newstudent.getName());
        oldstudent.setGender(newstudent.getGender());
        oldstudent.setMarks(newstudent.getMarks());
        oldstudent.setCity(newstudent.getCity());
    }

    public void DeleteStudent(Integer id){
       Student detainstudent=findByid(id);
       student.remove(detainstudent);
    }
}
