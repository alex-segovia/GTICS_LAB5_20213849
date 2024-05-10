package com.example.laboratorio5.Repository;

import com.example.laboratorio5.Dto.TicketPorSitioDto;
import com.example.laboratorio5.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    @Query(nativeQuery = true,value = "select s.SiteName as sitio, count(t.TicketID) as cantidadTicket from ticket t inner join site s on t.SiteID=s.SiteID group by s.SiteID")
    List<TicketPorSitioDto> listarTicketPorSitio();
}
