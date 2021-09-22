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

    public Gameboard(Long memberId, Long milesRecieved, Long plays, Long tileAmounts, Set<Member> member, Set<Active_Rewards> activeRewards) {
        this.memberId = memberId;
        this.milesRecieved = milesRecieved;
        this.plays = plays;
        this.tileAmounts = tileAmounts;
        this.member = member;
        this.activeRewards = activeRewards;
    }

    public Gameboard() {
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMilesRecieved() {
        return milesRecieved;
    }

    public void setMilesRecieved(Long milesRecieved) {
        this.milesRecieved = milesRecieved;
    }

    public Long getPlays() {
        return plays;
    }

    public void setPlays(Long plays) {
        this.plays = plays;
    }

    public Long getTileAmounts() {
        return tileAmounts;
    }

    public void setTileAmounts(Long tileAmounts) {
        this.tileAmounts = tileAmounts;
    }

    public Set<Member> getMember() {
        return member;
    }

    public void setMember(Set<Member> member) {
        this.member = member;
    }

    public Set<Active_Rewards> getActiveRewards() {
        return activeRewards;
    }

    public void setActiveRewards(Set<Active_Rewards> activeRewards) {
        this.activeRewards = activeRewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gameboard gameboard = (Gameboard) o;
        return Objects.equals(memberId, gameboard.memberId) && Objects.equals(milesRecieved, gameboard.milesRecieved) && Objects.equals(plays, gameboard.plays) && Objects.equals(tileAmounts, gameboard.tileAmounts) && Objects.equals(member, gameboard.member) && Objects.equals(activeRewards, gameboard.activeRewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, milesRecieved, plays, tileAmounts, member, activeRewards);
    }

    @Override
    public String toString() {
        return "Gameboard{" +
                "memberId=" + memberId +
                ", milesRecieved=" + milesRecieved +
                ", plays=" + plays +
                ", tileAmounts=" + tileAmounts +
                ", member=" + member +
                ", activeRewards=" + activeRewards +
                '}';
    }
}