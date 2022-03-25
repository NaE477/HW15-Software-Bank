package entities.base;

import java.io.Serializable;

public class BaseEntity<ID extends Serializable> {
    private ID id;
}
