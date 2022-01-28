package edu.miu.cs.cs425.demowebapps.eregistrar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.miu.cs.cs425.demowebapps.eregistrar.model.Student;
import edu.miu.cs.cs425.demowebapps.eregistrar.services.StudentService;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/eregistrar/student/list","/student/list"})
    public ModelAndView listStudents() {
        ModelAndView modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();
        modelAndView.addObject("students", students);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("studentsCount", students.size());
        modelAndView.setViewName("student/list");
        return modelAndView;
    }

    @GetMapping(value = {"/eregistrar/student/new","/student/new"})
    public String displayNewStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/new";
    }

    @PostMapping(value = {"/eregistrar/student/new","/student/new"})
    public String addNewStudent(@Validated @ModelAttribute("student") Student student,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/new";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/edit/{studentId}","/student/edit/{studentId}"})
    public String editStudent(@PathVariable Integer studentId, Model model) {
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            model.addAttribute("student", student);
            return "student/edit";
        } else {
            // TODO
        }
        return "student/list";
    }

    @PostMapping(value = {"/eregistrar/student/edit","/student/edit"})
    public String updateStudent(@Validated @ModelAttribute("student") Student student,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "student/edit";
        }
        student = studentService.saveStudent(student);
        return "redirect:/eregistrar/student/list";
    }

    @GetMapping(value = {"/eregistrar/student/delete/{studentId}","/student/delete/{studentId}"})
    public String deleteStudent(@PathVariable Integer studentId, Model model) {
        studentService.deleteStudentById(studentId);
        return "redirect:/eregistrar/student/list";
    }

//    @GetMapping(value = {"/elibrary/book/search", "/book/search"})
//    public ModelAndView searchBooks(@RequestParam String searchString) {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Book> books = bookService.searchBooks(searchString);
//        modelAndView.addObject("books", books);
//        modelAndView.addObject("searchString", searchString);
//        modelAndView.addObject("booksCount", books.size());
//        modelAndView.setViewName("book/list");
//        return modelAndView;
//    }

}
