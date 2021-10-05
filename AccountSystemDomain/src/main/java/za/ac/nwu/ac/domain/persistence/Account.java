package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT", schema = "TIMON")
public class Account implements Serializable {

    private Long memberId;
    private String fName;
    private String lName;
    private Integer miles;

    public Account(Integer miles, String getfName, String getlName) {
        this.miles = miles;
        this.fName = fName;
        this.lName = lName;
    }

    @Id
//    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "TIMON.VIT_RSA_GENERIC_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    @Column(name = "FNAME")
    public String getfName() {
        return fName;
    }

    @Column(name = "LNAME")
    public String getlName() {
        return lName;
    }

    @Column(name = "MILES")
    public Integer getMiles() {
        return miles;
    }

    public Account() {
    }

    public Account(Long memberId, String fName, String lName, Integer miles) {
        this.memberId = memberId;
        this.fName = fName;
        this.lName = lName;
        this.miles = miles;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setMiles(Integer miles) {
        this.miles = miles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(memberId, account.memberId) && Objects.equals(fName, account.fName) && Objects.equals(lName, account.lName) && Objects.equals(miles, account.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, fName, lName, miles);
    }

    @Override
    public String toString() {
        return "Account{" +
                "memberId=" + memberId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", miles=" + miles +
                '}';
    }
}
