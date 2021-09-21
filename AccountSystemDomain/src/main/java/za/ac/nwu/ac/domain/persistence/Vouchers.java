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
}