package my.example.awards.diversity.inheritance;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inh_child")
@AttributeOverride(name = "parentAttribute", column = @Column(nullable = false))
public class Child extends Parent {
    @Column(name = "child_attribute")
    private Integer childAttribute;

    public Integer getChildAttribute() {
        return childAttribute;
    }

    public void setChildAttribute(Integer childAttribute) {
        this.childAttribute = childAttribute;
    }
}