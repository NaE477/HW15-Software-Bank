package entities;


import entities.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rent extends BaseEntity<Integer> {
    @ManyToOne
    @JoinColumn(name = "rents")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "rental")
    private Disk disk;

    private LocalDate borrowDate;
}
