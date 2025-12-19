package my.example.awards.diversity.inheritance;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Parent extends BaseEntity {
    @Column(name = "parent_attribute")
    private String parentAttribute;

    public String getParentAttribute() {
        return parentAttribute;
    }

    public void setParentAttribute(String parentAttribute) {
        this.parentAttribute = parentAttribute;
    }
}