import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom, int likeok, LocalDateTime letrejott, LocalDateTime szerkesztve) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = LocalDateTime.now();
    }

    public void like(){
        likeok++;
    }


    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    @Override
    public String toString() {
        if (szerkesztve != letrejott){
            return String.format("szerző - %s likeok - %d letrejott - %d \n szerkesztve: %s \n %s",
                    szerzo,likeok,letrejott,szerkesztve,tartalom);
        }else{
            return String.format("szerző - %s likeok - %d letrejott - %d \n %s",
                    szerzo,likeok,letrejott,tartalom);
        }

    }

}
