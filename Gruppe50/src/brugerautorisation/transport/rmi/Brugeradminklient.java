package brugerautorisation.transport.rmi;

import brugerautorisation.data.Diverse;
import brugerautorisation.data.Bruger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Brugeradminklient {

    public Brugeradmin ba;

    public Brugeradminklient() {
    }

    public boolean login(String navn, String password) {
        Bruger b;

        try {
            ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");
        } catch (NotBoundException ex) {
            Logger.getLogger(Brugeradminklient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Brugeradminklient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (RemoteException ex) {
            Logger.getLogger(Brugeradminklient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        try {
            b = ba.hentBruger(navn, password);
            System.out.println(b.adgangskode);
            System.out.println("Fik bruger = " + b);
            System.out.println("Data: " + Diverse.toString(b));
        } catch (RemoteException ex) {
            Logger.getLogger(Brugeradminklient.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
}
