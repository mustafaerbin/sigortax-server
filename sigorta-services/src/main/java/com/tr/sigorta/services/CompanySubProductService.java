package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.sigorta.domain.CompanySubProduct;
import com.tr.sigorta.repository.CompanySubProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@Service
public class CompanySubProductService extends JpaService<CompanySubProduct, Long> {

    @Autowired
    public CompanySubProductService(CompanySubProductRepository repository) {
        super(repository);
    }
}
