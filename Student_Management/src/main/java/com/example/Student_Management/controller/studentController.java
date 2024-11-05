package com.example.Student_Management.controller;
import com.example.Student_Management.model.student;
import com.example.Student_Management.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class studentController {
 @Autowired
 private studentService employeeService;
 @PostMapping
 public ResponseEntity<student> saveEmployee(@RequestBody student
student){ 
 return new
ResponseEntity<student>(employeeService.saveStudent(student),
HttpStatus.CREATED);
 }
 //GetAll Rest Api
//  @GetMapping
//  public List<student> getAllStudents(){
//  return studentService.getAllStudents();
//  }
 //Get by Id Rest Api
//  @GetMapping("{id}")
//  // localhost:8080/api/employees/1
//  public ResponseEntity<student> getStudentById(@PathVariable("id") long
// employeeID){
//  return new
// ResponseEntity<student>(studentService.getStudentById(id),HttpStatus.OK);
//  }
//  //Update Rest Api
//  @PutMapping("{id}")
//  public ResponseEntity<student> updateEmployee(@PathVariable("id") long
// id,
//  @RequestBody student
// employee){
//  return new
// ResponseEntity<student>(studentService.updateStudent(tudent,id),HttpStatus.OK);
//  }
 //Delete Rest Api
 @DeleteMapping("{id}")
 public ResponseEntity<String> deleteEmployee(@PathVariable("id") long
id){
 //delete employee from db
 employeeService.deleteStudent(id);
 return new ResponseEntity<String>("Student deleted Successfully.",HttpStatus.OK);
 }
}
