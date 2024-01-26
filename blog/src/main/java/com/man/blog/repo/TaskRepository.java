package com.man.blog.repo;

import com.man.blog.models.Tasks;
import org.springframework.data.repository.CrudRepository;


public interface TaskRepository extends CrudRepository<Tasks,Long> {
}
