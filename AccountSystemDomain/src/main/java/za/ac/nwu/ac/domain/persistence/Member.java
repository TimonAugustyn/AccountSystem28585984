package za.ac.nwu.ac.domain.persistence;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.time.LocalDate;
        import java.util.Objects;


@Entity
@Table(name = "MEMBER", schema = "TIMON")
public class Member implements Serializable {
    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_FNAME")
    private String memberFname;

    @Column(name = "MEMBER_LNAME")
    private String memberLname;

    public Member(Long memberId, String memberFname, String memberLname) {
        this.memberId = memberId;
        this.memberFname = memberFname;
        this.memberLname = memberLname;
    }

    public Member() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberFname() {
        return memberFname;
    }

    public void setMemberFname(String memberFname) {
        this.memberFname = memberFname;
    }

    public String getMemberLname() {
        return memberLname;
    }

    public void setMemberLname(String memberLname) {
        this.memberLname = memberLname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) && Objects.equals(memberFname, member.memberFname) && Objects.equals(memberLname, member.memberLname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberFname, memberLname);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberFname='" + memberFname + '\'' +
                ", memberLname='" + memberLname + '\'' +
                '}';
    }
}