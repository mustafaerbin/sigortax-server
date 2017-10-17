package com.tr.sigorta.repository;

import com.tr.sigorta.domain.CompanyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Erbin on 16/10/2017.
 */
@Repository
public interface CompanyProductRepository extends JpaRepository<CompanyProduct, Long> {
}
