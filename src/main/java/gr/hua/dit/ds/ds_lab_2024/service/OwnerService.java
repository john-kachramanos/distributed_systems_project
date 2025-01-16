package gr.hua.dit.ds.ds_lab_2024.service;

import gr.hua.dit.ds.ds_lab_2024.entities.Owner;
import gr.hua.dit.ds.ds_lab_2024.repositories.OwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class OwnerService {

    //@Autowired
    private OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    @Transactional
    public Owner getOne(@PathVariable String username) {
        return ownerRepository.findByUsername(username);
    }

    //Returns all Admins object
    @Transactional
    public Iterable<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Transactional
    //@ResponseStatus(HttpStatus.CREATED)
    public Owner createOne(String firstName, String lastName, String username, String password, String email, String afm, String passportNumber){
        return new Owner(firstName, lastName, username, password, email, afm, passportNumber);
    }


}

