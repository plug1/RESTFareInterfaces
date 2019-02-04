package MK.FareCompetitorsInterfaces.rest;

import MK.FareCompetitorsInterfaces.dto.CompetitorsData;
import MK.FareCompetitorsInterfaces.dto.Statistc;
import MK.FareCompetitorsInterfaces.memoDB.WrappedCompetitorsData;

import MK.FareCompetitorsInterfaces.service.StatResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/compData")
public class Controller {

    WrappedCompetitorsData wrappedCompetitorsData;

    @PostMapping(value = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> saveCompetitorsData(@RequestBody  List<CompetitorsData> data){
        wrappedCompetitorsData = new WrappedCompetitorsData();
        wrappedCompetitorsData.setCompetitorsDataList(data);



        return new ResponseEntity<>("Data saved",HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Statistc>> getStats() {

        if (wrappedCompetitorsData != null) {
            List<Statistc> stats = StatResolver.getStat(wrappedCompetitorsData);
            return new ResponseEntity<List<Statistc>>(stats, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Statistc>>(HttpStatus.NO_CONTENT);
        }

    }


}
