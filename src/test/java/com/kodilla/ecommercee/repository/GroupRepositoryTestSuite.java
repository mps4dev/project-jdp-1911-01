package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.service.GroupService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.crypto.spec.OAEPParameterSpec;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class GroupRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void shouldCreateNewGroup() {
        //Given
        Group groupAGD = new Group(null, "AGD");

        //When
        groupRepository.save(groupAGD);
        long size = groupRepository.count();

        //Then
        assertEquals(1L, size);

    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotCreateNewGroup() {
        //Given
        Group groupNull = new Group(null, null);

        //When
        groupRepository.save(groupNull);
        entityManager.flush();

        //Then

    }

    @Test
    public void shouldGetGroup() {
        //Given
        Group groupAGD = new Group(null, "AGD");

        //When
        groupRepository.save(groupAGD);
        Optional<Group> savedGroup = groupRepository.findById(groupAGD.getId());

        //Then
        assertEquals("AGD", savedGroup.get().getName());
    }

    @Test
    public void shouldUpdateGroup() {
        //Given
        Group group = groupRepository.save(new Group(null, "AGD"));

        //When
        groupRepository.save(new Group(group.getId(), "RTV"));
        Optional<Group> updatedGroup = groupRepository.findById(group.getId());

        //Then
        assertEquals("RTV", updatedGroup.get().getName());
    }

    @Test
    public void testDelete() {
        //Given
        Group group = groupRepository.save(new Group(null, "AGD"));

        //When
        groupRepository.delete(group);
        long size = groupRepository.count();

        //Then
        assertEquals(0L, size);
    }
}
