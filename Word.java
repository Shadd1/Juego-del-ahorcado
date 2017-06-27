
public abstract class Word implements WordInterface {

  private String palabra;
  private int nivel;

  public Word(int level) {
    this.nivel = nivel;
  }

  public String getWord() {
    return palabra;
  }

  public void setWord(String palabra) {
    this.palabra= palabra;
  }

  public int getnivel() {
    return nivel;
  }

  public void setnivel(int nivel) {
    this.nivel = nivel;
  }

}
