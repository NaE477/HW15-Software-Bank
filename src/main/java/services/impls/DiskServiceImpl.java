package services.impls;

import entities.Disk;
import repositories.interfaces.DiskRepository;
import services.impls.base.BaseServiceImpl;
import services.interfaces.DiskService;

public class DiskServiceImpl extends BaseServiceImpl<Disk, DiskRepository> implements DiskService {
    public DiskServiceImpl(DiskRepository repository) {
        super(repository);
    }

    @Override
    public Disk findByDiskName(String diskName) {
        return repository.readByDiskName(diskName);
    }
}
