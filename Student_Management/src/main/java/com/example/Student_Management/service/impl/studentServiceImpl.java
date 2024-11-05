package com.example.Student_Management.service.impl;

import com.example.Student_Management.model.student;
import com.example.Student_Management.repository.studentRepository;
import com.example.Student_Management.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class studentServiceImpl implements studentService {
 @Autowired
 private studentRepository studentRepsitory;
 //save employee in database
 @Override
 public student saveStudent(student student){
 return studentRepsitory.save(student);
 }
 //get all employee form database
 @Override
 public List<student> getAllStudent() {
 return studentRepsitory.findAll();
 }
 //get employee using id
 @Override
 public student getStudentById(long id) {
 Optional<student> employee = studentRepsitory.findById(id);
 if(employee.isPresent()){
 return employee.get();
 }else {
 throw new RuntimeException();
 }
 }
 //update employee
 @Override
 public student updateStudent(student student, long id) {
 student existingStudent =
studentRepsitory.findById(id).orElseThrow(
 ()-> new RuntimeException()
 );
 existingStudent.setFirstName(student.getFirstName());
 existingStudent.setLasttName(student.getLasttName());
 existingStudent.setEmail(student.getEmail());
 existingStudent.setDepartment(student.getDepartment());
 existingStudent.setYear(student.getYear());
 // save
 studentRepsitory.save(existingStudent);
 return existingStudent;
 }
 //delete employee
 @Override
 public void deleteStudent(long id) {
 //check
 studentRepsitory.findById(id).orElseThrow(()-> new
RuntimeException());
 //delete
 studentRepsitory.deleteById(id);
 }}