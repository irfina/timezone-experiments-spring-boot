/*
 * Person.java
 *
 * Created on Nov 01, 2022, 17.06
 */
package demo.irfin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * @author Irfin A.
 */
@Entity
@Table(name = "orang")
public class Person
{
    @Id
    @GeneratedValue
    @Column(name = "systemid")
    private UUID systemId;

    private String fullname;

    @Column(name = "createdat", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdAt;

    @Column(name = "lastactive", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastActive;

    public UUID getSystemId()
    {
        return systemId;
    }

    public void setSystemId(UUID _systemId)
    {
        systemId = _systemId;
    }

    public String getFullname()
    {
        return fullname;
    }

    public void setFullname(String _fullname)
    {
        fullname = _fullname;
    }

    public OffsetDateTime getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime _createdAt)
    {
        createdAt = _createdAt;
    }

    public LocalDateTime getLastActive()
    {
        return lastActive;
    }

    public void setLastActive(LocalDateTime _lastActive)
    {
        lastActive = _lastActive;
    }
}
