import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class javaRetoFinal {
    public static void main(String[] args) {
        
        // Contador para almacenar la cantidad exacta de personas que asistiran a los eventos
        int totalPersonasUnicas = 0;
        
        // Contador de participaciones por evento
        int contEventoTrans=0;
        int contEventoSeg=0;
        int contEventoDis=0;
        int contEventoNet=0;

        //Arrays para sacar los datos de nombre y apellidos, estableciendo un limite de filas
        String[][] listaTrans = new String[50][2];
        String[][] listaSeg = new String[50][2];
        String[][] listaDis = new String[50][2];
        String[][] listaNet = new String[50][2];

        try {
            // Carga explícitamente el driver JDBC de MySQL en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establece la conexión con la base de datos
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eventos_kodegune", "root", ""
            );

            // Crea un objeto de clase Statement
            Statement statement = connection.createStatement();

            // Ejecuta la consulta SQL SELECT
            ResultSet resultSet = statement.executeQuery("select * from inscripciones");
            
            boolean eventoTrans, eventoSeg, eventoDis, eventoNet;
            String nombre;
            String apellido; 

            
            while (resultSet.next()) {
                
                totalPersonasUnicas++; 

                
                nombre = resultSet.getString(2);
                apellido = resultSet.getString(3);
                eventoTrans = resultSet.getBoolean(7);
                eventoSeg = resultSet.getBoolean(8);
                eventoDis = resultSet.getBoolean(9);
                eventoNet = resultSet.getBoolean(10);
                String[] fila = new String[2];
                fila[0] = nombre; 
                fila[1] = apellido;
                
                if(eventoTrans) {
                    listaTrans[contEventoTrans] = fila;
                    contEventoTrans++; 
                }
                if(eventoSeg) {
                    listaSeg[contEventoSeg] = fila;
                    contEventoSeg++;
                }
                if(eventoDis) {
                    listaDis[contEventoDis] = fila;
                    contEventoDis++;
                }
                if(eventoNet) {
                    listaNet[contEventoNet] = fila;
                    contEventoNet++;
                }
                
            }
            
            int totalGente = contEventoTrans + contEventoSeg + contEventoDis + contEventoNet;

            // Impresion final con los resultados totales que se pedian en el reto mas 1 añadido (total de participaciones, suma de checks de los eventos)
            
            System.out.println("\n=============================================");
            System.out.println("Cantidad de inscripciones por evento: ");
            System.out.println();
            System.out.println("La cantidad de personas que se han inscrito al evento de transformación digital es de: "+contEventoTrans);
            System.out.println("La cantidad de personas que se han inscrito al evento de seguridad en la nube es de: "+contEventoSeg);
            System.out.println("La cantidad de personas que se han inscrito al evento de diseño ux/ui avanzado es de: "+contEventoDis);
            System.out.println("La cantidad de personas que se han inscrito al evento de networking y cóctel es de: "+contEventoNet);
            System.out.println("=============================================");
            System.out.println("Cantidad total de personas inscritas: ");
            System.out.println();
            System.out.println("La cantidad total de personas que se han inscrito a la cumbre es de: "+totalPersonasUnicas);
            System.out.println("=============================================");
            System.out.println("Cantidad de participaciones marcadas como asistencia: ");
            System.out.println();
            System.out.println("El total de participaciones marcadas (suma de todos los checks) es de: "+totalGente);
            System.out.println();
            System.out.println("=============================================");

            // Impresion del listado por nombres y apellidos
            
            System.out.println("Listado de participantes por evento: ");
            System.out.println();
            
            // Listados en el evento de transformacion digital
            System.out.println("Evento: Transformación Digital (Total: " + contEventoTrans + ")");
            for (int i = 0; i < contEventoTrans; i++) {
                
                System.out.print("-");
                for (String elemento : listaTrans[i]) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
            System.out.println();

            // Listados en el evento de seguridad en la nube
            System.out.println("Evento: Seguridad en la Nube (Total: " + contEventoSeg + ")");
            for (int i = 0; i < contEventoSeg; i++) {
                System.out.print("-");
                for (String elemento : listaSeg[i]) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
            System.out.println();

            // Listados en el evento de diseño ux/ui avanzado
            System.out.println("Evento: Diseño UX/UI Avanzado (Total: " + contEventoDis + ")");
            for (int i = 0; i < contEventoDis; i++) {
                System.out.print("-");
                for (String elemento : listaDis[i]) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
            System.out.println();

            // Listados en el evento de networking y cóctel
            System.out.println("Evento: Networking y Cóctel (Total: " + contEventoNet + ")");
            for (int i = 0; i < contEventoNet; i++) {
                System.out.print("-");
                for (String elemento : listaNet[i]) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
            
            System.out.println("\n=============================================");


            // Cierra la conexión con la base de datos (libera recursos)
            connection.close();

        } 
        catch (Exception e) {
            System.err.println("\n❌ ERROR: Ha ocurrido un error.");
            System.err.println(e);
        }
    }
}