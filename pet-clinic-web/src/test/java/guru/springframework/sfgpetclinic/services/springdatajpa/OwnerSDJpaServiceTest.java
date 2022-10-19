package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    final String LAST_NAME = "Smith";
    final Long OWNER_ID = 1L;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        Owner owner1 = Owner.builder().id(1L).build();
        owners.add(owner1);
        Owner owner2 = Owner.builder().id(2L).build();
        owners.add(owner2);

        when(ownerRepository.findAll()).thenReturn(owners);

        assertNotNull(service.findAll());
        assertEquals(owners, service.findAll());
    }

    @Test
    void findById() {
        Owner owner = Owner.builder().id(OWNER_ID).build();
        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(owner));

        Owner ownerGotta = service.findById(OWNER_ID);
        assertNotNull(ownerGotta);
        verify(ownerRepository).findById(any());

    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(OWNER_ID).build();

        when(ownerRepository.save(any())).thenReturn(owner);
        Owner ownerSaved = service.save(owner);

        assertNotNull(ownerSaved);
    }

    @Test
    void delete() {
        service.delete(Owner.builder().id(1L).build());
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(any());
    }

    @Test
    void findByLastName() {
        Owner returnOwner =  Owner.builder().id(1L).lastName(LAST_NAME).build();

        when(ownerRepository.findByLastName(any())).thenReturn(Optional.ofNullable(returnOwner));
        Owner smith = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}