package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT")
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
    private LocalDate voucherId;

    @Column(name = "MILES_RECIEVED")
    private LocalDate milesRecieved;

    @Column(name = "MILES")
    private LocalDate miles;

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
}