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
public class Disk extends BaseEntity<Integer> {
    @Column(unique = true)
    private String diskName;

    private Boolean isBorrowed;

    @OneToMany(mappedBy = "disk")
    private List<Rent> rental;
}
