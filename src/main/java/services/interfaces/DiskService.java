package services.interfaces;

import entities.Disk;
import services.interfaces.base.BaseService;

public interface DiskService extends BaseService<Disk> {
    Disk findByDiskName(String diskName);
}
