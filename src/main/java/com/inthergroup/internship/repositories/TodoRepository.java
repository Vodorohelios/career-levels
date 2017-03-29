package com.inthergroup.internship.repositories;

import com.inthergroup.internship.models.Todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query("select task from Todo where id in " +
            "(select d.id from Todo d inner join d.careerLevels c where c.id = ?1)")
    public List<String> findTodosFromLevel(Long id);
}
