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

    public Active_Rewards(Long activerewardId, Long plays, Long drivingProgress, Long spendingProgress, Long fitnessProgress, Set<Member> member) {
        this.activerewardId = activerewardId;
        this.plays = plays;
        this.drivingProgress = drivingProgress;
        this.spendingProgress = spendingProgress;
        this.fitnessProgress = fitnessProgress;
        this.member = member;
    }

    public Active_Rewards() {
    }

    public Long getActiverewardId() {
        return activerewardId;
    }

    public void setActiverewardId(Long activerewardId) {
        this.activerewardId = activerewardId;
    }

    public Long getPlays() {
        return plays;
    }

    public void setPlays(Long plays) {
        this.plays = plays;
    }

    public Long getDrivingProgress() {
        return drivingProgress;
    }

    public void setDrivingProgress(Long drivingProgress) {
        this.drivingProgress = drivingProgress;
    }

    public Long getSpendingProgress() {
        return spendingProgress;
    }

    public void setSpendingProgress(Long spendingProgress) {
        this.spendingProgress = spendingProgress;
    }

    public Long getFitnessProgress() {
        return fitnessProgress;
    }

    public void setFitnessProgress(Long fitnessProgress) {
        this.fitnessProgress = fitnessProgress;
    }

    public Set<Member> getMember() {
        return member;
    }

    public void setMember(Set<Member> member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Active_Rewards that = (Active_Rewards) o;
        return Objects.equals(activerewardId, that.activerewardId) && Objects.equals(plays, that.plays) && Objects.equals(drivingProgress, that.drivingProgress) && Objects.equals(spendingProgress, that.spendingProgress) && Objects.equals(fitnessProgress, that.fitnessProgress) && Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(activerewardId, plays, drivingProgress, spendingProgress, fitnessProgress, member);
    }

    @Override
    public String toString() {
        return "Active_Rewards{" +
                "activerewardId=" + activerewardId +
                ", plays=" + plays +
                ", drivingProgress=" + drivingProgress +
                ", spendingProgress=" + spendingProgress +
                ", fitnessProgress=" + fitnessProgress +
                ", member=" + member +
                '}';
    }
}