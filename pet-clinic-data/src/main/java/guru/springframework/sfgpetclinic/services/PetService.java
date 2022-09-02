package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.model.Pet;

public interface PetService<P extends BaseEntity, L extends Number> extends CrudService<Pet, Long> {

}
