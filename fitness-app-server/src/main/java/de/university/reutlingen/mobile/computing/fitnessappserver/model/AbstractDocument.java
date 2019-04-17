package de.university.reutlingen.mobile.computing.fitnessappserver.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class AbstractDocument<P extends Serializable> {

    @Id
    private P id;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @CreatedDate
    private LocalDateTime createdDate;

    public P getId () {
        return id;
    }

    public void setId ( P id ) {
        this.id = id;
    }

    public LocalDateTime getLastModifiedDate () {
        return lastModifiedDate;
    }

    public void setLastModifiedDate ( LocalDateTime lastModifiedDate ) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDateTime getCreatedDate () {
        return createdDate;
    }

    public void setCreatedDate ( LocalDateTime createdDate ) {
        this.createdDate = createdDate;
    }

    public boolean isNew(){
        return Objects.isNull (getId ());
    }
}
