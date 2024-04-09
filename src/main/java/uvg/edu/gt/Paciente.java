package uvg.edu.gt;

 class Paciente implements Comparable<Paciente> {
     private String nombre;
     private String sintoma;
     private char codigoEmergencia;
 
     /**
      * Constructor de la clase Paciente.
      * @param nombre El nombre del paciente.
      * @param sintoma El síntoma o descripción de la condición del paciente.
      * @param codigoEmergencia El código de emergencia asignado al paciente.
      */
     public Paciente(String nombre, String sintoma, char codigoEmergencia) {
         this.nombre = nombre;
         this.sintoma = sintoma;
         this.codigoEmergencia = codigoEmergencia;
     }
 
     /**
      * Obtiene el código de emergencia del paciente.
      * @return El código de emergencia del paciente.
      */
     public char getCodigoEmergencia() {
         return codigoEmergencia;
     }
 
     @Override
     public int compareTo(Paciente otro) {
         return this.getCodigoEmergencia() - otro.getCodigoEmergencia();
     }
 
     @Override
     public String toString() {
         return nombre + ", " + sintoma + ", " + codigoEmergencia;
     }
 }
 