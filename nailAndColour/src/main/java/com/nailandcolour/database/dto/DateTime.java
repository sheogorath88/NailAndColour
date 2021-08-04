package com.nailandcolour.database.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "date_time")
public class DateTime implements Serializable {

    @Id
    @Column(name = "date_time_id")
    private int dateTimeId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Instant time;

    public DateTime(int dateTimeId, LocalDate date, Instant time) {
        this.dateTimeId = dateTimeId;
        this.date = date;
        this.time = time;
    }

    public DateTime() {
    }

    public int getDateTimeId() {
        return dateTimeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Instant getTime() {
        return time;
    }

    public DateTime setDateTimeId(int dateTimeId) {
        this.dateTimeId = dateTimeId;
        return this;
    }

    public DateTime setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public DateTime setTime(Instant time) {
        this.time = time;
        return this;
    }
}
