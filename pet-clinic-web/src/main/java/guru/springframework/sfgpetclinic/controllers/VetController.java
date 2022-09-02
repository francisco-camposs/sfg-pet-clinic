package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VetController {

    private final VetService<Vet, Long> vetService;

    public VetController(VetService<Vet, Long> vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(path = {"/vets", "/vets/index", "/vets/index.html"}, method = RequestMethod.GET)
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

}
