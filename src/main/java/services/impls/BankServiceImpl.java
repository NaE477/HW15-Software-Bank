package services.impls;

import controllers.Bank;
import repositories.interfaces.BankRepository;
import services.impls.base.BaseServiceImpl;
import services.interfaces.BankService;

public class BankServiceImpl extends BaseServiceImpl<Bank, BankRepository> implements BankService {
    public BankServiceImpl(BankRepository repository) {
        super(repository);
    }
}
