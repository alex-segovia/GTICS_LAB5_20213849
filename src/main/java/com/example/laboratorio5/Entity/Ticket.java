package com.example.laboratorio5.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TicketID", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site siteID;

    @ManyToOne
    @JoinColumn(name = "TechnicianID")
    private Technician technician;

    @Size(max = 50)
    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "OpenedDate")
    private LocalDateTime openedDate;

    @Column(name = "ClosedDate")
    private LocalDateTime closedDate;

}
