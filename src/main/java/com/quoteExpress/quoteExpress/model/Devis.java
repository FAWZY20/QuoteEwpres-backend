package com.quoteExpress.quoteExpress.model;


import com.quoteExpress.quoteExpress.DTO.Product;
import com.quoteExpress.quoteExpress.sevice.ProductListConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "devis")
public class Devis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateurid")
    private User users;
    
    @Column(name = "clientname")
    private String clientName;

    @Column(name = "clientadress")
    private String clientAdress;

    @Column(name = "clientzip")
    private String clientZip;

    @Column(name = "clientcity")
    private String clientCity;

    @Column(name = "clientsiret")
    private String clientSiret;

    @Column(name = "clienttel")
    private String clientTel;

    @Column(name = "datedevis")
    private LocalDate dateDevis;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "listproduct", columnDefinition = "jsonb")
    private List<Product> listProduct;

    @Column(name = "info")
    private String info;

    @Column(name = "totalht")
    private BigDecimal totalHt;

    @Column(name = "totaltva")
    private BigDecimal  totalTva;

    @Column(name = "totalttc")
    private BigDecimal  totalTtc;

    public Devis(Long id, User user, String clientName, String clientAdress, String clientZip, String clientCity,
                 String clientSiret, String clientTel, LocalDate dateDevis, List<Product> listProduct,
                 String info, BigDecimal  totalHt, BigDecimal  totalTva, BigDecimal  totalTtc) {
        this.id = id;
        this.users = users;
        this.clientName = clientName;
        this.clientAdress = clientAdress;
        this.clientZip = clientZip;
        this.clientCity = clientCity;
        this.clientSiret = clientSiret;
        this.clientTel = clientTel;
        this.dateDevis = dateDevis;
        this.listProduct = listProduct;
        this.info = info;
        this.totalHt = totalHt;
        this.totalTva = totalTva;
        this.totalTtc = totalTtc;
    }

    public Devis(){}

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAdress() {
        return clientAdress;
    }

    public void setClientAdress(String clientAdress) {
        this.clientAdress = clientAdress;
    }

    public String getClientZip() {
        return clientZip;
    }

    public void setClientZip(String clientZip) {
        this.clientZip = clientZip;
    }

    public String getClientCity() {
        return clientCity;
    }

    public void setClientCity(String clientCity) {
        this.clientCity = clientCity;
    }

    public String getClientSiret() {
        return clientSiret;
    }

    public void setClientSiret(String clientSiret) {
        this.clientSiret = clientSiret;
    }

    public String getClientTel() {
        return clientTel;
    }

    public void setClientTel(String clientTel) {
        this.clientTel = clientTel;
    }

    public LocalDate getDateDevis() {
        return dateDevis;
    }

    public void setDateDevis(LocalDate dateDevis) {
        this.dateDevis = dateDevis;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public BigDecimal  getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(BigDecimal  totalHt) {
        this.totalHt = totalHt;
    }

    public BigDecimal  getTotalTva() {
        return totalTva;
    }

    public void setTotalTva(BigDecimal  totalTva) {
        this.totalTva = totalTva;
    }

    public BigDecimal  getTotalTtc() {
        return totalTtc;
    }

    public void setTotalTtc(BigDecimal  totalTtc) {
        this.totalTtc = totalTtc;
    }
}
