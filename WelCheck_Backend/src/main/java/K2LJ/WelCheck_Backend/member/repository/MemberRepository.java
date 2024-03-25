package K2LJ.WelCheck_Backend.member.repository;

import K2LJ.WelCheck_Backend.member.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    public void save(Member member);

    public Member findOne(Long id);

    public List<Member> findAll();
}
