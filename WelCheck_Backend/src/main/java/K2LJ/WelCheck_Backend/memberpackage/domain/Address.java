package K2LJ.WelCheck_Backend.memberpackage.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String zipCode; //우편번호

    private String roadName;  //도로명주소

    private String streetNumber;  //지번주소

    private String detail;  //상세주소

    private String reference;   //참고사항

    private String phoneNumber; //연락처
}
