package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "VOUCHER")
public class Vouchers implements Serializable {
    @Id
    @Column(name = "VOUCHER_ID")
    private Long voucherId;

    @Column(name = "VOUCHER_CAT")
    private Long voucherCat;

    @Column(name = "VOUCHER_PRICE")
    private Long voucherPrice;

    @Column(name = "VOUCHER_PARTNER")
    private Long voucherPartner;

    @Column(name = "VOUCHER_Name")
    private Long voucherName;
}