package K2LJ.WelCheck_Backend.memberpackage.domain.member;

import K2LJ.WelCheck_Backend.memberpackage.domain.Address;
import K2LJ.WelCheck_Backend.memberpackage.domain.Sex;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MTYPE")
@Getter @Setter//나중에 Setter제거
public class Member {
    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;

    private String userId;

    private String password;

    private String name;

    private String username;

    @Embedded
    private Address address;  //변경필요 - api사용

    @Enumerated(EnumType.STRING)
    private Sex sex;

    private String email;
}
