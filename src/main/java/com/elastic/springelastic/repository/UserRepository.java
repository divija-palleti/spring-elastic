package com.elastic.springelastic.repository;

import com.elastic.springelastic.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface UserRepository extends ElasticsearchRepository<Users, String> {
    List<Users> findByName(String name);
}

