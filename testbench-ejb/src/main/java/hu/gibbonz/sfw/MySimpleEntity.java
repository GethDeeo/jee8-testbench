package hu.gibbonz.sfw;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "mySimpleEntity")
public class MySimpleEntity {
    private Long id;
    private String someStringValue;
    private OffsetDateTime someDateTimeValue;

    @Id
    @GeneratedValue
    @Column(nullable = false, insertable = false, updatable = false)
    public Long getId() { return id; }

    public void setId(final Long id) { this.id = id; }

    @Column(length = 254)
    public String getSomeStringValue() { return someStringValue; }

    public void setSomeStringValue(final String someStringValue) { this.someStringValue = someStringValue; }

    @Column
    public OffsetDateTime getSomeDateTimeValue() { return someDateTimeValue; }

    public void setSomeDateTimeValue(final OffsetDateTime someDateTimeValue) { this.someDateTimeValue = someDateTimeValue; }
}
