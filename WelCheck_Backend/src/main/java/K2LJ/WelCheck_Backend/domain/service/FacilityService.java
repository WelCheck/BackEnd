package K2LJ.WelCheck_Backend.domain.service;

import K2LJ.WelCheck_Backend.domain.facility.Facility;
import K2LJ.WelCheck_Backend.domain.repository.FacilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FacilityService {

    private final FacilityRepository facilityRepostiory;

    @Transactional(readOnly = false)
    public Long registrationFacility(Facility facility) {
        validateDuplicateFacility(facility);
        facilityRepostiory.save(facility);
        return facility.getId();
    }

    public void validateDuplicateFacility(Facility facility) {
        List<Facility> facilities = facilityRepostiory.findbyFcltCd(facility.getFcltCd());
        if (!facilities.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 시설입니다. ");
        }
    }

    public List<Facility> findFacilitys() {
        return facilityRepostiory.findAll();
    }

    public Facility findOne(Long facilityId) {
        return facilityRepostiory.findOne(facilityId);
    }
}
