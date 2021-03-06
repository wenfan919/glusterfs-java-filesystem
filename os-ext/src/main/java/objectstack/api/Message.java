package objectstack.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Calendar;

/**
 * Created by tangfeixiong on 3/6/17.
 * https://github.com/tangfeixiong/osev3-examples/tree/master/spring-boot/sample-microservices-springboot/repositories-mem
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {

    private Long id;

    @NotEmpty(message = "Message is required.")
    private String text;

    @NotEmpty(message = "Summary is required.")
    private String summary;

    private Calendar created = Calendar.getInstance();

    public Message() {
    }

    public Message(Long id, String text, String summary) {
        this.id = id;
        this.text = text;
        this.summary = summary;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreated() {
        return this.created;
    }

    public void setCreated(Calendar created) {
        this.created = created;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSummary() {
        return this.summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", summary='" + summary + '\'' +
                ", created=" + created +
                '}';
    }
}
