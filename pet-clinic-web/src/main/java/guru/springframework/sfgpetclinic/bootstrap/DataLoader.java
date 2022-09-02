package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.PetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService<Owner, Long> ownerService;
    private final VetService<Vet, Long> vetService;
    private final PetService<Pet, Long> petService;

    public DataLoader(OwnerService<Owner, Long> ownerService, VetService<Vet, Long> vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = new PetServiceMap();
    }

    @Override
    public void run(String... args) {
        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Jackson");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ivete");
        owner2.setLastName("Sangalo");
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

        System.out.println("Load Vets");


    }

}
