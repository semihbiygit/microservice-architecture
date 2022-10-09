package com.semih.utility;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public class ServiceManager<T, ID> implements IServices<T, ID> {
    private final ElasticsearchRepository<T, ID> service;

    public ServiceManager(ElasticsearchRepository<T, ID> service) {
        this.service = service;
    }

    @Override
    public T save(T entity) {
        return service.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        return service.saveAll(entities);
    }

    @Override
    public T update(T entity) {
        return service.save(entity);
    }

    @Override
    public void delete(T entity) {
        service.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        service.deleteById(id);
    }


    public Optional<T> findById(ID id) {
        return service.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return service.findAll();
    }
}
