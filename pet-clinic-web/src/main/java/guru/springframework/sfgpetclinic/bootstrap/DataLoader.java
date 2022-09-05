package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService<Owner, Long> ownerService;
    private final VetService<Vet, Long> vetService;
    private final PetTypeService<PetType, Long> petTypeService;

    public DataLoader(OwnerService<Owner, Long> ownerService, VetService<Vet, Long> vetService, PetTypeService<PetType, Long> petTypeService, PetService<Pet, Long> petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Load PetTypes...");

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");
        owner1.setAddress("123 Times");
        owner1.setCity("New York");
        owner1.setTelephone("123123123");

        Pet michaelPet = new Pet();
        michaelPet.setName("Maradona");
        michaelPet.setOwner(owner1);
        michaelPet.setPetType(savedDogPetType);
        michaelPet.setBirthDate(LocalDate.parse("2010-01-01"));
        owner1.getPets().add(michaelPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivete");
        owner2.setLastName("Sangalo");
        owner2.setAddress("657 Pelourinho");
        owner2.setCity("Salvador");
        owner2.setTelephone("321321321");

        Pet ivetePet = new Pet();
        ivetePet.setOwner(owner2);
        ivetePet.setName("Olivia");
        ivetePet.setPetType(savedCatPetType);
        ivetePet.setBirthDate(LocalDate.parse("2009-01-01"));
        owner2.getPets().add(ivetePet);
        ownerService.save(owner2);

        System.out.println("Load Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Claudia");
        vet2.setLastName("Leite");
        vetService.save(vet2);

        System.out.println("Load Vets...");


    }

}
