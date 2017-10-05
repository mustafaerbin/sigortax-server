package com.tr.sigorta.repository;

import com.tr.sigorta.domain.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mustafa Erbin on 01/10/2017.
 */
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
