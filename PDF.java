package classes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class PDF {
    //para realizar essa função é necessário adicionar a dependência do IText Core
    //IText Core -> https://repo1.maven.org/maven2/com/itextpdf/itextpdf/5.5.13.2/itextpdf-5.5.13.2.jar

    //método responsável por criar um novo PDF, passando o diretório onde será salvo e o nome que o arquivo terá
    public static void createPDF(String dir, String fileName) {
        //instânciando um novo documento
        var document = new Document();

        try {
            //pegando uma instância da classe PdfWriter
            PdfWriter.getInstance(
                    document, //passando o objeto do documento que será criado
                    new FileOutputStream(dir + "\\" + fileName) //passando um objeto de escrita, para criar o novo arquivo especificado
            );

            document.open(); //iniciando o processo de escrita no documento
            document.add(new Paragraph("Texto qualquer")); //passando um parágrafo que será escrito

            JOptionPane.showMessageDialog(null, "Arquivo criado com sucesso!");
        } catch (DocumentException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + e.getMessage());
        } finally {
            //fechando a escrita do documento
            document.close();
        }
    }
}
