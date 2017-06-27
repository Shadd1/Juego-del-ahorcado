
public class Deportes extends Word {

  //palabras faciles de 4-7 letras
  private String[] easyWords = {"KABADDI", "CHESS", "GOLF", "HOCKEY", "FUTBOL", "PESCAR",
    "BUCEO", "BOXEO"};
  // palabras medias 8-12 letras
  private String[] mediumWords = {"VOLLEIBOL", "NATACION", "BASQUETBOL",
    "BICICROSS", "FUTSALA", "TAEKWONDO"};
  //palabras dificiles 12-25 letras
  private String[] hardWords = {"LIONEL MESSI", "SACHIN TENDULKAR", "RAHUL DRAVID",
    "VISHWANATAN ANAND", "TENIS DE MESA", "FUTBOL AMERICANO", "LUCHA LIBRE"};

  public Deportes(int nivel) {
    super(nivel);
  }

  @Override
  public void generateWord() {
    int option = (int) (Math.random() * 8);
    String word = "";
    switch (getnivel()) {
      case 1:
        word = easyWords[option];
        setWord(word);
        break;
      case 2:
        word = mediumWords[option];
        setWord(word);
        break;
      case 3:
        word = hardWords[option];
        setWord(word);
        break;

    }
  }

}
