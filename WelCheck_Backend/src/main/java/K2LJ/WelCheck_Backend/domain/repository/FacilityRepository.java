package K2LJ.WelCheck_Backend.domain.repository;

import K2LJ.WelCheck_Backend.domain.facility.Facility;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class FacilityRepository {

    private final EntityManager em;

    public void save(Facility facility){
        em.persist(facility);
    }

    public Facility findOne(Long id){
        return em.find(Facility.class,id);
    }

    public List<Facility> findAll(){
        return em.createQuery("select f from Facility f", Facility.class).getResultList();
    }

    public List<Facility> findbyFcltCd(String fcltcd){
        return em.createQuery("select f from Facility f where f.fcltCd = : fcltCd", Facility.class)
                .setParameter("fcltCd", fcltcd)
                .getResultList();
    }
}
