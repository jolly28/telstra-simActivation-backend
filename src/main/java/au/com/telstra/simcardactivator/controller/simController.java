package au.com.telstra.simcardactivator.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import au.com.telstra.simcardactivator.dto.simDTO;
import au.com.telstra.simcardactivator.dto.SimCard;
import au.com.telstra.simcardactivator.dto.ActuationResult;
import au.com.telstra.simcardactivator.services.simService;
import org.springframework.web.client.RestTemplate;

@RestController
public class simController{

    final simService simSvc;
    final RestTemplate restTemplate;

    public simController(simService simSvc, RestTemplate restTemplate){
        this.simSvc=simSvc;
        this.restTemplate=restTemplate;
    }

    @GetMapping(path="/simActivate/{id}")
    public simDTO getSimByICCID(@PathVariable("id") Long id){
        return simSvc.getSimByICCID(id);
    } 

    @PostMapping(path="/simActivate/")
    public simDTO createSimByICCID(@RequestBody simDTO simdto){
        SimCard simcard=new SimCard(simdto.getIccid());
        ActuationResult result = restTemplate.postForObject("http://localhost:8444/actuate", simcard, ActuationResult.class);
        if(result.getSuccess()){
            System.out.println(simcard.getIccid()+" ---- activatation Successful");
            simdto.setActive(true);
        }
        else System.out.println(simcard.getIccid()+" ---- activatation not Successful");

        return simSvc.createSimByICCID(simdto);
    } 
}