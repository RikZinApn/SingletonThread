package Exemplo;

public class Singleton {

    // Campo estático volátil para armazenar a referência à instância única.
    private static volatile Singleton instance;

    // Valor da string associado à instância.
    private String data;

    // Construtor privado para inicializar a instância com os dados fornecidos.
    private Singleton(String data) {
        this.data = data;
    }

    // Método público estático para acessar a instância Singleton.
    public static Singleton getInstance(String data) {
        // Verifica se a instância já existe
        if (instance == null) {
            // Cria uma nova instância dentro de um bloco sincronizado
            synchronized (Singleton.class) {
                // Verifica novamente dentro do bloco sincronizado para garantir que outra thread não criou uma instância enquanto esperava
                if (instance == null) {
                    instance = new Singleton(data);
                }
            }
        }
        return instance;
    }
}
