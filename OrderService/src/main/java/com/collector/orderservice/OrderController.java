package com.collector.orderservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private com.collector.orderservice.OrderService orderService;

    @GetMapping("/aaa")
    public String home() {
        return "index";
    }

    @Autowired
    private com.collector.orderservice.OrderService OrderService;

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
