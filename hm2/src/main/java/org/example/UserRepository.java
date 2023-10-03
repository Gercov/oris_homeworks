package org.example;

import java.util.List;

public interface UserRepository <T> {
    List<T> findByLogin(String login);
}
