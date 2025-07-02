package com.example.demo.repository;

import com.example.demo.model.UserInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserInfoRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserInfoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public UserInfo findByUserId(int userId) {
        List<UserInfo> results = jdbcTemplate.query(
                "SELECT * FROM user_info WHERE user_id = ?",
                new Object[]{userId},
                (rs, rowNum) -> new UserInfo(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("city"),
                        rs.getString("last_name")
                )
        );
        return results.isEmpty() ? null : results.get(0);
    }
    public void save(UserInfo userInfo) {
        jdbcTemplate.update(
                "INSERT INTO user_info (user_id, full_name, age, city, last_name) " +
                        "VALUES (?, ?, ?, ?, ?) " +
                        "ON CONFLICT (user_id) DO UPDATE SET " +
                        "full_name = EXCLUDED.full_name, " +
                        "age = EXCLUDED.age, " +
                        "city = EXCLUDED.city, " +
                        "last_name = EXCLUDED.last_name",
                userInfo.getUserId(),
                userInfo.getFullName(),
                userInfo.getAge(),
                userInfo.getCity(),
                userInfo.getLastName()
        );
    }
}