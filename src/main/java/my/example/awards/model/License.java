package my.example.awards.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "license")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "license_number")
    private String licenseNumber;

    @Embedded
    private LicenseInfo licenseInfo;

    public License(String testLicenseNumber) {
        this.licenseNumber = testLicenseNumber;
    }

    public License() { }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "licenseNumber = " + licenseNumber + ", " +
                "licenseInfo = " + licenseInfo + ")";
    }

}