package clientewsfootball;

import java.util.List;

public class ClienteWSFootball {

    public static void main(String[] args) {
        System.out.println("Yellow cards: " + yellowCardsTotal());
        todosLosDefensas();
       
    }
    
    private static void todosLosDefensas(){                
        List<TCountryInfo> tcountryinfo = countryNames(true).getTCountryInfo();
        for (TCountryInfo tcountryinfo1 : tcountryinfo) {
            System.out.println("------------------------------------");
            System.out.println("Para el país: "+ tcountryinfo1.sName);
            List<String> aDefender = allDefenders(tcountryinfo1.sName).getString();
            for (String aDefender1 : aDefender) {
                System.out.println("Defensor: " + aDefender1);
            }
        }
        System.out.println("------------------------------------");
    }
    
    private static int yellowCardsTotal() {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
    
}
