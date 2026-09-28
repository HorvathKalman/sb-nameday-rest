package hkc.sb_nameday_rest.controller;

import hkc.sb_nameday_rest.dto.AllNameDayInXMLDTO;
import hkc.sb_nameday_rest.service.NameDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private NameDayService nameDayService;

    @Autowired
    public Controller(NameDayService nameDayService) {
        this.nameDayService = nameDayService;
    }


    @GetMapping ("/getAll")
    public ResponseEntity<AllNameDayInXMLDTO> getAll() {

        AllNameDayInXMLDTO allNameDayInXMLDTO = nameDayService.getAllInStringXML();
        return ResponseEntity.ok(allNameDayInXMLDTO);
    }


}
