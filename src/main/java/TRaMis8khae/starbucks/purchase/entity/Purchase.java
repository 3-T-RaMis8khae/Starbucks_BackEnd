package TRaMis8khae.starbucks.purchase.entity;

import TRaMis8khae.starbucks.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Where(clause = "is_deleted = false")
@SQLDelete(sql = "UPDATE purchase SET is_deleted = true WHERE id = ?")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberUUID;

    @Column(nullable = false, length = 50)
    private String serialNumber;

    private Double deliveryPrice;

    private Double totalPrice;

    private String cardInfo;

    @Column(nullable = false, length = 50)
    private String memberName;

    @Column(nullable = false, length = 50)
    private String memberPhone;

    @Column(length = 50)
    private String addressDetail;

    @Column(length = 500)
    private String deliveryMemo;

//    @Column(nullable = false, length = 50)
    private String recipient;

    private String phone1;

    private String phone2;

    private Boolean isDeleted = false;

    @Builder
    public Purchase(String memberUUID, String serialNumber, Double deliveryPrice, Double totalPrice, String cardInfo,
                    String memberName, String memberPhone, String addressDetail, String deliveryMemo,
                    String recipient, String phone1, String phone2) {
        this.memberUUID = memberUUID;
        this.serialNumber = serialNumber;
        this.deliveryPrice = deliveryPrice;
        this.totalPrice = totalPrice;
        this.cardInfo = cardInfo;
        this.memberName = memberName;
        this.memberPhone = memberPhone;
        this.addressDetail = addressDetail;
        this.deliveryMemo = deliveryMemo;
        this.recipient = recipient;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

}