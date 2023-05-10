package hca.aggreate.api.controller;
import hca.aggreate.api.bean.Resident;
import hca.aggreate.api.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ResidentController {

    @Autowired
    ResidentService residentService;

    @GetMapping("/residents")
    public List<Resident> getAllResidents() {
        try{
            return residentService.getAllResidentData();
        } catch(HttpClientErrorException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request", e);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", e);
        }
    }

    @GetMapping("/ping")
    public String ping(){
        return "api running";
    }

}
