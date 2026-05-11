package my.example.awards.diversity.precision;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "precision_numeric_set")
public class NumericSetPrecisionEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private BigDecimal bigDecimal;

    @Column
    private BigInteger bigInteger;

    @Column
    private Float floatWrap;

    @Column
    private float floatPrimitive;

    @Column
    private Double doubleWrap;

    @Column
    private double doublePrimitive;
}