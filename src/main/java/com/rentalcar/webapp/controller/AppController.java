package com.rentalcar.webapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentalcar.webapp.entities.Car;
import com.rentalcar.webapp.service.CarService;

@Controller
@RequestMapping("/")   //gestire richieste Get e Post "/ :controller predefinito"
public class AppController {
 
    @Autowired
    CarService carService;
     
    @Autowired
    MessageSource messageSource;
 
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public String listCars(ModelMap model) {
 
        List<Car> cars = carService.findAllCars();
        model.addAttribute("cars", cars);
        return "allcars";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
    public String newCar(ModelMap model) {
        Car car = new Car();
        model.addAttribute("car", car);
        model.addAttribute("edit", false);
        return "registration";
    }
 
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveCar(@Valid Car car, BindingResult result, //bindingResult contiene il risultato di questa convalida
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
//        if(carService!=null){
//            FieldError ssnError =new FieldError("car","id",messageSource.getMessage("non.unique", new String[]{employee.getSsn()}, Locale.getDefault()));
//            result.addError(ssnError);
//            return "registration";
//        }
         
        carService.saveCar(car);
 
        model.addAttribute("success", "Car " + car.getCarModel() + " registered successfully");
        return "success";
    }
 
    @RequestMapping(value = { "/update" }, method = RequestMethod.POST)
    public String updateCar(@Valid Car car, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "registration";
        }
 
        carService.updateCar(car);
 
        model.addAttribute("success", "Car " + car.getCarModel() + " updated successfully");
        return "success";
    }
 
    @RequestMapping(value = { "/delete" }, method = RequestMethod.GET)
    public String deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
        return "redirect:/list";
    }
 
}