package com.example.erp_App.Erpcontroller;

import com.example.erp_App.Dto;
import com.example.erp_App.Erpservice.ErpService;
import com.example.erp_App.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class Erpcontroller {

    @Autowired
    private ErpService erpService; //Di

    @GetMapping("All-student")  //http://localhost:8081/api/v1/All-student
    public List<Student> findall(){
        return erpService.Allstudents();
    }


    @GetMapping("findbyid/id/{id}")//http://localhost:8081/api/v1/findbyid/id/{id}
    public Student findbyid(@PathVariable  Integer id){
        return erpService.findByid(id);
    }

    @GetMapping("All_studentpercentage")//http://localhost:8081/api/v1/All_studentpercentage
    public List<Dto> allstudentpercentage(){
        return erpService.PercentageStudents();
    }


    @GetMapping("findtopper")
    public Student findtopper(){
        return erpService.Topper();
    }


    @GetMapping("FindLowest")
    public Student findLowest(){
        return erpService.Dumbest();
    }


    @PostMapping("AddStudent")
    public void AddStudent(Student newstudent){
        erpService.Addstudent(newstudent);
    }

    @PutMapping("Updatestudent/id/{id}")
    public void updatestudent(@PathVariable Integer id, Student newstudent){
        erpService.UpdateStudent(id,newstudent);
    }


    @DeleteMapping("DeleteStudent")
    public void deleteStudent(@PathVariable Integer id){
        erpService.DeleteStudent(id);
    }


}
