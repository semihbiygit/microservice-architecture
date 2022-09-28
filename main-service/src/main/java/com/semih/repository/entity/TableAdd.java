package com.semih.repository.entity;


import javax.persistence.Embeddable;


@Embeddable
public class TableAdd {

    /**
     * Ortak olan alanlar
     */
    Long createDate;
    Long updateDate;
}
