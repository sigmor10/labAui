package lab2.main.smartPhone.event.api;

import java.util.UUID;

public interface BrandEventRepo {
    void create(UUID id);

    void delete(UUID id);
}
