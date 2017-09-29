package com.ucbcba.blog.repositories;

import com.ucbcba.blog.entities.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by amolina on 25/09/17.
 */
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
