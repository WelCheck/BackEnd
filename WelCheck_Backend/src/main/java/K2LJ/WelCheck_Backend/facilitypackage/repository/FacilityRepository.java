package K2LJ.WelCheck_Backend.facilitypackage.repository;


import K2LJ.WelCheck_Backend.facilitypackage.domain.Facility;

import java.util.List;

public interface FacilityRepository {
    public void save(Facility facility);

    public Facility findOne(Long id);

    public List<Facility> findAll();

    public List<Facility> findbyFcltCd(String fcltcd);
}
