package K2LJ.WelCheck_Backend.domain.service;

import K2LJ.WelCheck_Backend.domain.facility.Facility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class FacilityServiceTest {
    @Autowired
    private FacilityService facilityService;
    @Test
    void registrationFacility() {
        //given
        Facility facility = new Facility();
        //when
        Long findId = facilityService.registrationFacility(facility);
        //then
        assertThat(facility).isEqualTo(facilityService.findOne(findId));
    }

    @Test
    void validateDuplicateFacility() {
        //given
        Facility facility1 = new Facility();
        facility1.setFcltCd("시설");
        Facility facility2 = new Facility();
        facility2.setFcltCd("시설");

        //when
        facilityService.registrationFacility(facility1);

        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            facilityService.registrationFacility(facility2);
        });
    }

    @Test
    void findFacilitys() {
        //given
        Facility facility1 = new Facility();
        Facility facility2 = new Facility();
        facilityService.registrationFacility(facility1);
        facilityService.registrationFacility(facility2);

        //when
        List<Facility> facilitys = facilityService.findFacilitys();

        assertThat(facilitys).size().isEqualTo(2);
        /*assertThat(facilitys).contains(facility1);
        assertThat(facilitys).contains(facility2);*/
    }
}