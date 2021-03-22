package com.elastic.springelastic.service;

import com.elastic.springelastic.model.Users;
import com.elastic.springelastic.repository.UserRepository;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private ElasticsearchOperations elasticsearchOperations;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository( ElasticsearchOperations elasticsearchOperations, UserRepository userRepository) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.userRepository = userRepository;
    }

    public Users save(Users users) {

        return userRepository.save(users);
    }


    public void delete(Users book) {
        userRepository.delete(book);
    }


    public List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();
        Iterable<Users> usersIterable = userRepository.findAll();
        usersIterable.forEach(usersList::add);
        return usersList;
    }


//    public List<Users> findByName(String name) {
//        return userRepository.findByName(name);
//    }

    public SearchHits<Users> findByName(String name) {

            Criteria criteria = new Criteria("name").is(name);
            Query query = new CriteriaQuery(criteria);
            return elasticsearchOperations.search(query, Users.class);
        }

    public SearchHits<Users> findSalary(String minSal, String maxSal) {
        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.rangeQuery("salary").lt(maxSal).gt(minSal))
                .build();
        return elasticsearchOperations.search(query, Users.class);
    }

    public SearchHits<Users> search(String keywords) {
        MatchQueryBuilder searchByNames = QueryBuilders.matchQuery("name", keywords);
        Query query = new NativeSearchQuery(searchByNames);
        return elasticsearchOperations.search(query, Users.class);
    }
}
