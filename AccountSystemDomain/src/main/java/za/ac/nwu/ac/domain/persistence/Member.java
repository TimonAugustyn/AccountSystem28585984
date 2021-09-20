package za.ac.nwu.ac.domain.persistence;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.time.LocalDate;
        import java.util.Objects;


@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Column(name = "MEMBER_FNAME")
    private Long memberFname;

    @Column(name = "MEMBER_LNAME")
    private LocalDate memberLname;
}