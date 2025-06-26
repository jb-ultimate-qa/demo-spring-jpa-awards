package my.example.awards.model;

import jakarta.persistence.*;

@Entity
@Table(name = "license", uniqueConstraints = {
        @UniqueConstraint(name = "licenseNumUniq", columnNames = {"licenseNum"})
})
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "licenseNum")
    private String licenseNumber;

    @Embedded
    private LicenseInfo licenseInfo;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LicenseInfo getLicenseInfo() {
        return licenseInfo;
    }

    public void setLicenseInfo(LicenseInfo licenseInfo) {
        this.licenseInfo = licenseInfo;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "licenseNumber = " + licenseNumber + ", " +
                "licenseInfo = " + licenseInfo + ")";
    }

}