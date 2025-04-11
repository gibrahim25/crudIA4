package crudapi4.example.crudapiproject4.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnimalService {

    @Autowired
    private AnimalRepo animalRepo;


    public List<animal> getAllAnimals(){return animalRepo.findAll();}

    public animal getAnimalById(int animalID){
        return animalRepo.findById(animalID).orElse(null);
    }

    public animal addAnimal(animal a) {
        return animalRepo.save(a);
    }

    public void updateanimal(int animalID, animal Animal) {
        animal exisiting = getAnimalById(animalID);
        exisiting.setName(Animal.getName());
        exisiting.setDescription(Animal.getDescription());
        exisiting.setSpecies(Animal.getSpecies());

        animalRepo.save(exisiting);
    }

    public List<animal> getAnimalBySpecies(String species) {
        return animalRepo.findBySpecies(species);
    }

    public void deleteAnimalByID(int animalID) {
        animalRepo.deleteById(animalID);
    }

    public List<animal> searchAnimalsByName(String name) {
        return animalRepo.findByName(name);
    }




}


