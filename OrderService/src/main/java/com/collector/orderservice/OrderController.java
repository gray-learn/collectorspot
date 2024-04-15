package com.collector.orderservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/aaa")
    public String home() {
        return "index";
    }

    @Autowired
    private OrderServiceImpl OrderService;

    //create operation
    @PostMapping("/add")
    public @ResponseBody String add(@RequestBody Order order) {
        orderService.save(order);
        return "Order added";
    }
    //read operation
    @GetMapping("/show")
    public @ResponseBody Iterable<Order> show() {
        return orderService.findAll();
    }
    //update operation
    @PutMapping("/update/{id}")
    public @ResponseBody String update(@PathVariable Long id, @RequestBody Order updatedOrder) {
        if (orderService.existsById(id)) {
            orderService.save(updatedOrder);
            return "Order updated";
        } else {
            return "Order not found";
        }
    }
    //delete operation
    @DeleteMapping("/delete/{id}")
    public @ResponseBody String delete(@PathVariable Long id) {
        if (orderService.existsById(id)) {
            orderService.deleteById(id);
            return "Order deleted";
        } else {
            return "Order not found";
        }
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
