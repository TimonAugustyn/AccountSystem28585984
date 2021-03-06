package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Account;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Account", description = "A DTO for ACCOUNT")
public class AccountDto implements Serializable {
    private Long memberId;
    private String fName;
    private String lName;
    private Integer miles;

    public AccountDto() {
    }

    public AccountDto(Long memberId, String fName, String lName, Integer miles) {
        this.memberId = memberId;
        this.fName = fName;
        this.lName = lName;
        this.miles = miles;
    }

    public AccountDto(Account account){
        this.setMemberId(account.getMemberId());
        this.setfName(account.getfName());
        this.setlName(account.getlName());
        this.setMiles(account.getMiles());
    }

    public Long getMemberId() {return memberId;}
    public void setMemberId(Long memberId) {this.memberId = memberId;}

    public Integer getMiles() {return miles;}
    public void setMiles(Integer miles) {this.miles = miles;}

    public String getfName() {
        return fName;
    }
    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }
    public void setlName(String lName) {
        this.lName = lName;
    }

    @JsonIgnore
    public Account getAccount(){
        return new Account(getMemberId(),getfName(), getlName(), getMiles());
    }
    @JsonIgnore
    public Account getMilesByMemberName(){
        return new Account(getMemberId());
    }
    @JsonIgnore
//    public Integer add(){
//        return new Integer(getMiles(), getfName(), getlName());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(memberId, that.memberId) && Objects.equals(fName, that.fName) && Objects.equals(lName, that.lName) && Objects.equals(miles, that.miles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, fName, lName, miles);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "memberId=" + memberId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", miles=" + miles +
                '}';
    }
}
