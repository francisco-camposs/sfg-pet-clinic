package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.BaseEntity;
import guru.springframework.sfgpetclinic.model.PetType;

public interface PetTypeService<P extends BaseEntity, L extends Number> extends CrudService<PetType, Long> {

}
