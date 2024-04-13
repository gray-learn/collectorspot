package com.collector.orderservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {

//    @Autowired
//    private OrderServiceImpl orderService;

    @GetMapping("/aaa")
    public String home() {
        return "index";
    }



//    @RequestMapping("/index")
//    public String home() {
//        return "index";
//    }
//
//    @PostMapping("/add")
//    public @ResponseBody String add(@RequestParam("empId") int empId, //
//                                    @RequestParam("empName") String empName, //
//                                    @RequestParam("jobTitle") String jobTitle, //
//                                    @RequestParam("salary") double salary, //
//                                    @RequestParam("deptNo") int deptNo) {
//
//        Employee employee = new Employee(empId, empName, jobTitle, salary, deptNo);
//        empRepository.save(employee);
//        return "An employee info added";
//
//    }
//
//    @PostMapping("/update")
//    public @ResponseBody String edit(@RequestParam("empId") int empId, //
//                                     @RequestParam("empName") String empName, //
//                                     @RequestParam("jobTitle") String jobTitle, //
//                                     @RequestParam("salary") double salary, //
//                                     @RequestParam("deptNo") int deptNo) {
//        Employee employee = new Employee(empId, empName, jobTitle, salary, deptNo);
//        empRepository.save(employee);
//        return "updated";
//    }
//
//    @RequestMapping("/edit")
//    public String Modify() {
//        return "edit";
//    }
//
//    @RequestMapping("/show")
//    public String show(Model model) {
//        model.addAttribute("employee", empRepository.findAll());
//        return "show";
//    }
}
