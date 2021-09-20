package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACTIVE_REWARDS")
public class Active_Rewards implements Serializable {
    @Id
    @Column(name = "ACTIVE_REWARDS_ID")
    private Long activerewardId;

    @Id
    @Column(name = "PLAYS")
    private Long plays;

    @Column(name = "DRIVING_PROGRESS")
    private LocalDate drivingProgress;

    @Column(name = "SPENDING_PROGRESS")
    private LocalDate spendingProgress;

    @Column(name = "FITNESS_PROGRESS")
    private LocalDate fitnessProgress;

    private Set<Member> member;

    @OneToMany(targetEntity = Member.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Member> member(){
        return member;
    }

    public void member(Set<Member> member){
        this.member = member;
    }
}