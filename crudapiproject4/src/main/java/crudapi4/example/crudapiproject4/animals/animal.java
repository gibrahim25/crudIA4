package crudapi4.example.crudapiproject4.animals;


import jakarta.persistence.*;

@jakarta.persistence.Entity
@Table(name="animals")
public class animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalID;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private String species;

    public animal(int animalID, String name, String description, String species) {
        this.animalID = animalID;
        this.name = name;
        this.description = description;
        this.species = species;
    }
    public animal(String name, String description, String species) {
        this.name = name;
        this.description = description;
        this.species = species;
    }

    public animal () {

    }

    public int getAnimalID () {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
