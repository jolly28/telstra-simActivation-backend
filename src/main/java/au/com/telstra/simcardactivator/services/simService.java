package au.com.telstra.simcardactivator.services;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import au.com.telstra.simcardactivator.repositories.simRepository;
import au.com.telstra.simcardactivator.entities.simEntity;
import au.com.telstra.simcardactivator.dto.simDTO;
import org.springframework.stereotype.Service;

@Service
public class simService {

    final simRepository sRepo;



    // Default constructor
    public simService(simRepository sRepo) {
        this.sRepo=sRepo;
    }

    // Getters and Setters
    public simDTO getSimByICCID(String iccid){
        simEntity simEnt=sRepo.getById(iccid);
        return new simDTO(simEnt.getIccid(),simEnt.getCustomerEmail());
    }

    public simDTO createSimByICCID(simDTO simdto){
        simEntity simEnt=new simEntity(simdto.getIccid(),simdto.getCustomerEmail());
        //disabling save to repostitory
        //simEntity simEntSaved=sRepo.save(simEnt);
        //return new simDTO(simEntSaved.getIccid(),simEntSaved.getCustomerEmail());
        return new simDTO(simEnt.getIccid(),simEnt.getCustomerEmail());
    }
}