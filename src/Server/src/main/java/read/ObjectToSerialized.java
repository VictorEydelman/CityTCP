package Server.src.main.java.read;

import Common.src.main.java.Serialized.Seri;
import Common.src.main.java.Serialized.SeriCombined;
import Common.src.main.java.Serialized.Seriobject;
import Common.src.main.java.Serialized.Seritwo;
import Server.src.main.java.Commands.ReceiverServer;

import java.io.IOException;
import java.text.ParseException;

public class ObjectToSerialized {
    public ObjectToSerialized(Object o) throws ParseException, IOException, ClassNotFoundException {

        if (o instanceof Seri) {
            Seri h = (Seri) o;
            String[] b = new String[1];
            h.getCommand().execute(b);
        } else if (o instanceof Seritwo) {
            Seritwo h = (Seritwo) o;
            String[] b = new String[2];
            b[1]= String.valueOf(h.getKey());
            h.getCommand().execute(b);
        } else if (o instanceof Seriobject) {
            Seriobject h = (Seriobject) o;
            String[] b = new String[2];
            b[1]= String.valueOf(h.getStandard());
            h.getCommand().execute(b);
        } else if (o instanceof SeriCombined) {
            SeriCombined h = (SeriCombined) o;
            String[] b = new String[2];
            b[1] = String.valueOf(h.getId());
            String[] m = h.getCreatCollection();
            String[] n = new String[3 + m.length];
            n[1] = String.valueOf(h.getId());
            String id = Integer.toString(ReceiverServer.getsize() + 1);
            n[2] = id;
            for (int i = 0; i < m.length; i++) {
                n[i + 3] = m[i];
            }
            h.getCommand().execute(n);
        }
    }
}
