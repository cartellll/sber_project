package com.example.sberbank_project.controller;

import com.example.sberbank_project.dtoController.CarController;
import com.example.sberbank_project.dtoController.PointController;
import com.example.sberbank_project.dtoController.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import simpleModel.SimpleCar;
import simpleModel.SimpleUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RestController {
    @Autowired
    private CarController carController;

    @Autowired
    private PointController pointController;

    @Autowired
    private UserController userController;

    @GetMapping("/index")
    public String getLoginForm() {
        return "/index";
    }

    @PostMapping("/index")
    public String login(@ModelAttribute(name = "user") SimpleUser user, Model model) {

        if (userController.getUserByLoginAndPassword(user) != null) {
            return "redirect:/showCars";
        }

        model.addAttribute("invalidCredentials", true);
        return "/index";
    }

    @GetMapping("/showCars")
    public String showCars(Model model) {
        model.addAttribute("user", userController.getActiveUser());
        return "showCars";
    }

    @GetMapping("/showNewCarForm/{pointID}")
    public String showNewCarForm(@PathVariable(value = "pointID") long pointID, Model model) {
        model.addAttribute("car", new SimpleCar());
        model.addAttribute("pointID", pointID);
        return "new_car";
    }

    @PostMapping("/saveCar/{pointID}")
    public String saveCar(@Valid @ModelAttribute("car")  SimpleCar simpleCar, BindingResult bindingResult, @PathVariable(value = "pointID") long pointID, Model model, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            String referer = request.getHeader("Referer");
            return "redirect:"+referer;
        }

        pointController.setCarPointById(pointID, simpleCar);
        carController.saveCar(simpleCar);
        return "redirect:/showCars";
    }

    @GetMapping("/showFormForUpdate/{ID}")
    public String showFormForUpdate(@PathVariable(value = "ID") long ID, Model model) {
        model.addAttribute("car", carController.getCarById(ID));
        return "update_car";
    }

    @GetMapping("/deleteCar/{ID}")
    public String deleteCar(@PathVariable(value = "ID") long ID) {
        carController.deleteCarById(ID);
        return "redirect:/showCars";
    }
}