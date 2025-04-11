package crudapi4.example.crudapiproject4.animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepo extends JpaRepository<animal, Integer> {

    List<animal> findBySpecies(String species);
    List<animal> findByName(String name);
}
