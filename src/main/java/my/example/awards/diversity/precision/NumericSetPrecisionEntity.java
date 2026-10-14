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

    @Column(precision = 10, scale = 1)
    private BigDecimal bigDecimal;

    @Column(precision = 10, scale = 1)
    private BigInteger bigInteger;

    @Column(precision = 10)
    private Float floatWrap;

    @Column(precision = 10)
    private float floatPrimitive;

    @Column(precision = 10)
    private Double doubleWrap;

    @Column(precision = 10)
    private double doublePrimitive;
}