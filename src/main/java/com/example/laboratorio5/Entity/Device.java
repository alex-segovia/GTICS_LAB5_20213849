package com.example.laboratorio5.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeviceID", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "DeviceName")
    private String deviceName;

    @Size(max = 255)
    @Column(name = "DeviceType")
    private String deviceType;

    @Size(max = 255)
    @Column(name = "Model")
    private String model;

    @Size(max = 255)
    @Column(name = "SerialNumber")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "SiteID")
    private Site site;

}
