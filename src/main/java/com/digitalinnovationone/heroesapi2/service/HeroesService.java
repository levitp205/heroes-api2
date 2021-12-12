package com.digitalinnovationone.heroesapi2.service;

import com.digitalinnovationone.heroesapi2.document.Heroes;
import com.digitalinnovationone.heroesapi2.repository.HeroesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@Service
public class HeroesService {

    private final HeroesRepository heroesRepository;

    public HeroesService(HeroesRepository heroesRepository){
        this.heroesRepository=heroesRepository;
    }

    public Flux<Heroes> findAll(){
        return Flux.fromIterable(this.heroesRepository.findAll());
    }

    public Mono<Heroes> findByIdHeroes(String id){
        return Mono.justOrEmpty(this.heroesRepository.findById(id));
    }
    public Mono<Heroes> save (Heroes heroes){
        return Mono.justOrEmpty(this.heroesRepository.save(heroes));
    }
    public Mono<Boolean> deleByIdHeroes(String id){
        heroesRepository.deleteById(id);
        return Mono.just(true);
    }
}
