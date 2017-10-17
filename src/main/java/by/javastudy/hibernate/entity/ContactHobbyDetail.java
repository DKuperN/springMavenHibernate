package by.javastudy.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "ContactHobbyDetail")
@IdClass(ContactHobbyDetailEntityPK.class)
public class ContactHobbyDetail {
    private Integer contactId;
    private String hobbyId;

    @Id
    @Column(nullable = false)
    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Id
    @Column(nullable = false, length = 20)
    public String getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactHobbyDetail that = (ContactHobbyDetail) o;

        if (contactId != that.contactId) return false;
        if (hobbyId != null ? !hobbyId.equals(that.hobbyId) : that.hobbyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (hobbyId != null ? hobbyId.hashCode() : 0);
        return result;
    }
}
