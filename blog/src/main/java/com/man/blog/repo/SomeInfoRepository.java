package com.man.blog.repo;

import com.man.blog.models.SomeInfo;
import org.springframework.data.repository.CrudRepository;

public interface SomeInfoRepository extends CrudRepository<SomeInfo, Long> {
}
