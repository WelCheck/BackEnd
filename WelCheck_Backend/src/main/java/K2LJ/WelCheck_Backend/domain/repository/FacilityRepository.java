package K2LJ.WelCheck_Backend.domain.repository;

import K2LJ.WelCheck_Backend.domain.facility.Facility;

import java.util.List;

public interface FacilityRepository {
    public void save(Facility facility);

    public Facility findOne(Long id);

    public List<Facility> findAll();

    public List<Facility> findbyFcltCd(String fcltcd);
}
