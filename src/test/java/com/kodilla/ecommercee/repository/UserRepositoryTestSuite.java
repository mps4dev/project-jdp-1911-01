package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class UserRepositoryTestSuite {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldCreateNewUser() {
        //Given
        User user = new User("test name", 1, false);

        //When
        userRepository.save(user);

        //Then
        assertEquals(1,userRepository.count());
    }

    @Test
    public void ShouldGetUser() {
        //Given
        User user = new User("test name", 1, false);

        //When
        userRepository.save(user);
        String savedName = userRepository.findById(user.getId()).get().getName();

        //Then
        assertEquals("test name",savedName);
    }

    @Test
    public void ShouldGetAllUsers() {
        //Given
        User user1 = new User("test name 1", 1, false);
        User user2 = new User("test name 2", 2, false);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        List<User> users = userRepository.findAll();

        //Then
        assertEquals(2,users.size());
    }

    @Test
    public void ShouldDeleteUser() {
        //Given
        User user1 = new User("test name 1", 1, false);
        User user2 = new User("test name 2", 2, false);

        //When
        userRepository.save(user1);
        userRepository.save(user2);
        int repositorySize = userRepository.findAll().size();
        userRepository.deleteById(2L);
        int repositorySizeAfter = userRepository.findAll().size();

        //Then
        assertEquals(2,repositorySize);
        assertEquals(1,repositorySizeAfter);
    }
}