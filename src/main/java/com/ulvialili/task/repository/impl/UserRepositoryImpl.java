package com.ulvialili.task.repository.impl;

import com.ulvialili.task.domain.User;
import com.ulvialili.task.repository.UserRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private UserRowMapper userRowMapper;

    public UserRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
        this.jdbcTemplate.getJdbcTemplate().setResultsMapCaseInsensitive(true);
    }

    @Transactional
    @Override
    public User addUser(User user) {
                    MapSqlParameterSource params = new MapSqlParameterSource("p_id",0)
                    .addValue("p_username",user.getUsername())
                    .addValue("p_password",user.getPassword());
            String sql=  " insert into users(username, password) " +
                    " values(:p_username, :p_password) ";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            int count = jdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});
            if (count>0){
                long id = keyHolder.getKey().longValue();
                user.setId(id); }
            return user;
        }
    }
