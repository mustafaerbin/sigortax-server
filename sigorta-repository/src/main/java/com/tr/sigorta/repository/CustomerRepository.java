package com.tr.sigorta.repository;

import com.tr.sigorta.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Erbin on 06/03/2017.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
