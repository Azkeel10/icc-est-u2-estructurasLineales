import java.util.Queue;

import Controllers.QueueGeneric;
import Controllers.Stack;
import Controllers.StackGeneric;
import Models.Persona;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("----------Programa funcionando----------");
//-------------------------------------------------------------------------------
        System.out.println("\n----------Pila - Stack_Node----------");
        Stack stack = new Stack();

        stack.push(10);
        stack.push(-1);
        stack.push(5);
        stack.push(8);
        
        System.out.println("Tam= " + stack.size());

        stack.printStack();
        stack.pop();

        System.out.println("\nTam= " + stack.size());

        stack.printStack();
//-------------------------------------------------------------------------------
        System.out.println("\n----------Pila - StackGeneric_NodeGeneric----------");
        StackGeneric<Integer> stackG = new StackGeneric<>();

        stackG.push(10);
        stackG.push(8);
        stackG.push(-1);
        stackG.push(5);
        
        System.out.println("Tam= " + stackG.size());

        stackG.printStack();
        stackG.pop();

        System.out.println("\nTam= " + stackG.size());

        stackG.printStack();
//-------------------------------------------------------------------------------
        System.out.println("\n----------Cola - QueueGeneric_NodeGeneric----------");

        Persona p1 = new Persona("Juan");
        Persona p2 = new Persona("Maria");
        Persona p3 = new Persona("Pedro");
        Persona p4 = new Persona("David");

        QueueGeneric<Persona> colaPersonas = new QueueGeneric<Persona>();

        colaPersonas.add(p1);
        colaPersonas.add(p2);
        colaPersonas.add(p3);
        colaPersonas.printCola();
        System.out.println("\nPersona atendida -> " + colaPersonas.remove());
        colaPersonas.printCola();

        System.out.println();

        Persona pB = colaPersonas.findByName("Juan");
        System.out.println("\nPersona encontrada -> " + (pB != null? pB:"ninguna"));
        Persona pE = colaPersonas.deleteByName("Pedro");
        System.out.println("\nPersona eliminada -> " + (pE != null? pE:"ninguna"));
        colaPersonas.printCola();
    }
}
