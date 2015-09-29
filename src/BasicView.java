
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
 
@ManagedBean(name="dtBasicView")
@ViewScoped

public class BasicView implements Serializable {
     
    private List<Eventos> eventos;
     
    @ManagedProperty("#{Eventos}")
    private Eventos service;
 
    @PostConstruct
    public void init() {
    //    eventos = service.createEventos(2);
    }
    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setService(Eventos service) {
        this.service = service;
    }

}
