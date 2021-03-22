package com.elastic.springelastic.repository;

import com.elastic.springelastic.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<Users, String> {
    List<Users> findByName(String name);

}

