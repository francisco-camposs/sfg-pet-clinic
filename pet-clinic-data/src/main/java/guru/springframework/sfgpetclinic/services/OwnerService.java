package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Person;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
