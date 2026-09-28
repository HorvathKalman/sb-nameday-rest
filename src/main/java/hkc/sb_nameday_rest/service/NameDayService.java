package hkc.sb_nameday_rest.service;

import hkc.sb_nameday_rest.dto.AllNameDayInXMLDTO;
import hkc.sb_nameday_rest.model.NameDay;
import hkc.sb_nameday_rest.repository.NameDayRepository;
import hkc.sb_nameday_rest.xmlWrapper.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
public class NameDayService {

    private NameDayRepository nameDayRepository;

    @Autowired
    public NameDayService(NameDayRepository nameDayRepository) {
        this.nameDayRepository = nameDayRepository;
    }


    public AllNameDayInXMLDTO getAllInStringXML() {
        AllNameDayInXMLDTO responseDto = null;
        List<NameDay> nameDayList = new ArrayList<>();
        
        Iterable<NameDay> iterableNameDaysFromRepo = nameDayRepository.findAll();

        if (iterableNameDaysFromRepo != null) {
            for (NameDay tempVariable : iterableNameDaysFromRepo) {
                nameDayList.add(tempVariable);
            }
        }
        String xmlData = new XMLWriter().writeNameDays(nameDayList);
        responseDto = new AllNameDayInXMLDTO(xmlData);
        return responseDto;
    }
}
