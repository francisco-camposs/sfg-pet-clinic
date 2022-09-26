package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialitiesService specialitiesService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {

        int count = petTypeService.findAll().size();
        if (count == 0) loaddata();

    }

    private void loaddata() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty savedRadiology = specialitiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");

        Specialty savedSurgery = specialitiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");

        Specialty savedDentistry = specialitiesService.save(dentistry);

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
        owner2 = ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(ivetePet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");
        visitService.save(catVisit);


        System.out.println("Load Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Claudia");
        vet2.setLastName("Leite");
        vet2.getSpecialities().add(savedRadiology);
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Load Vets...");
    }

}
