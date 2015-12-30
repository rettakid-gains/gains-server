package za.co.rettakid.gains.persistence.entity;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;
import za.co.rettakid.gains.persistence.listener.CustomRevisionListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LWAZI8 on 15/12/2015.
 */
@Entity
@RevisionEntity(CustomRevisionListener.class)
@Table(name = "REVINFO")
public class RevisionInfoEntity  {

    private Integer rev;
    private Long timestamp;
    private Long userId;
    private Date dateChanged;

    @Id
    @RevisionNumber
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="REV" , length=15 , nullable=false)
    public Integer getRev() {
        return rev;
    }

    public void setRev(Integer rev) {
        this.rev = rev;
    }

    @RevisionTimestamp
    @Column(name="REVTSTMP" , length=15 , nullable=false)
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Basic
    @Column(name="USER_ID" , length=15 , nullable=false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name="DATE_CHANGED" , length=0 , nullable=false)
    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
}
