package com.digitalinnovationone.heroesapi2.repository;

import com.digitalinnovationone.heroesapi2.document.Heroes;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface HeroesRepository extends CrudRepository<Heroes, String> {
}
