package org.example;

public class Main {
    public static void main(String[] args) {
        SSM ssm = new SSM(8);

        System.out.println("\nBienvenido al Sistema de Salud Municipal (SSM) ...\n");

        System.out.println("\nIngresando Pacientes ...\n");
        try{
            Person person1 = new Person("Juan", "González", 30, "Las Avenidas", "12345678", "Programador");
            ssm.registerPerson(person1);
            Person person2 = new Person("María", "Rodríguez", 25, "Puerto", "23456789", "Doctor");
            ssm.registerPerson(person2);
            Person person3 = new Person("Carlos", "Pérez", 45, "Centro", "34567890", "Vendedor");
            ssm.registerPerson(person3);
            Person person4 = new Person("Ana", "Martínez", 35, "Puerto", "45678901", "Profesor");
            ssm.registerPerson(person4);
            Person person5 = new Person("José", "García", 50, "Centro", "56789012", "Taxista");
            ssm.registerPerson(person5);
            Person person6 = new Person("Laura", "López", 28, "San Carlos", "67890123", "Vendedor");
            ssm.registerPerson(person6);
            Person person7 = new Person("Pedro", "Díaz", 33, "Puerto", "78901234", "Profesor");
            ssm.registerPerson(person7);
            Person person8 = new Person("Lucía", "Martín", 22, "Punta Mogotes", "89012345", "Estudiante");
            ssm.registerPerson(person8);
            Person person9 = new Person("Miguel", "Sánchez", 40, "Centenario", "90123456", "Mecanico");
            ssm.registerPerson(person9);
            Person person10 = new Person("Sofía", "Fernández", 27, "Centenario", "01234567", "Estudiante");
            ssm.registerPerson(person10);
        }catch (NoAvailableKitsException e){
            Integer extraKits = 10;
            System.out.println(e.getMessage());
            System.out.println("\nSe aumentará la capacidad de kits en 10 unidades ...\n");
        } catch (DuplicateDniException e) {
            System.out.println("\nEl DNI ingresado ya se encuentra dado de alta en el Sistema.");
        }

        ssm.test();
        ssm.isolate();
        ssm.exportJSON();
    }
}