package Elctrlx.controller;

import Elctrlx.entity.dishWasher.DishWasher;
import Elctrlx.service.DishWasherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishwasher")
public class DishWasherAPIController {

    private DishWasherService service;

    @Autowired
    public DishWasherAPIController(DishWasherService service) {
        this.service = service;
    }

    @GetMapping(path = "/new")
    public String createNewDishwasher(@RequestParam("model") String model) {
        DishWasher dishWasher =  new DishWasher();
        dishWasher.setModel(model);
        service.addDishWasherToDatabase(dishWasher);
        return dishWasher.toString();
    }

    @GetMapping(path = "/on")
    @ResponseBody
    public String turnOnDishwasher(@RequestParam("id") int id) {
        DishWasher dishWasher = service.getDishWasherFromDataBase(id);
        if (dishWasher.getState().equals("Off")) {
            dishWasher.setState("On");
            service.addDishWasherToDatabase(dishWasher);
        }
        return dishWasher.toString();
    }

    @GetMapping(path = "/off")
    public String turnOffDishwasher(@RequestParam("id") int id) {
        DishWasher dishWasher = service.getDishWasherFromDataBase(id);
        if (dishWasher.getState().equals("On")) {
            dishWasher.setState("Off");
            dishWasher.setWaterTemperature(0);
            service.addDishWasherToDatabase(dishWasher);
        }
        return dishWasher.toString();
    }

    @GetMapping(path = "/temp")
    public String setTemperatureDishwasher(@RequestParam("id") int id, @RequestParam("temp") int temp) {
        DishWasher dishWasher = service.getDishWasherFromDataBase(id);
        if (dishWasher.getState().equals("On")) {
            dishWasher.setWaterTemperature(temp);
            service.addDishWasherToDatabase(dishWasher);
            return dishWasher.toString();
        }
        else {
            return "Turn on the machine to set the temparature!";
        }
    }

}
