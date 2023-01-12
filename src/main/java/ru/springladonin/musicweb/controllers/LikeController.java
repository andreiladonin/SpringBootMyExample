package ru.springladonin.musicweb.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.springladonin.musicweb.entities.Order;
import ru.springladonin.musicweb.entities.OrderItem;
import ru.springladonin.musicweb.entities.Track;
import ru.springladonin.musicweb.services.OrderService;
import ru.springladonin.musicweb.utils.LikeTracks;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/like")
public class LikeController {

    private LikeTracks likeTracks;

    private OrderService orderService;



    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setLikeTracks(LikeTracks likeTracks) {
        this.likeTracks = likeTracks;
    }

    @GetMapping("/")
    public String likePage(Model model) {
        List<OrderItem> orderItems = likeTracks.getItems();
        model.addAttribute("items", orderItems);
        return "like";
    }

    @GetMapping("/add/{id}")
    public String addTrack(Model model, @PathVariable("id") Long id) {
        likeTracks.addTrackById(id);
        return "redirect:/";
    }

    @GetMapping("/create_order")
    public String createOrder(Principal principal) {

        Order order = new Order();
        order.setItems(new ArrayList<>());
        order.setUsername(principal.getName());
        likeTracks.getItems().stream().forEach(orderItem  -> {
            order.getItems().add(orderItem);
            orderItem.setOrder(order);
        });
        likeTracks.getItems().clear();

        orderService.saveOrder(order);
        return "redirect:/";
    }
}
