package com.example.demo.controller;

import com.example.demo.modele.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class OrderViewController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders")
    public String getOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @PostMapping("/confirmOrder")
    public String confirmOrder(
            @RequestParam("productName") String productName,
            @RequestParam("price") double price,
            @RequestParam("quantity") int quantity,
            @RequestParam("customerName") String customerName,
            Model model) {

        Order order = new Order();
        order.setProductName(productName);
        order.setPrice(price);
        order.setQuantity(quantity);
        order.setCustomerName(customerName);

        orderRepository.save(order);

        return "redirect:/orders";
    }
}
