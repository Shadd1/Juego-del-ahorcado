
public class Paises extends Word {

  //easy words 4-7 letters
  private String[] easyWords = {"INDIA", "EGIPTO", "MIAMI", "MOSCUO", "JAMAICA"
  ,"CHINA","JAPON","RUSIA"};
  // medium words 8-12 letters
  private String[] mediumWords = {"MALASIA", "ARABIA SAUDI", "MADAGASCAR",
    "NUEVA ZELANDA", "MONTENEGRO", "MACEDONIA", "INDONESIA"};
  //hard words 12-25 letters
  private String[] hardWords = {"ESTADOS UNIDOS", "REPUBLICA DE AFRICA",
    "REPUBLICA DEMOCRATA", "REINO DE INGLATERRA",
    "GUINEA ECUATORIAL", "FEDERACION DE MICRONESIA",
    "SUR DE AFRICA", "PAPUA NUEVA GUINEA"};

  public Paises(int nivel) {
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
