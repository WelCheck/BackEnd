package K2LJ.WelCheck_Backend.api;

import K2LJ.WelCheck_Backend.domain.facility.Facility;
import K2LJ.WelCheck_Backend.domain.service.FacilityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Transactional
public class FacilityApiController {
    private final FacilityService facilityService;

    @PostMapping("/facilitys")
    public CreateFacilityResponse createFacility(@RequestBody @Valid CreateFacilityRequest request) {
        Facility facility = new Facility();
        facility.setFcltCd(request.getFcltCd());

        Long id = facilityService.registrationFacility(facility);
        return new CreateFacilityResponse(id);
    }

    @PutMapping("/facilitys/{id}")
    public UpdateFacilityResponse updateFacility(@PathVariable("id") Long id, @RequestBody @Valid UpdateFacilitysRequest request) {
        facilityService.update(id, request.getFcltCd());
        Facility findFacility = facilityService.findOne(id);
        return new UpdateFacilityResponse(findFacility.getId(), findFacility.getFcltCd());
    }
    @Data
    static class CreateFacilityRequest {
        String fcltCd;
    }
    @Data
    @AllArgsConstructor
    static class CreateFacilityResponse {
        Long id;
    }

    @Data
    static class UpdateFacilitysRequest {
        String fcltCd;
    }
    @Data
    @AllArgsConstructor
    static class UpdateFacilityResponse {
        Long id;
        String fcltCd;
    }
}
