package Elctrlx.controller;

import Elctrlx.entity.dishWasher.DishWasher;
import Elctrlx.entity.stove.Stove;
import Elctrlx.service.DishWasherService;
import Elctrlx.service.StoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stove")
public class StoveAPIController {

    private StoveService service;

    @Autowired
    public StoveAPIController(StoveService service) {
        this.service = service;
    }

    @GetMapping(path = "/new")
    public String createNewStove(@RequestParam("model") String model) {
        Stove stove =  new Stove();
        stove.setModel(model);
        service.addStoveToDatabase(stove);
        return stove.toString();
    }

    @GetMapping(path = "/on")
    public String turnOnStove(@RequestParam("id") int id) {
        Stove stove = service.getStoveFromDataBase(id);
        if (stove.getState().equals("Off")) {
            stove.setState("On");
            service.addStoveToDatabase(stove);
        }
        return stove.toString();
    }

    @GetMapping(path = "/off")
    public String turnOffStove(@RequestParam("id") int id) {
        Stove stove = service.getStoveFromDataBase(id);
        if (stove.getState().equals("On")) {
            stove.setState("Off");
            stove.setStoveTemperature(0);
            service.addStoveToDatabase(stove);
        }
        return stove.toString();
    }

    @GetMapping(path = "/temp")
    public String setTemperatureStove(@RequestParam("id") int id, @RequestParam("temp") int temp) {
        Stove stove = service.getStoveFromDataBase(id);
        if (stove.getState().equals("On")) {
            stove.setStoveTemperature(temp);
            service.addStoveToDatabase(stove);
            return stove.toString();
        }
        else {
            return "Turn on the stove to set the temparature!";
        }
    }
}
