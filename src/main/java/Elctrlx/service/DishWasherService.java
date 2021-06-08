package Elctrlx.service;

import Elctrlx.entity.dishWasher.DishWasher;
import Elctrlx.exceptions.DishWasherNotFoundException;
import Elctrlx.repository.DishWasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DishWasherService {

    private final DishWasherRepository dishWasherRepository;

    @Autowired
    public DishWasherService(DishWasherRepository dishWasherRepository) {
        this.dishWasherRepository = dishWasherRepository;
    }

    public void addDishWasherToDatabase(DishWasher DishWasher) {
        dishWasherRepository.save(DishWasher);
    }

    public DishWasher getDishWasherFromDataBase(int id){
        Optional<DishWasher> requiredDishWasher = dishWasherRepository.findById((long) id);
        if (requiredDishWasher.isEmpty()) {
            throw new DishWasherNotFoundException();
        } else {
            return requiredDishWasher.get();
        }
    }
}