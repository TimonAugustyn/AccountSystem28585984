package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "VOUCHER", schema = "TIMON")
public class Vouchers implements Serializable {
    @Id
    @Column(name = "VOUCHER_ID")
    private Long voucherId;

    @Column(name = "VOUCHER_CAT")
    private String voucherCat;

    @Column(name = "VOUCHER_PRICE")
    private Long voucherPrice;

    @Column(name = "VOUCHER_PARTNER")
    private String voucherPartner;

    @Column(name = "VOUCHER_Name")
    private String voucherName;

    public Vouchers(Long voucherId, String voucherCat, Long voucherPrice, String voucherPartner, String voucherName) {
        this.voucherId = voucherId;
        this.voucherCat = voucherCat;
        this.voucherPrice = voucherPrice;
        this.voucherPartner = voucherPartner;
        this.voucherName = voucherName;
    }

    public Vouchers() {
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }

    public String getVoucherCat() {
        return voucherCat;
    }

    public void setVoucherCat(String voucherCat) {
        this.voucherCat = voucherCat;
    }

    public Long getVoucherPrice() {
        return voucherPrice;
    }

    public void setVoucherPrice(Long voucherPrice) {
        this.voucherPrice = voucherPrice;
    }

    public String getVoucherPartner() {
        return voucherPartner;
    }

    public void setVoucherPartner(String voucherPartner) {
        this.voucherPartner = voucherPartner;
    }

    public String getVoucherName() {
        return voucherName;
    }

    public void setVoucherName(String voucherName) {
        this.voucherName = voucherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vouchers vouchers = (Vouchers) o;
        return Objects.equals(voucherId, vouchers.voucherId) && Objects.equals(voucherCat, vouchers.voucherCat) && Objects.equals(voucherPrice, vouchers.voucherPrice) && Objects.equals(voucherPartner, vouchers.voucherPartner) && Objects.equals(voucherName, vouchers.voucherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voucherId, voucherCat, voucherPrice, voucherPartner, voucherName);
    }

    @Override
    public String toString() {
        return "Vouchers{" +
                "voucherId=" + voucherId +
                ", voucherCat='" + voucherCat + '\'' +
                ", voucherPrice=" + voucherPrice +
                ", voucherPartner='" + voucherPartner + '\'' +
                ", voucherName='" + voucherName + '\'' +
                '}';
    }
}