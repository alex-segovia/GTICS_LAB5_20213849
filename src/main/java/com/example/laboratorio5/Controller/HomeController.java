package com.example.laboratorio5.Controller;

import com.example.laboratorio5.Dto.TicketPorSitioDto;
import com.example.laboratorio5.Entity.Technician;
import com.example.laboratorio5.Repository.TechnicianRepository;
import com.example.laboratorio5.Repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    final TechnicianRepository technicianRepository;
    final TicketRepository ticketRepository;

    public HomeController(TechnicianRepository technicianRepository, TicketRepository ticketRepository){
        this.technicianRepository = technicianRepository;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping(value = {"","/"})
    public String vistaPrincipal(){
        return "principal";
    }

    @GetMapping(value = "/tecnicos")
    public String vistaTecnicos(Model model){
        List<Technician> listaTecnicos = technicianRepository.listarTecnicos();
        model.addAttribute("listaTecnicos",listaTecnicos);
        return "tecnicos";
    }

    @GetMapping(value = "/crear")
    public String registrar(@ModelAttribute("technician") Technician technician, Model model){
        model.addAttribute("tipo","crear");
        return "formulario";
    }

    @GetMapping(value = "/editar")
    public String editar(@ModelAttribute("technician") Technician technician, @RequestParam("id") int id, Model model){
        Optional<Technician> optionalTechnician = technicianRepository.findById(id);
        if(optionalTechnician.isPresent()){
            technician = optionalTechnician.get();
            model.addAttribute("technician",technician);
            model.addAttribute("tipo","editar");
        }else{
            return "redirect:/tecnicos";
        }
        return "formulario";
    }

    @PostMapping(value = "/guardar")
    public String guardar(@ModelAttribute("technician") @Valid Technician technician, BindingResult bindingResult,
                          RedirectAttributes attr, Model model, @RequestParam("tipo") String tipo){
        if(bindingResult.hasErrors()){
            model.addAttribute("tipo",tipo);
            return "formulario";
        }else{
            attr.addFlashAttribute("mensaje","Técnico " + technician.getFirstName() + " " + technician.getLastName() + ((technician.getId()==0?" creado":" actualizado" + " exitosamente")));
            technicianRepository.save(technician);
            return "redirect:/tecnicos";
        }
    }

    @GetMapping(value = "/estadisticas")
    public String vistaEstadisticas(Model model){
        List<TicketPorSitioDto> listaTicketsPorSitio = ticketRepository.listarTicketPorSitio();
        model.addAttribute("listaTicketsPorSitio",listaTicketsPorSitio);
        return "estadistica";
    }
}
