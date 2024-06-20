package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class SSM  {
    private Integer availableKits;
    private List<Person> persons;
    private Map<Integer, Test> tests;

    public SSM(Integer initialKits) {
        this.availableKits = initialKits;
        this.persons = new ArrayList<>();
        this.tests = new HashMap<>();
    }

    // Función para registrar una persona en el sistema
    public void registerPerson(Person person) throws NoAvailableKitsException, DuplicateDniException {
        if (this.availableKits <= 0) {
            throw new NoAvailableKitsException("ERROR: No hay kits disponibles!");
        }else{

            // Verifico la existencia del DNI en el sistema
            for (Person p : this.persons) {
                if (p.getDni().equals(person.getDni())) {
                    throw new DuplicateDniException("El DNI ingresado ya está dado de alta en el sistema: " + person.getDni());
                }
            }
            person.setKitNumber(new Random().nextInt(10000000));
            this.persons.add(person);
            this.availableKits--;
        }
    }

    // Función para testeaer a las personas que ingresaron al sistema
    public void test() {
        Random random = new Random();

        for (Person person : persons) {
            Double temperature = 36+(39-36)*random.nextDouble();
            Test test = new Test(person.getDni(), temperature);

            // Guardo el test realizado en el HashMap
            tests.put(person.getKitNumber(), test);
        }
    }

    // Funcion para aislar a las personas con temperatura mayor a 38 grados
    public void isolate() {
        List<Test> urgents = new ArrayList<>(); // ArrayList donde vamos a guardar los casos urgentes

        // Recorro el HashMpa con los testeo registrados y voy verificando cada caso particular.
        // Si supera los 38 grados, es considerado un caso urgente.
        for (Map.Entry<Integer, Test> test : tests.entrySet()) {
            if (test.getValue().getTemperature() >= 38){
                try{
                    throw new UrgentCaseException("CASO URGENTE: (KIT: "+test.getKey()
                            +" /// BARRIO: "+findNeighborhoodByKit(test.getKey())
                            +")");
                } catch (UrgentCaseException e){
                    urgents.add(test.getValue()); //Almaceno el dato del hshmap en array temporal
                }
            }
        }

        // Envío el array de casos urgentes encontrados a la función que los guardará en el archivo binario
        saveUrgentDAT(urgents);
    }

    // Función para encontrar Barrio de la persona mediante el Nro. de Kit
    private String findNeighborhoodByKit (Integer kit){
        String aux = "";

        for (Person person : this.persons){
            if (person.getKitNumber().equals(kit)) {
                aux = person.getNeighborhood();
            }
        }

        return aux;
    }

    // Función para guardar los casos urgentes testeados
    private void saveUrgentDAT(List<Test> urgents){
        try(ObjectOutputStream objOutStr = new ObjectOutputStream(new FileOutputStream("urgents.dat"))){
            objOutStr.writeObject(urgents);
        } catch (IOException e) {
            e.printStackTrace(); //Manejamos IOException en caso de que el método writeObject la lance
        }
    }

    // Función para exportar resultados a un archivo JSON
    public void exportJSON() {
        JSON json = new JSON();

        // Recorro los tests
        for (Map.Entry<Integer, Test> entry : tests.entrySet()) {
            //Guardo los datos necesarios
            Integer kitNumber = entry.getKey();
            Test test = entry.getValue();
            Person person = findPersonByKit(kitNumber);

            //Filtro sanos y aislados
            if (test.getTemperature() >= 38) {
                Isolate isolate = new Isolate(kitNumber, test.getTemperature(), person.getNeighborhood());
                json.addIsolate(isolate);
            } else {
                json.addHealthy(person);
            }
        }

        // Una vez creado el objeto JSON con los dos arreglos, los guardo en un json
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("results.json"), json);
            System.out.println("\nResultados exportados con éxito al archivo results.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Función para encontrar una persona por número de kit
    private Person findPersonByKit(Integer kitNumber) {
        Person p = null;

        for (Person person : persons) {
            if (person.getKitNumber().equals(kitNumber)) {
                p = person;
            }
        }
        return p;
    }

}