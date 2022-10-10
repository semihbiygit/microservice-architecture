package com.semih.graphql.model;

import lombok.Data;

@Data
public class UserProfileInput {
    Long authId;
    String username;
    String name;
    String surname;
    String email;
}
