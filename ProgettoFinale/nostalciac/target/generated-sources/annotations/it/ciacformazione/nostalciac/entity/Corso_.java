package it.ciacformazione.nostalciac.entity;

import it.ciacformazione.nostalciac.entity.Sede;
import it.ciacformazione.nostalciac.entity.Tag;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-01T17:02:01")
@StaticMetamodel(Corso.class)
public class Corso_ { 

    public static volatile SingularAttribute<Corso, LocalDate> inizio;
    public static volatile SingularAttribute<Corso, String> note;
    public static volatile SingularAttribute<Corso, LocalDate> fine;
    public static volatile SingularAttribute<Corso, String> edizione;
    public static volatile SingularAttribute<Corso, Sede> sede;
    public static volatile SingularAttribute<Corso, String> nome;
    public static volatile SingularAttribute<Corso, Integer> id;
    public static volatile SetAttribute<Corso, Tag> tags;

}