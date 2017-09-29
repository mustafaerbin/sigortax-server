package com.tr.sigorta.repository;

import com.tr.sigorta.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mustafa Erbin on 06/03/2017.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
