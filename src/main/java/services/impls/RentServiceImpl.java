package services.impls;

import entities.Rent;
import repositories.interfaces.RentRepository;
import services.impls.base.BaseServiceImpl;
import services.interfaces.RentService;

public class RentServiceImpl extends BaseServiceImpl<Rent, RentRepository> implements RentService {
    public RentServiceImpl(RentRepository repository) {
        super(repository);
    }
}
