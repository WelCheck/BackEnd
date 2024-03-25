package K2LJ.WelCheck_Backend.member.domain.member;

import jakarta.persistence.Entity;

@Entity
public class DisabledMember extends Member{
    //변경필요
    private String certified;   //장애인 등록증(또는 인증여부)

    //변경필요
    private String disableCategory; //장애 분류

}
