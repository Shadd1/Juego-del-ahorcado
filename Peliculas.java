
public class Peliculas extends Word {

  //palabras faciles de 4-7 letras
  private String[] easyWords = {"Aladdin", "Aliens", "Alexander", "CRASH",
    "TITANIC", "SEÑALES", "BLADE"};
  // palabras medias 8-12 letras
  private String[] mediumWords = {"VENGADORES", "CLUB DE PELEA",
    "AMERICAN PIE", "WOLVERINE", "PACIFICADOR", "PUNISHER"};
  //palabras dificiles 12-25 letras
  private String[] hardWords = {"HOMBRES DE NEGRO",
    "TIEMPOD DE CAMBIO", "WILD WILD WEST", "PIRATAS DEL CARIBE",
    "TODOPODEROSO", "SEÑOR DE LOS ANILLOS", "ELLOS ME LLAMAN BRUCE"};

  public Peliculas (int nivel) {
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
