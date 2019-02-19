package com.melt.grub.repo;

import com.melt.grub.domain.User;
import com.melt.grub.domain.UserField;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Component
public class UserRepo {
    @Autowired
    private MongoTemplate mongoTemplate;


    public Optional<User> findByUsername(@NonNull String username) {
        return Optional.ofNullable(mongoTemplate
                .findOne(query(where(UserField.USER_NAME.field()).is(username)), User.class));
    }

    public void save(@NonNull User user) {
        mongoTemplate.save(user);
    }
}
