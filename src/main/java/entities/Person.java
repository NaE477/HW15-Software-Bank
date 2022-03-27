package entities;

import entities.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
public class Person extends BaseEntity<Integer> {
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "person")
    private List<Rent> rents;
}
