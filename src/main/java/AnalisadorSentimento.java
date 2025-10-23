import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;

public class AnalisadorSentimento {
    private static final String ENDPOINT = "";
    private static final String API_KEY = "";

    public static void main(String[] args) {

        // 1. Cria o Cliente para conectar ao Azure
        TextAnalyticsClient client = new TextAnalyticsClientBuilder()
            .credential(new AzureKeyCredential(API_KEY))
            .endpoint(ENDPOINT)
            .buildClient();

        // 2. Texto de exemplo para análise
        String texto = "Eu adorei a experiência, o atendimento foi excelente e o produto chegou rápido!";

        // 3. Executa a Análise de Sentimento
        System.out.println("Analisando o texto: \"" + texto + "\"");

        DocumentSentiment documentSentiment = client.analyzeSentiment(texto);

        // 4. Imprime o Resultado
        System.out.printf(
            "\nResultado da Análise:\n"
            + "  Sentimento Geral: %s\n"
            + "  Confiança Positiva: %.2f%%\n"
            + "  Confiança Negativa: %.2f%%\n",
            documentSentiment.getSentiment(), 
            documentSentiment.getConfidenceScores().getPositive() * 100, 
            documentSentiment.getConfidenceScores().getNegative() * 100);
    }
}