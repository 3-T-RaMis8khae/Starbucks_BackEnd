package TRaMis8khae.starbucks.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productUUID;

    @Column(nullable = false, length = 50)
    private String productName;

    private Integer price;

    @Column(nullable = false, length = 50)
    private LocalDate registerDate;

    private Integer limitedCount;

    private Integer stockQuantity;

}