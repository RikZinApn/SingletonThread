package Exemplo;

public class Singleton {

    // Campo est�tico vol�til para armazenar a refer�ncia � inst�ncia �nica.
    private static volatile Singleton instance;

    // Valor da string associado � inst�ncia.
    private String data;

    // Construtor privado para inicializar a inst�ncia com os dados fornecidos.
    private Singleton(String data) {
        this.data = data;
    }

    // M�todo p�blico est�tico para acessar a inst�ncia Singleton.
    public static Singleton getInstance(String data) {
        // Verifica se a inst�ncia j� existe
        if (instance == null) {
            // Cria uma nova inst�ncia dentro de um bloco sincronizado
            synchronized (Singleton.class) {
                // Verifica novamente dentro do bloco sincronizado para garantir que outra thread n�o criou uma inst�ncia enquanto esperava
                if (instance == null) {
                    instance = new Singleton(data);
                }
            }
        }
        return instance;
    }
}
