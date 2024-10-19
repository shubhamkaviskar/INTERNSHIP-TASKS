package com.Initializer.Service;

import java.util.List;
import com.Initializer.Model.OwnEnterprises;

public interface OwnEnterprisesService {

    List<OwnEnterprises> getAllOwnEnterprises();
    void saveOwnEnterprise(OwnEnterprises ownEnterprise);
}
