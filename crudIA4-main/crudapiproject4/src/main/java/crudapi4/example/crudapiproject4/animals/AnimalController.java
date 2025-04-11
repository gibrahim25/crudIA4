package crudapi4.example.crudapiproject4.animals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/animals")
public class AnimalController {


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

            return "animal-details";
        }

        @PostMapping("/new")
        public String addAnimal(animal a) {
            service.addAnimal(a);
            return "redirect:/animals/all";
        }


        @PostMapping("/update/{animalID}")
        public Object updateAnimal(@PathVariable int animalID, animal Animal ) {
            service.updateanimal(animalID, Animal);
            return "redirect:/animal/" + animalID;
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

        @GetMapping("/createForm")
        public String showCreateForm(Model model) {
            animal newAnimal = new animal();
            model.addAttribute("animal", newAnimal);
            model.addAttribute("title", "Create New Animal");
            return "animal-create";
        }

        @GetMapping("/update/{animalID}")
        public String showUpdateForm(@PathVariable int animalID, Model model) {
            model.addAttribute("animal", service.getAnimalById(animalID));
            model.addAttribute("title", "Update Animal");
            return "animal-update";
        }
        @GetMapping("/delete/{animalID}")
        public Object deleteAnimalByID(@PathVariable int animalID) {
            service.deleteAnimalByID(animalID);

            return "redirect:/animals/all";
        }
    }


