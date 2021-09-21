package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACTIVE_REWARDS", schema = "TIMON")
public class Active_Rewards implements Serializable {
    @Id
    @Column(name = "ACTIVE_REWARDS_ID")
    private Long activerewardId;

    @Id
    @Column(name = "PLAYS")
    private Long plays;

    @Column(name = "DRIVING_PROGRESS")
    private Long drivingProgress;

    @Column(name = "SPENDING_PROGRESS")
    private Long spendingProgress;

    @Column(name = "FITNESS_PROGRESS")
    private Long fitnessProgress;

    private Set<Member> member;

    @OneToMany(targetEntity = Member.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Member> member(){
        return member;
    }

    public void member(Set<Member> member){
        this.member = member;
    }
}