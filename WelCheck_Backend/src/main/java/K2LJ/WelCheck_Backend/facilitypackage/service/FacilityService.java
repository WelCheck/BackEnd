package K2LJ.WelCheck_Backend.facilitypackage.service;

import K2LJ.WelCheck_Backend.facilitypackage.domain.Facility;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FacilityService {
    @Transactional(readOnly = false)
    public Long registrationFacility(Facility facility);

    public void validateDuplicateFacility(Facility facility);

    public List<Facility> findAll();

    public Facility findOne(Long facilityId);

    void update(Long id, String fcltCd);
}
