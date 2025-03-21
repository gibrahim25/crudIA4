package crudapi4.example.crudapiproject4.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



public class AnimalController {

    @Controller
    @RequestMapping("/animals")
    public class animalController {

        @Autowired
        private AnimalService service;


        @GetMapping("/all")
        public Object getAllAnimals(Model model) {
            model.addAttribute("animalList", service.getAllAnimals());
            model.addAttribute("title", "All Animals");

            return "animal-list";
        }

        @GetMapping("/{animalID}")
        public Object getOneAnimal(@PathVariable int animalID, Model model) {
            model.addAttribute("animal", service.getAnimalById(animalID));
            model.addAttribute("title", animalID);

            return "animal-list";
        }

        @PostMapping("/new")
        public String addAnimal(animal a) {
            service.addAnimal(a);
            return "redirect:/animals/all";
        }

        @GetMapping("/update/{animalID}")
        public String showUpdateForm(@PathVariable int animalID, Model model) {
            model.addAttribute("animal", service.getAnimalById(animalID));

            return "animal-update";
        }

        @PostMapping("/update")
        public String updateAnimal(animal a) {
            service.addAnimal(a);
            return "redirect:/animal/" + a.getAnimalID();
        }

        @GetMapping("/delete/{animalID}")
        public String deleteAnimal(@PathVariable int animalID) {
            service.deleteAnimalByID(animalID);
            return "redirect:/animal/all";
        }

        @GetMapping("/species/{species}")
        public String getAnimalBySpecies(@RequestParam(name = "Species", defaultValue = "Feline")String species, Model model) {
            model.addAttribute("animalList", service.getAnimalBySpecies(species));
            model.addAttribute("title", "Species animals"+species);
            return "animal-list";
        }

        @GetMapping("/search")
        public String searchAnimalsByName(@RequestParam(name = "Name", defaultValue = "Feline")String name, Model model) {
            model.addAttribute("animalList", service.searchAnimalsByName(name));
            model.addAttribute("title", "Animal Name"+name);
            return "animal-list";
        }
    }

}
