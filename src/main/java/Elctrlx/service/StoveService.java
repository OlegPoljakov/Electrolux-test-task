package Elctrlx.service;

import Elctrlx.entity.stove.Stove;
import Elctrlx.exceptions.StoveNotFoundException;
import Elctrlx.repository.StoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoveService {

    private final StoveRepository stoveRepository;

    @Autowired
    public StoveService(StoveRepository stoveRepository) {
        this.stoveRepository = stoveRepository;
    }

    public void addStoveToDatabase(Stove Stove) {
        stoveRepository.save(Stove);
    }

    public Stove getStoveFromDataBase(int id){
        Optional<Stove> requiredStove = stoveRepository.findById((long) id);
        if (requiredStove.isEmpty()) {
            throw new StoveNotFoundException();
        } else {
            return requiredStove.get();
        }
    }

}
