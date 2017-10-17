package com.tr.sigorta.services;

import com.tr.nebula.persistence.jpa.services.JpaService;
import com.tr.sigorta.dao.CompanyProductDao;
import com.tr.sigorta.domain.CompanyProduct;
import com.tr.sigorta.repository.CompanyProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@Service
public class CompanyProductService extends JpaService<CompanyProduct, Long> {

    @Autowired
    public CompanyProductService(CompanyProductRepository repository) {
        super(repository);
    }
}
