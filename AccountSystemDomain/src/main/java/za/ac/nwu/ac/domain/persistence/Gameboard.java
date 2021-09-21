package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "GAMEBOARD", schema = "TIMON")
public class Gameboard implements Serializable {
    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Id
    @Column(name = "MILES_RECIEVED")
    private Long milesRecieved;

    @Column(name = "PLAYS")
    private Long plays;

    @Column(name = "TILE_AMOUNTS")
    private Long tileAmounts;

    private Set<Member> member;

    @OneToMany(targetEntity = Member.class, fetch = FetchType.LAZY, mappedBy = "memberId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Member> member(){
        return member;
    }

    public void member(Set<Member> member){
        this.member = member;
    }

    private Set<Active_Rewards> activeRewards;

    @OneToMany(targetEntity = Active_Rewards.class, fetch = FetchType.LAZY, mappedBy = "plays", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Active_Rewards> activeRewards(){
        return activeRewards;
    }

    public void activeRewards(Set<Active_Rewards> activeRewards){
        this.activeRewards = activeRewards;
    }
}