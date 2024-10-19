package com.Initializer.ServiceImplementations;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Initializer.Model.OwnEnterprises;
import com.Initializer.Repository.OwnEnterprisesRepository;
import com.Initializer.Service.OwnEnterprisesService;

@Service
public class OwnEnterprisesServiceImplementation implements OwnEnterprisesService {

    @Autowired
    private OwnEnterprisesRepository repository;

    @Override
    public List<OwnEnterprises> getAllOwnEnterprises() {
        return repository.findAll();
    }

    @Override
    public void saveOwnEnterprise(OwnEnterprises ownEnterprise) {
        repository.save(ownEnterprise);
    }
}
