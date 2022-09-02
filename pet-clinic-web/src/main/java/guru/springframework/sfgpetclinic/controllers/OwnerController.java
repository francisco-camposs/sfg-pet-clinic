package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService<Owner, Long> ownerService;

    public OwnerController(OwnerService<Owner, Long> ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping(path = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
    public String listOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owner/index";
    }


}
