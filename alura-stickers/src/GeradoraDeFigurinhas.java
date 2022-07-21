import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
// import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {


    // Leitura da imagem
    // InputStream inputStream = new FileInputStream(new File("alura-stickers/entrada/filme.jpg"));
    // InputStream inputStream = new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream();
    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // Cria nova imagem em meoria com transparencia e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // Copiar a imagem original pra nova imagem (em memoria)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // Configurar a fonte
    Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // Escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 1 ,novaAltura - 100);

    // Escrever a nova imagem
    ImageIO.write(novaImagem, "png", new File("alura-stickers/saida/figurinha.png"));
  }
}
