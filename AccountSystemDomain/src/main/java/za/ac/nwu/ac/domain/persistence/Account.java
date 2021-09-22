package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT", schema = "TIMON")
public class Account implements Serializable {
    @Id
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @Id
    @Column(name = "MEMBER_ID")
    private Long memberId;

    @Id
    @Column(name = "PLAYS")
    private Long plays;

    @Column(name = "VOUCHER_ID")
    private Long voucherId;

    @Column(name = "MILES_RECIEVED")
    private Long milesRecieved;

    @Column(name = "MILES")
    private Long miles;

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

    private Set<Gameboard> gameboard;

    @OneToMany(targetEntity = Gameboard.class, fetch = FetchType.LAZY, mappedBy = "milesRecieved", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Gameboard> gameboard(){
        return gameboard;
    }

    public void gameboard(Set<Gameboard> gameboard){
        this.gameboard = gameboard;
    }

    private Set<Vouchers> vouchers;

    @OneToMany(targetEntity = Vouchers.class, fetch = FetchType.LAZY, mappedBy = "voucherId", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public  Set<Vouchers> vouchers(){
        return vouchers;
    }

    public void vouchers(Set<Vouchers> vouchers){
        this.vouchers = vouchers;
    }

    public Account(Long accountId, Long memberId, Long plays, Long voucherId, Long milesRecieved, Long miles, Set<Member> member, Set<Active_Rewards> activeRewards, Set<Gameboard> gameboard, Set<Vouchers> vouchers) {
        this.accountId = accountId;
        this.memberId = memberId;
        this.plays = plays;
        this.voucherId = voucherId;
        this.milesRecieved = milesRecieved;
        this.miles = miles;
        this.member = member;
        this.activeRewards = activeRewards;
        this.gameboard = gameboard;
        this.vouchers = vouchers;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getPlays() {
        return plays;
    }

    public void setPlays(Long plays) {
        this.plays = plays;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public Long getMilesRecieved() {
        return milesRecieved;
    }

    public void setMilesRecieved(Long milesRecieved) {
        this.milesRecieved = milesRecieved;
    }

    public Long getMiles() {
        return miles;
    }

    public void setMiles(Long miles) {
        this.miles = miles;
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

    public Set<Gameboard> getGameboard() {
        return gameboard;
    }

    public void setGameboard(Set<Gameboard> gameboard) {
        this.gameboard = gameboard;
    }

    public Set<Vouchers> getVouchers() {
        return vouchers;
    }

    public void setVouchers(Set<Vouchers> vouchers) {
        this.vouchers = vouchers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(memberId, account.memberId) && Objects.equals(plays, account.plays) && Objects.equals(voucherId, account.voucherId) && Objects.equals(milesRecieved, account.milesRecieved) && Objects.equals(miles, account.miles) && Objects.equals(member, account.member) && Objects.equals(activeRewards, account.activeRewards) && Objects.equals(gameboard, account.gameboard) && Objects.equals(vouchers, account.vouchers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, memberId, plays, voucherId, milesRecieved, miles, member, activeRewards, gameboard, vouchers);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", memberId=" + memberId +
                ", plays=" + plays +
                ", voucherId=" + voucherId +
                ", milesRecieved=" + milesRecieved +
                ", miles=" + miles +
                ", member=" + member +
                ", activeRewards=" + activeRewards +
                ", gameboard=" + gameboard +
                ", vouchers=" + vouchers +
                '}';
    }
}